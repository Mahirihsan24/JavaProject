import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class AirlineReservationSystem extends JFrame {
    private HashMap<Integer, Flight> flights;
    private JTextField flightNumberField;
    private JTextField originField;
    private JTextField destinationField;
    private JTextField departureDateField;
    private JTextField arrivalDateField;
    private JComboBox<FlightClass> flightClassComboBox;
    private JButton addFlightButton;
    private JButton displayFlightsButton;
    private JButton cancelFlightButton;
    private JButton displayPassengersButton;
    private JButton updateFlightStatusButton;
    private JButton updatePassengerInfoButton;
    private JButton displayAvailableSeatsButton;
    private JButton generateReceiptButton;
    private JTextArea flightsTextArea;
    private JTextField departureTimeField;
    private JTextField arrivalTimeField;
    private JTextField passengerNameField;
    private JTextField passengerPassportNumberField;
    private JComboBox<FlightClass> passengerFlightClassComboBox;
    private JButton bookPassengerButton;
    private JTextArea bookingDetailsTextArea;

    public AirlineReservationSystem() {
        flights = new HashMap<>();

        // Create GUI components
        flightNumberField = new JTextField(10);
        originField = new JTextField(10);
        destinationField = new JTextField(10);
        departureDateField = new JTextField(10);
        arrivalDateField = new JTextField(10);
        flightClassComboBox = new JComboBox<>(FlightClass.values());
        addFlightButton = new JButton("Add Flight");
        displayFlightsButton = new JButton("Display Flights");
        cancelFlightButton = new JButton("Cancel Flight");
        displayPassengersButton = new JButton("Display Passengers");
        updateFlightStatusButton = new JButton("Update Flight Status");
        updatePassengerInfoButton = new JButton("Update Passenger Info");
        displayAvailableSeatsButton = new JButton("Display Available Seats");
        departureTimeField = new JTextField(10);
        arrivalTimeField = new JTextField(10);
        generateReceiptButton = new JButton("Generate Receipt");
        flightsTextArea = new JTextArea(10, 20);

        passengerNameField = new JTextField(10);
        passengerPassportNumberField = new JTextField(10);
        passengerFlightClassComboBox = new JComboBox<>(FlightClass.values());
        bookPassengerButton = new JButton("Book Passenger");
        bookingDetailsTextArea = new JTextArea(10, 20);

        // Add action listeners to buttons
        addFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });
        displayFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFlights();
            }
        });
        cancelFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFlight();
            }
        });
        displayPassengersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPassengers();
            }
        });
        updateFlightStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFlightStatus();
            }
        });
        updatePassengerInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePassengerInfo();
            }
        });
        displayAvailableSeatsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAvailableSeats();
            }
        });
        generateReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReceipt();
            }
        });
        bookPassengerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookPassenger();
            }
        });

        // Create GUI layout
        // Create GUI layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create flight panel
        JPanel flightPanel = new JPanel();
        flightPanel.setLayout(new BorderLayout());

        JPanel flightInfoPanel = new JPanel();
        flightInfoPanel.setLayout(new BoxLayout(flightInfoPanel, BoxLayout.Y_AXIS));
        flightInfoPanel.add(new JLabel("Flight Number:"));
        flightInfoPanel.add(flightNumberField);
        flightInfoPanel.add(new JLabel("Origin:"));
        flightInfoPanel.add(originField);
        flightInfoPanel.add(new JLabel("Destination:"));
        flightInfoPanel.add(destinationField);
        flightInfoPanel.add(new JLabel("Departure Date:"));
        flightInfoPanel.add(departureDateField);
        flightInfoPanel.add(new JLabel("Departure Time:"));
        flightInfoPanel.add(departureTimeField);
        flightInfoPanel.add(new JLabel("Arrival Date:"));
        flightInfoPanel.add(arrivalDateField);
        flightInfoPanel.add(new JLabel("Arrival Time:"));
        flightInfoPanel .add(arrivalTimeField);
        flightInfoPanel.add(new JLabel("Flight Class:"));
        flightInfoPanel.add(flightClassComboBox);

        JPanel flightButtonPanel = new JPanel();
        flightButtonPanel.setLayout(new FlowLayout());
        flightButtonPanel.add(addFlightButton);
        flightButtonPanel.add(displayFlightsButton);
        flightButtonPanel.add(cancelFlightButton);
        flightButtonPanel.add(updateFlightStatusButton);
        flightButtonPanel.add(updatePassengerInfoButton);
        flightButtonPanel.add(displayAvailableSeatsButton);
        flightButtonPanel.add(generateReceiptButton);

        flightPanel.add(flightInfoPanel, BorderLayout.CENTER);
        flightPanel.add(flightButtonPanel, BorderLayout.SOUTH);

        // Create passenger panel
        JPanel passengerPanel = new JPanel();
        passengerPanel.setLayout(new BorderLayout());

        JPanel passengerInfoPanel = new JPanel();
        passengerInfoPanel.setLayout(new BoxLayout(passengerInfoPanel, BoxLayout.Y_AXIS));
        passengerInfoPanel.add(new JLabel("Passenger Name:"));
        passengerInfoPanel.add(passengerNameField);
        passengerInfoPanel.add(new JLabel("Passport Number:"));
        passengerInfoPanel.add(passengerPassportNumberField);
        passengerInfoPanel.add(new JLabel("Flight Class:"));
        passengerInfoPanel.add(passengerFlightClassComboBox);

        JPanel passengerButtonPanel = new JPanel();
        passengerButtonPanel.setLayout(new FlowLayout());
        passengerButtonPanel.add(bookPassengerButton);

        passengerPanel.add(passengerInfoPanel, BorderLayout.CENTER);
        passengerPanel.add(passengerButtonPanel, BorderLayout.SOUTH);

        // Create text area panel
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.add(new JScrollPane(flightsTextArea), BorderLayout.CENTER);
        textAreaPanel.add(new JScrollPane(bookingDetailsTextArea), BorderLayout.EAST);

        // Add panels to main panel
        panel.add(flightPanel, BorderLayout.NORTH);
        panel.add(textAreaPanel, BorderLayout.CENTER);
        panel.add(passengerPanel, BorderLayout.SOUTH);

        add(panel);

        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        LoginWindow loginWindow = new LoginWindow(this);
        setVisible(false);
    }

    private void addFlight() {
            int flightNumber = Integer.parseInt(flightNumberField.getText());
            String origin = originField.getText();
            String destination = destinationField.getText();
            String departureDateStr = departureDateField.getText();
            String departureTimeStr = departureTimeField.getText();
            String arrivalDateStr = arrivalDateField.getText();
            String arrivalTimeStr = arrivalTimeField.getText();
            FlightClass flightClass = (FlightClass) flightClassComboBox.getSelectedItem();

            try {
                LocalDate departureDate = LocalDate.parse(departureDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalTime departureTime = LocalTime.parse(departureTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
                LocalDate arrivalDate = LocalDate.parse(arrivalDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalTime arrivalTime = LocalTime.parse(arrivalTimeStr, DateTimeFormatter.ofPattern("HH:mm"));

                Flight flight = new Flight(flightNumber, origin, destination, departureDateStr, departureTimeStr, arrivalDateStr, arrivalTimeStr, flightClass);
                flights.put(flightNumber, flight);

                JOptionPane.showMessageDialog(null, "Flight added successfully");
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Invalid date or time format. Please use yyyy-MM-dd for dates and HH:mm for times.");
            }
        }

    private void displayFlights() {
            flightsTextArea.setText("");
            if (flights.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No flights available.");
            } else {
                flightsTextArea.append("Flight Information:\n\n");
                flightsTextArea.append(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Flight Number", "Origin", "Destination", "Departure Date", "Departure Time", "Arrival Date", "Arrival Time", "Flight Status"));
                flightsTextArea.append("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for (Flight flight : flights.values()) {
                    flightsTextArea.append(String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", flight.getFlightNumber(), flight.getOrigin(), flight.getDestination(), flight.getDepartureDateStr(), flight.getDepartureTimeStr(), flight.getArrivalDateStr(), flight.getArrivalTimeStr(), flight.getStatus()));
                }
            }
        }

    private void cancelFlight() {
        flightsTextArea.setText("");
        if (flights.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No flights available.");
        } else {
            int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
            if (flights.containsKey(flightNumber)) {
                flights.remove(flightNumber);
                JOptionPane.showMessageDialog(null, "Flight cancelled successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Flight not found");
            }
        }
    }

    private void displayPassengers() {
    int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
    if (flights.containsKey(flightNumber)) {
        Flight flight = flights.get(flightNumber);
        if (flight.getPassengers().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No passengers booked on this flight.");
        } else {
            for (int i = 0; i < flight.getPassengers().size(); i++) {
                Passenger passenger = flight.getPassengers().get(i);
                StringBuilder passengerInfo = new StringBuilder();
                passengerInfo.append("Passenger ").append(i + 1).append(" Information:\n");
                passengerInfo.append("Name: ").append(passenger.getName()).append("\n");
                passengerInfo.append("Passport Number: ").append(passenger.getPassportNumber()).append("\n");
                passengerInfo.append("Flight Class: ").append(passenger.getFlightClass()).append("\n");
                passengerInfo.append("Flight Number: ").append(flightNumber).append("\n");
                passengerInfo.append("Origin: ").append(flight.getOrigin()).append("\n");
                passengerInfo.append("Destination: ").append(flight.getDestination()).append("\n");
                passengerInfo.append("Departure Date: ").append(flight.getDepartureDateStr()).append("\n");
                passengerInfo.append("Departure Time: ").append(flight.getDepartureTimeStr()).append("\n");
                passengerInfo.append("Arrival Date: ").append(flight.getArrivalDateStr()).append("\n");
                passengerInfo.append("Arrival Time: ").append(flight.getArrivalTimeStr()).append("\n");
                passengerInfo.append("\n");
                JOptionPane.showMessageDialog(null, passengerInfo.toString());
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Flight not found");
    }
}

    // Update Flight Status
    private void updateFlightStatus() {
        int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
        if (flights.containsKey(flightNumber)) {
            Flight flight = flights.get(flightNumber);
            String[] options = {"SCHEDULED", "DELAYED", "CANCELED", "DEPARTED", "ARRIVED"};
            String selectedOption = (String) JOptionPane.showInputDialog(null, "Select flight status", "Flight Status", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (selectedOption.equals("ARRIVED") && !flight.getStatus().equals(FlightStatus.DEPARTED)) {
                JOptionPane.showMessageDialog(null, "Flight cannot be ARRIVED if it has not DEPARTED first.");
            } else if (selectedOption.equals("DEPARTED") && !flight.getStatus().equals(FlightStatus.SCHEDULED)) {
                JOptionPane.showMessageDialog(null, "Flight cannot be DEPARTED if it is not SCHEDULED.");
            } else if (selectedOption.equals("CANCELED") && flight.getStatus().equals(FlightStatus.DEPARTED)) {
                JOptionPane.showMessageDialog(null, "Flight cannot be CANCELED if it has already DEPARTED.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the flight status to " + selectedOption + "?", "Confirm Update", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    flight.setStatus(String.valueOf(FlightStatus.valueOf(selectedOption)));
                    JOptionPane.showMessageDialog(null, "Flight status updated successfully");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Flight not found");
        }
    }

    // Update Passenger Info
    private void updatePassengerInfo() {
        int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
        if (flights.containsKey(flightNumber)) {
            Flight flight = flights.get(flightNumber);
            String passengerName = JOptionPane.showInputDialog("Enter passenger name:");
            for (Passenger passenger : flight.getPassengers()) {
                if (passenger.getName().equals(passengerName)) {
                    String newName = JOptionPane.showInputDialog("Enter new name:");
                    String newPassportNumber = JOptionPane.showInputDialog("Enter new passport number:");
                    String[] options = {"ECONOMY", "PREMIUM_ECONOMY", "BUSINESS", "FIRST_CLASS"};
                    String selectedOption = (String) JOptionPane.showInputDialog(null, "Select flight class", "Flight Class", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the passenger info?", "Confirm Update", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        passenger.setName(newName);
                        passenger.setPassportNumber(newPassportNumber);
                        passenger.setFlightClass(FlightClass.valueOf(selectedOption));

                    // Update passenger panel
                    passengerNameField.setText(passenger.getName());
                    passengerPassportNumberField.setText(passenger.getPassportNumber());
                    passengerFlightClassComboBox.setSelectedItem(passenger.getFlightClass());

                    JOptionPane.showMessageDialog(null, "Passenger info updated successfully");
                }
                return;
            }
        }
            JOptionPane.showMessageDialog(null, "Passenger not found");
        } else {
        JOptionPane.showMessageDialog(null, "Flight not found");
        }
    }

    private void displayAvailableSeats() {
        int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
        if (flights.containsKey(flightNumber)) {
            Flight flight = flights.get(flightNumber);
            int availableSeats = flight.getAvailableSeats();
            JOptionPane.showMessageDialog(null, "Available seats: " + availableSeats);
        } else {
            JOptionPane.showMessageDialog(null, "Flight not found");
        }
    }

    private void generateReceipt() {
        int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
        if (flights.containsKey(flightNumber)) {
            Flight flight = flights.get(flightNumber);
            String passengerName = JOptionPane.showInputDialog("Enter passenger name:");
            for (Passenger passenger : flight.getPassengers()) {
                if (passenger.getName().equals(passengerName)) {
                    StringBuilder receipt = new StringBuilder();
                    receipt.append("Flight Number: ").append(flightNumber).append("\n");
                    receipt.append("Passenger Name: ").append(passengerName).append("\n");
                    receipt.append("Flight Class: ").append(passenger.getFlightClass()).append("\n");
                    receipt.append("Origin: ").append(flight.getOrigin()).append("\n");
                    receipt.append("Destination: ").append(flight.getDestination()).append("\n");
                    receipt.append("Arrival Date: ").append(flight.getArrivalDate()).append("\n");
                    receipt.append("Flight Status: ").append(flight.getStatus()).append("\n");
                    receipt.append("Ticket Price: ").append(getTicketPrice(flight, passenger)).append("\n");
                    JOptionPane.showMessageDialog(null, receipt.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Passenger not found");
        } else {
            JOptionPane.showMessageDialog(null, "Flight not found");
        }
    }

    // Book Passenger
    private void bookPassenger() {
        int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
        if (flights.containsKey(flightNumber)) {
            Flight flight = flights.get(flightNumber);
            String passengerName = passengerNameField.getText();
            String passportNumber = passengerPassportNumberField.getText();
            String[] options = {"ECONOMY", "PREMIUM_ECONOMY", "BUSINESS", "FIRST_CLASS"};
            String selectedOption = (String) JOptionPane.showInputDialog(null, "Select flight class", "Flight Class", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            FlightClass flightClass = FlightClass.valueOf(selectedOption);

            Passenger passenger = new Passenger(passengerName, passportNumber, flightClass);
            flight.addPassenger(passenger);

            StringBuilder bookingDetails = new StringBuilder();
            bookingDetails.append("Flight Number: ").append(flightNumber).append("\n");
            bookingDetails.append("Passenger Name: ").append(passengerName).append("\n");
            bookingDetails.append("Passport Number: ").append(passportNumber).append("\n");
            bookingDetails.append("Flight Class: ").append(flightClass).append("\n");
            bookingDetails.append("Origin: ").append(flight.getOrigin()).append("\n");
            bookingDetails.append("Destination: ").append(flight.getDestination()).append("\n");
            bookingDetails.append("Arrival Date: ").append(flight.getArrivalDate()).append("\n");
            bookingDetails.append("Flight Status: ").append(flight.getStatus()).append("\n");
            bookingDetails.append("Ticket Price: ").append(getTicketPrice(flight, passenger)).append("\n");
            bookingDetailsTextArea.setText(bookingDetails.toString());

            JOptionPane.showMessageDialog(null, "Passenger booked successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Flight not found");
        }
    }

    // Get Ticket Price
    private double getTicketPrice(Flight flight, Passenger passenger) {
        double basePrice = 100;
        switch (passenger.getFlightClass()) {
            case ECONOMY:
                return basePrice;
            case PREMIUM_ECONOMY:
                return basePrice * 1.5;
            case BUSINESS:
                return basePrice * 2;
            case FIRST_CLASS:
                return basePrice * 3;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        new AirlineReservationSystem();
    }
}