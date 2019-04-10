package pkj1;

public class Trips_reservation extends Trips {
    private String User;
    private String Driver;

    public Trips_reservation(String from, String to, String vehicle, String ticketPrice, String availableSeats, String user, String driver) {
        super(from, to, vehicle, ticketPrice, availableSeats);
        this.User = user;
        this.Driver = driver;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        this.User = user;
    }

    public String getDriver() {
        return Driver;
    }



    public void setDriver(String driver) {
        this.Driver = driver;
    }

}
