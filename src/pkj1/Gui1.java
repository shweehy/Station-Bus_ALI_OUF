package pkj1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui1 extends Gui{
    void User_Screen(int flage) {
        Scene s1;
        TableView<Trips> table;
        TableView<Trips_reservation> table1;
        ComboBox<String> C1_To = new ComboBox<String>();
        ComboBox<String> C1_From = new ComboBox<String>();
        ComboBox<String> C1_Vechile = new ComboBox<String>();
        TextField T_price = new TextField();
        T_price.setPromptText("Enter Price");
        TextField T_Seats = new TextField();
        T_Seats.setPromptText("Enter Seats number");
        T_price.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?"))
                    T_price.setText(oldValue);
            }
        });
        T_Seats.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (!newValue.matches("\\d{0,7}(\\d{0,4})?"))
                    T_Seats.setText(oldValue);
            }
        });
        C1_To.getItems().addAll("Alexandria","Cairo","Giza","Suez","Dahab");
        C1_From.setPromptText("From");
        C1_To.setPromptText("To");
        C1_Vechile.setPromptText("Select Vehicle");
        C1_From.getItems().addAll("Alexandria","Cairo","Giza","Suez","Dahab");
        C1_Vechile.getItems().addAll("Bus", "MiniBus", "Lemozine");
        Button b1 = new Button ("Reservation");
        Button b2 = new Button ("My Reservations");
        Button B_Summit = new Button("Summit");
        Button B_Delete_Reservation = new Button("Delete Trip");
        B_Delete_Reservation.setDisable(true);
        Label l_summit = new Label();
        Button b3 = new Button("Users");
        Button deleteButton = new Button ("Delete");
        Button b4 = new Button("Drivers");
        Button b6 = new Button("Reserved Trips");
        Button b5 = new Button("Add Trips");
        HBox h1 = new HBox(10);
        HBox h2 = new HBox(10);
        h1.getChildren().addAll(b1,b2,l_summit,B_Summit,B_Delete_Reservation);
        h2.getChildren().addAll(b3,b4,b5,b6,deleteButton);
        GridPane g1= new GridPane();
//        g1.setMinSize(600, 600);
        g1.setPadding(new Insets(20, 20, 20, 20));
        g1.setVgap(5);
        g1.setHgap(5);
        g1.setAlignment(Pos.CENTER);





        stage3 = new Stage();
        StackPane st = new StackPane(g1);
        st.setMinSize(600,500);

        if(flage==1){
            stage3.setTitle("Welcome Manger");
            Table t1 = new Table("Trips.txt");
            g1.add(h2,0,3);
            table=t1.table();
            g1.add(table,0,0);



            b5.setOnAction(e->{

                HBox H3 = new HBox(10);
                HBox H4 = new HBox(10);
                H3.getChildren().addAll(C1_From, C1_To, C1_Vechile, T_price, T_Seats);
                Button B_Add = new Button("Add the trip");
                Label lf = new Label("");
                H4.getChildren().addAll(lf,B_Add);
                H4.setAlignment(Pos.BOTTOM_RIGHT);
                VBox v1 = new VBox(10);
                v1.getChildren().addAll(H3, H4);
                Add_Trips = new Scene(v1);
                B_Add.setOnAction(ex->{
                    if(C1_From.getValue()==null||C1_To.getValue()==null||C1_Vechile.getValue()==null||T_price.getText().equals("")||T_Seats.getText().equals(""))
                        lf.setText("Cannot Add");
                    else
                    {
                        x.Add_trip(C1_To.getValue().toString(),C1_From.getValue().toString(),C1_Vechile.getValue().toString(),T_price.getText(),T_Seats.getText(),"Trips.txt");
                        lf.setText("Adding successful");
                    }
                });
                stage3.setScene(Add_Trips);



            });
            deleteButton.setOnAction(eb->{
                ObservableList<Trips> tripSelected , alltrips;
                String a = table.getSelectionModel().getSelectedItem().getFrom();
                String b = table.getSelectionModel().getSelectedItem().getTo();
                String c = table.getSelectionModel().getSelectedItem().getVehicle();
                String d = table.getSelectionModel().getSelectedItem().getTicketPrice();
                String e = table.getSelectionModel().getSelectedItem().getAvailableSeats();
                x.Delete_Item(a,b,c,d,e);
                alltrips = table.getItems();
                tripSelected = table.getSelectionModel().getSelectedItems();
                tripSelected.forEach(alltrips::remove);



            });

        }
        else if (flage==3){
            stage3.setTitle("Welcome User");
            Table t1 = new Table("Trips.txt");
            Table t2 = new Table("Reserved.txt");
            g1.add(h1,0,3);
            table=t1.table();
            // driver here is not constatn
            driver = 0;
            table1 = t2.table_re(id, driver);
            b2.setOnAction(ed->{
                g1.getChildren().remove(table);
                g1.getChildren().remove(table1);
                t1.table();
                g1.add(table1,0,0);
                l_summit.setText("");
                B_Delete_Reservation.setDisable(false);
                B_Summit.setDisable(true);

            });
            b1.setOnAction(ec->{
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table);
                t2.table_re(id,driver);
                g1.add(table,0,0);
                l_summit.setText("");
                B_Delete_Reservation.setDisable(true);
                B_Summit.setDisable(false);

            });
            B_Summit.setOnAction(ef->{
                ObservableList<Trips> tripSelected , alltrips;
                String a = table.getSelectionModel().getSelectedItem().getFrom();
                String b = table.getSelectionModel().getSelectedItem().getTo();
                String c = table.getSelectionModel().getSelectedItem().getVehicle();
                String d = table.getSelectionModel().getSelectedItem().getTicketPrice();
                String e = table.getSelectionModel().getSelectedItem().getAvailableSeats();
                String f = Integer.toString(id);
                x.Add_trip1(a,b,c,d,e,f,"Reserved.txt");
                l_summit.setText("Summit successfully");


            });
            B_Delete_Reservation.setOnAction(ef->{
                ObservableList<Trips_reservation> tripSelected , alltrips;
                String a = table1.getSelectionModel().getSelectedItem().getFrom();
                String b = table1.getSelectionModel().getSelectedItem().getTo();
                String c = table1.getSelectionModel().getSelectedItem().getVehicle();
                String d = table1.getSelectionModel().getSelectedItem().getTicketPrice();
                String e = table1.getSelectionModel().getSelectedItem().getAvailableSeats();
                String f = table1.getSelectionModel().getSelectedItem().getUser();
                x.Delete_Item_Reserved(a,b,c,d,e,f);
                alltrips = table1.getItems();
                tripSelected = table1.getSelectionModel().getSelectedItems();
                tripSelected.forEach(alltrips::remove);
            });

        }
        else{
            stage3.setTitle("Welcome Driver");
//            s1 = new Scene(h1);
            s1=null;

        }
        s1 = new Scene(st);
        stage3.setScene(s1);
        stage3.show();

    }

}
