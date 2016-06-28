package view.factories;

import dtos.FlightDTO;
import view.models.FlightVM;

public interface IFlightVMFactory {
    FlightVM create(FlightDTO dto);
}
