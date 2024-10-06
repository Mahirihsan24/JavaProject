public class Passenger {
    private String name;
    private String passportNumber;
    private FlightClass flightClass;

    public Passenger(String name, String passportNumber, FlightClass flightClass) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.flightClass = flightClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", flightClass=" + flightClass +
                '}';
    }
}