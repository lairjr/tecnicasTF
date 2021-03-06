package view.factories;

import dtos.FlightDTO;
import view.models.FlightVM;

public class FlightVMFactory implements IFlightVMFactory {
    private static FlightVMFactory instance;

    private FlightVMFactory() { }

    public static FlightVMFactory getInstance() {
        if (instance == null)
            instance = new FlightVMFactory();

        return instance;
    }

    @Override
    public FlightVM create(FlightDTO dto) {
        return new FlightVM(dto);
    }
}
