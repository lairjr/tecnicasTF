package infrastructure.mocks;

import domain.IFlightService;
import dtos.FlightDTO;

import java.time.LocalDateTime;

public class FlightGenerator {
    private IFlightService flightService;
    private static FlightGenerator instance;

    private FlightGenerator(IFlightService flightService) {
        this.flightService = flightService;
    }

    public static FlightGenerator getInstance(IFlightService flightService) {
        if (instance == null)
            instance = new FlightGenerator(flightService);

        return instance;
    }


    public void generateFlightsMocks() {
        generateSaoPaulo();
        generateBuenosAires();
        generateFlorianopolis();
        generateCuritiba();
        generateSantiago();
    }

    private void generateSantiago() {
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Santiago",
                LocalDateTime.of(2016, 5, 1, 8, 0),
                LocalDateTime.of(2016, 5, 1, 11, 0),
                false, 1300));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Santiago",
                LocalDateTime.of(2016, 5, 1, 13, 30),
                LocalDateTime.of(2016, 5, 1, 16, 30),
                false, 1300));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Santiago",
                LocalDateTime.of(2016, 5, 1, 19, 0),
                LocalDateTime.of(2016, 5, 1, 22, 0),
                false, 1300));
    }

    private void generateCuritiba() {
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Curitiba",
                LocalDateTime.of(2016, 5, 1, 8, 30),
                LocalDateTime.of(2016, 5, 1, 9, 45),
                false, 300));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Curitiba",
                LocalDateTime.of(2016, 5, 1, 13, 30),
                LocalDateTime.of(2016, 5, 1, 14, 45),
                false, 300));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Curitiba",
                LocalDateTime.of(2016, 5, 1, 21, 45),
                LocalDateTime.of(2016, 5, 1, 23, 0),
                false, 300));
    }

    private void generateSaoPaulo() {
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "São Paulo",
                LocalDateTime.of(2016, 5, 1, 10, 0),
                LocalDateTime.of(2016, 5, 1, 11, 30),
                false, 250));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "São Paulo",
                LocalDateTime.of(2016, 5, 1, 15, 30),
                LocalDateTime.of(2016, 5, 1, 17, 0),
                false, 250));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "São Paulo",
                LocalDateTime.of(2016, 5, 1, 21, 0),
                LocalDateTime.of(2016, 5, 1, 22, 30),
                false, 250));
    }

    private void generateBuenosAires() {
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Buenos Aires",
                LocalDateTime.of(2016, 5, 1, 9, 0),
                LocalDateTime.of(2016, 5, 1, 1, 45),
                true, 700));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Buenos Aires",
                LocalDateTime.of(2016, 5, 1, 17, 30),
                LocalDateTime.of(2016, 5, 1, 19, 15),
                true, 700));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Buenos Aires",
                LocalDateTime.of(2016, 5, 1, 20, 30),
                LocalDateTime.of(2016, 5, 1, 22, 15),
                true, 700));
    }

    private void generateFlorianopolis() {
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Florianópolis",
                LocalDateTime.of(2016, 5, 1, 10, 15),
                LocalDateTime.of(2016, 5, 1, 11, 0),
                false, 150));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Florianópolis",
                LocalDateTime.of(2016, 5, 1, 13, 15),
                LocalDateTime.of(2016, 5, 1, 14, 0),
                false, 150));
        generateFlights(new FlightDTO(0,
                "Porto Alegre",
                "Florianópolis",
                LocalDateTime.of(2016, 5, 1, 19, 10),
                LocalDateTime.of(2016, 5, 1, 19, 55),
                false, 150));
    }

    private void generateFlights(FlightDTO flightInfo) {
        LocalDateTime departureDate = flightInfo.getDepartureDate();
        LocalDateTime arrivalDate = flightInfo.getArrivalDate();

        for (int x = 0; x < 60; x++) {
            FlightDTO flight = new FlightDTO(0,
                    flightInfo.getDepartureLocale(),
                    flightInfo.getArrivalLocale(),
                    departureDate,
                    arrivalDate,
                    flightInfo.getInternational(),
                    flightInfo.getPrice());

            flightService.insert(flight);

            departureDate = departureDate.plusDays(1);
            arrivalDate = arrivalDate.plusDays(1);
        }
    }

}
