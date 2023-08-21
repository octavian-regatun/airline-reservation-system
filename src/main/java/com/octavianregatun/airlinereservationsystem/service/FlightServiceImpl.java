package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Aircraft;
import com.octavianregatun.airlinereservationsystem.entity.Airport;
import com.octavianregatun.airlinereservationsystem.entity.Flight;
import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import com.octavianregatun.airlinereservationsystem.exception.CustomException;
import com.octavianregatun.airlinereservationsystem.repository.FlightRepository;
import com.octavianregatun.airlinereservationsystem.rest.request.FlightRequest;
import com.octavianregatun.airlinereservationsystem.rest.response.FlightResponse;
import com.octavianregatun.airlinereservationsystem.rest.response.SeatResponse;
import com.octavianregatun.airlinereservationsystem.rest.response.TicketResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;
    AirportService airportService;
    AircraftService aircraftService;
    TicketService ticketService;

    FlightServiceImpl(FlightRepository flightRepository, AirportService airportService, AircraftService aircraftService, @Lazy TicketService ticketService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
        this.aircraftService = aircraftService;
        this.ticketService = ticketService;
    }

    @Override
    public Flight findById(int id) {
        if (flightRepository.findById(id).isPresent())
            return flightRepository.findById(id).get();
        throw new CustomException("Flight with id " + id + " not found");
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Flight save(FlightRequest flightRequest) {
        Aircraft aircraft = aircraftService.findById(flightRequest.getAircraftId());

        Airport departureAirport = airportService.findById(flightRequest.getDepartureAirportId());
        Airport arrivalAirport = airportService.findById(flightRequest.getArrivalAirportId());

        Flight flight = new Flight();
        flight.setAircraft(aircraft);
        flight.setDepartureAirport(departureAirport);
        flight.setArrivalAirport(arrivalAirport);
        flight.setDepartureTime(flightRequest.getDepartureTime());
        flight.setArrivalTime(flightRequest.getArrivalTime());
        flight.setPrice(flightRequest.getPrice());
        flight.setTotalSeats(aircraft.getCapacity());
        flight.setAvailableSeats(aircraft.getCapacity());

        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public float getTicketPrice(int flightId) {
        return flightRepository.findById(flightId).orElse(null).getPrice();
    }

    @Override
    public void deleteById(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public FlightResponse getFlightResponse(Flight flight, boolean withTickets) {
        FlightResponse flightResponse = new FlightResponse();

        flightResponse.setId(flight.getId());
        flightResponse.setAircraft(aircraftService.findById(flight.getAircraft().getId()));
        flightResponse.setDepartureAirport(airportService.findById(flight.getDepartureAirport().getId()));
        flightResponse.setArrivalAirport(airportService.findById(flight.getArrivalAirport().getId()));
        flightResponse.setDepartureTime(flight.getDepartureTime());
        flightResponse.setArrivalTime(flight.getArrivalTime());
        flightResponse.setPrice(flight.getPrice());
        flightResponse.setTotalSeats(flight.getTotalSeats());
        flightResponse.setAvailableSeats(flight.getAvailableSeats());
        if (withTickets) {
            List<TicketResponse> ticketResponses = ticketService.getTicketResponses(flight.getTickets(), false);
            flightResponse.setTickets(ticketResponses);
        }
        return flightResponse;
    }

    @Override
    public List<FlightResponse> getFlightResponseList(List<Flight> flights, boolean withTickets) {
        List<FlightResponse> flightResponses = new ArrayList<>();

        for (Flight flight : flights) {
            flightResponses.add(getFlightResponse(flight, withTickets));
        }

        return flightResponses;
    }

    @Override
    public List<SeatResponse> getUnavailableSeats(int flightId) {
        List<SeatResponse> seatResponses = new ArrayList<>();

        Flight flight = findById(flightId);
        List<Ticket> tickets = flight.getTickets();

        for (Ticket ticket : tickets) {
            SeatResponse seatResponse = new SeatResponse();
            seatResponse.setRow(ticket.getSeatRow());
            seatResponse.setColumn(ticket.getSeatColumn());
            seatResponses.add(seatResponse);
        }

        return seatResponses;
    }

    @Override
    public List<List<SeatResponse>> getSeats(int flightId) {
        List<List<SeatResponse>> seats = new ArrayList<>();
        Flight flight = findById(flightId);

        int totalSeats = flight.getAircraft().getCapacity();
        int columns = 6;
        int rows = (int) Math.ceil((float) totalSeats / columns);

        for (int i = 0; i < rows; i++) {
            seats.add(new ArrayList<>());
        }

        for (int i = 0; i < totalSeats; i++) {
            int row = i / columns;
            char column = (char) ('A' + (i % columns));

            SeatResponse seat = new SeatResponse();

            seat.setRow(row + 1);
            seat.setColumn(column);
            seat.setIsAvailable(true);

            if (getUnavailableSeats(flightId).contains(seat)) {
                seat.setIsAvailable(false);
            }

            seats.get(row).add(seat);
        }

        return seats;
    }

    @Override
    public List<Flight> filterByMaximumPrice(List<Flight> flights, float maximumPrice) {
        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight flight : flights) {
            if (flight.getPrice() <= maximumPrice) {
                filteredFlights.add(flight);
            }
        }

        return filteredFlights;
    }
}
