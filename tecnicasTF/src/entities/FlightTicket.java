package entities;

public class FlightTicket {
	private int localeNumber;
	private Passenger passenger;
	private FlightPlan flight;
	private FlightSeat selectedSeat;
	private int Status;
	
	public int getLocaleNumber() {
		return localeNumber;
	}
	public void setLocaleNumber(int localeNumber) {
		this.localeNumber = localeNumber;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public FlightPlan getFlight() {
		return flight;
	}
	public void setFlight(FlightPlan flight) {
		this.flight = flight;
	}
	public FlightSeat getSelectedSeat() {
		return selectedSeat;
	}
	public void setSelectedSeat(FlightSeat selectedSeat) {
		this.selectedSeat = selectedSeat;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
}
