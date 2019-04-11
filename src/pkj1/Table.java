package pkj1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.ArrayList;

public class Table extends files {
    private String fileName;

    Table() {
        this.fileName = null;
    }

    Table(String fileName) {
        this.fileName = fileName;
    }

    TableView<Trips> table() {
        TableView<Trips> table;


        TableColumn<Trips, String> fromColumn = new TableColumn<>("From");
        fromColumn.setMinWidth(100);
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));

        TableColumn<Trips, String> toColumn = new TableColumn<>("To");
        toColumn.setMinWidth(100);
        toColumn.setCellValueFactory(new PropertyValueFactory<>("to"));

        TableColumn<Trips, String> vehicleColumn = new TableColumn<>("Vehicle");
        vehicleColumn.setMinWidth(100);
        vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

        TableColumn<Trips, String> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setMinWidth(120);
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));


        TableColumn<Trips, String> TicketPrice = new TableColumn<>("TicketPrice");
        TicketPrice.setMinWidth(100);
        TicketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));

        table = new TableView<>();
        table.setItems(getTrips());
        table.getColumns().addAll(fromColumn, toColumn, vehicleColumn, TicketPrice, availableSeatsColumn);
//        table.getColumns().addAll(fromColumn , toColumn , vehicleColumn , ticketPriceColumn , availableSeatsColumn);

        return table;

    }

    public ObservableList<Trips> getTrips() {
        ObservableList<Trips> trips = FXCollections.observableArrayList();
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        AList = ReadFile(fileName);
        String A[] = new String[6];
        for (int i = 0; i < AList.size(); i++) {
            for (int j = 0; j < 6; j++) {
                A[j] = AList.get(i).get(j);

            }
            trips.add(new Trips(((String) A[0]), A[1], A[2], A[3], A[4]));

        }

        return trips;


    }

    TableView<Trips_reservation> table_re(int d) {
        TableView<Trips_reservation> table;


        TableColumn<Trips_reservation, String> fromColumn = new TableColumn<>("From");
        fromColumn.setMinWidth(100);
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));

        TableColumn<Trips_reservation, String> toColumn = new TableColumn<>("To");
        toColumn.setMinWidth(100);
        toColumn.setCellValueFactory(new PropertyValueFactory<>("to"));

        TableColumn<Trips_reservation, String> vehicleColumn = new TableColumn<>("Vehicle");
        vehicleColumn.setMinWidth(100);
        vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

        TableColumn<Trips_reservation, String> TicketPrice = new TableColumn<>("TicketPrice");
        TicketPrice.setMinWidth(100);
        TicketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));

        TableColumn<Trips_reservation, String> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setMinWidth(120);
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));


        TableColumn<Trips_reservation, String> Usercolu = new TableColumn<>("User");
        Usercolu.setMinWidth(100);
        Usercolu.setCellValueFactory(new PropertyValueFactory<>("User"));

        TableColumn<Trips_reservation, String> Drivercolu = new TableColumn<>("Driver");
        Drivercolu.setMinWidth(100);
        Drivercolu.setCellValueFactory(new PropertyValueFactory<>("Driver"));


        table = new TableView<>();
        table.setItems(getTrips1(d));
        table.getColumns().addAll(fromColumn, toColumn, vehicleColumn, TicketPrice, availableSeatsColumn, Usercolu, Drivercolu);
//        table.getColumns().addAll(fromColumn , toColumn , vehicleColumn , ticketPriceColumn , availableSeatsColumn);

        return table;

    }

    public ObservableList<Trips_reservation> getTrips1(int d) {
//        Converter_Strings xo = new Converter_Strings();
        ObservableList<Trips_reservation> trips = FXCollections.observableArrayList();
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();

        AList = ReadFile(fileName);
        String A[] = new String[7];
        for (int i = 0; i < AList.size(); i++) {
            if (Integer.toString(d).equals(AList.get(i).get(5))) {
                for (int j = 0; j < 5; j++) {
                    A[j] = AList.get(i).get(j);
                    A[6] = AList.get(i).get(6);

                }
                A[5] = Searched_iD("users.txt", Integer.toString(d));
            }
            if (Integer.toString(d).equals(AList.get(i).get(5)))
                trips.add(new Trips_reservation(((String) A[0]), A[1], A[2], A[3], A[4], A[5], A[6]));
        }


        return trips;
    }


    TableView<Trips> table2(int d) {
        TableView<Trips> table;


        TableColumn<Trips, String> fromColumn = new TableColumn<>("From");
        fromColumn.setMinWidth(100);
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));

        TableColumn<Trips, String> toColumn = new TableColumn<>("To");
        toColumn.setMinWidth(100);
        toColumn.setCellValueFactory(new PropertyValueFactory<>("to"));

        TableColumn<Trips, String> vehicleColumn = new TableColumn<>("Vehicle");
        vehicleColumn.setMinWidth(100);
        vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("vehicle"));

        TableColumn<Trips, String> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setMinWidth(120);
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));


        TableColumn<Trips, String> TicketPrice = new TableColumn<>("TicketPrice");
        TicketPrice.setMinWidth(100);
        TicketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));

        table = new TableView<>();
        table.setItems(getTrips2(d));
        table.getColumns().addAll(fromColumn, toColumn, vehicleColumn);
//        table.getColumns().addAll(fromColumn , toColumn , vehicleColumn , ticketPriceColumn , availableSeatsColumn);

        return table;

    }

    public ObservableList<Trips> getTrips2(int d) {
        ObservableList<Trips> trips = FXCollections.observableArrayList();
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        AList = ReadFile(fileName);
        String A[] = new String[6];
        for (int i = 0; i < AList.size(); i++) {
            if (Integer.toString(d).equals(AList.get(i).get(5))) {

                for (int j = 0; j < 6; j++) {
                    A[j] = AList.get(i).get(j);

                }
                trips.add(new Trips(((String) A[0]), A[1], A[2], A[3], A[4]));

            }
        }
            return trips;



    }
}











//        trips.add(new Trips("Alexandria","Cairo","Bus","130.00" ,"75"));
//        trips.add(new Trips("Cairo","Giza","Limousine","80.00" ,"30"));
//        trips.add(new Trips("Paris","Madrid","Bus","280.00" ,"100"));
//        trips.add(new Trips("London","Liverpool","Minibus","180.00" ,"60"));