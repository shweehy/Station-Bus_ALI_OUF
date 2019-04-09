package pkj1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.ArrayList;

public class Table extends files{

    TableView<Trips> table (){
        TableView<Trips> table;


        TableColumn<Trips , String> fromColumn = new TableColumn<>("From");
        fromColumn.setMinWidth(200);
        fromColumn.setCellValueFactory(new PropertyValueFactory<>("from"));

        TableColumn<Trips , String> toColumn = new TableColumn<>("To");
        toColumn.setMinWidth(200);
        toColumn.setCellValueFactory(new PropertyValueFactory<>("to"));

        TableColumn<Trips , String> vehicleColumn = new TableColumn<>("Vehicle");
        vehicleColumn.setMinWidth(200);
        vehicleColumn.setCellValueFactory(new PropertyValueFactory<>("vehicle"));
//
//        TableColumn<Trips , String> ticketPriceColumn = new TableColumn<>("Ticket Price");
//        ticketPriceColumn.setMinWidth(200);
//        ticketPriceColumn.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));

        TableColumn<Trips , String> availableSeatsColumn = new TableColumn<>("Available Seats");
        availableSeatsColumn.setMinWidth(200);
        availableSeatsColumn.setCellValueFactory(new PropertyValueFactory<>("availableSeats"));


        TableColumn<Trips , String> TicketPrice = new TableColumn<>("TicketPrice");
         TicketPrice.setMinWidth(200);
         TicketPrice.setCellValueFactory(new PropertyValueFactory<>("Ticket price"));

        table = new TableView<>();
        table.setItems(getTrips());
        table.getColumns().addAll(fromColumn , toColumn , vehicleColumn , availableSeatsColumn ,TicketPrice);
//        table.getColumns().addAll(fromColumn , toColumn , vehicleColumn , ticketPriceColumn , availableSeatsColumn);
        return table;

    }
    public ObservableList<Trips> getTrips() {
        ObservableList<Trips> trips = FXCollections.observableArrayList();
        ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
        AList = ReadFile("Trips.txt");
        String A [] = new String[5];
        for (int i = 0 ; i<AList.size();i++){
            for (int j=0; j<5;j++){
                A[j]=AList.get(i).get(j);

            }
            trips.add(new Trips(((String) A[0]),A[1],A[2],A[3],A[4]));

        }
//        trips.add(new Trips("Alexandria","Cairo","Bus","130.00" ,"75"));
//        trips.add(new Trips("Cairo","Giza","Limousine","80.00" ,"30"));
//        trips.add(new Trips("Paris","Madrid","Bus","280.00" ,"100"));
//        trips.add(new Trips("London","Liverpool","Minibus","180.00" ,"60"));
        return trips;



    }
}
