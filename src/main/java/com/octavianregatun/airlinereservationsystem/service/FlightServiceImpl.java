package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Aircraft;
import com.octavianregatun.airlinereservationsystem.entity.Airport;
import com.octavianregatun.airlinereservationsystem.entity.Flight;
import com.octavianregatun.airlinereservationsystem.repository.FlightRepository;
import com.octavianregatun.airlinereservationsystem.rest.request.FlightRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;
    AirportService airportService;
    AircraftService aircraftService;

    FlightServiceImpl(FlightRepository flightRepository, AirportService airportService, AircraftService aircraftService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
        this.aircraftService = aircraftService;
    }

    @Override
    public Flight findById(int id) {
        return flightRepository.findById(id).orElse(null);
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
}
