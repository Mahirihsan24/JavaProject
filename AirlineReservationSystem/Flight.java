import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private FlightClass flightClass;
    private ArrayList<Passenger> passengers;
    private FlightStatus status;

    public Flight(int flightNumber, String origin, String destination, String departureDateStr, String departureTimeStr, String arrivalDateStr, String arrivalTimeStr, FlightClass flightClass) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = LocalDate.parse(departureDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.departureTime = LocalTime.parse(departureTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
        this.arrivalDate = LocalDate.parse(arrivalDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.arrivalTime = LocalTime.parse(arrivalTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
        this.flightClass = flightClass;
        this.passengers = new ArrayList<>();
        this.status = FlightStatus.SCHEDULED;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureDateStr() {
        return departureDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getDepartureTimeStr() {
        return departureTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getArrivalDateStr() {
        return arrivalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getArrivalTimeStr() {
        return arrivalTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = FlightStatus.valueOf(status);
    }

    public int getAvailableSeats() {
        return 100 - passengers.size();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                ", flightClass=" + flightClass +
                ", passengers=" + passengers +
                ", status=" + status +
                '}';
    }
}