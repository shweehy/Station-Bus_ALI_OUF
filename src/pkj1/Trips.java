package pkj1;

public class Trips {
    private String from;
    private String to;
    private String vehicle;
    private String ticketPrice;
    private String availableSeats;

    public Trips(){}

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Trips(String from, String to, String vehicle, String ticketPrice, String availableSeats) {
        this.from = from;
        this.to = to;
        this.vehicle = vehicle ;
        this.ticketPrice= ticketPrice;
        this.availableSeats = availableSeats;
    }

   }