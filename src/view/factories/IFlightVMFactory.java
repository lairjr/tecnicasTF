package view.factories;

import dtos.FlightDTO;
import view.models.FlightVM;

/**
 * Created by ljunior on 6/1/16.
 */
public interface IFlightVMFactory {
    FlightVM create(FlightDTO dto);
}
