package entities;

public class Passenger {
	private String name;
	private String nationalDocument;
	private String passport;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationalDocument() {
		return nationalDocument;
	}
	public void setNationalDocument(String nationalDocument) {
		this.nationalDocument = nationalDocument;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
}