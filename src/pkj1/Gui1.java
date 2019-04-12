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

public class Gui1 extends Gui {
    Converter_Strings convert = new Converter_Strings();
    int flager;//falger for deleting items from manger trips;
    int flager2;//flager for user
    void User_Screen(int flage, int id) {
        Scene s1;
        TableView<Trips> table;
        TableView<Trips> table2;
        TableView<Trips_reservation> table1;
        TableView<Trips_reservation> table3;

        ComboBox<String> C1_To = new ComboBox<String>();
        ComboBox<String> C1_From = new ComboBox<String>();
        ComboBox<String> C1_Vechile = new ComboBox<String>();
        ComboBox<String> C1_Driver = new ComboBox<String>();
        ComboBox<String> C1_Types = new ComboBox<String>();
        C1_Driver.setPromptText("Driver");
        C1_Types.setPromptText("Trip Type");
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
        C1_From.setPromptText("From");
        C1_To.setPromptText("To");
        C1_Vechile.setPromptText("Select Vehicle");
        C1_Types.getItems().addAll("Internal", "External");
        C1_Types.setOnAction(e->{
            if(C1_Types.getValue().equals("Internal"))
            {
                C1_To.getItems().removeAll("Berlin", "Paris", "Madrid", "Zurich", "London");
                C1_From.getItems().removeAll("Berlin", "Paris", "Madrid", "Zurich", "London");
                C1_Vechile.getItems().removeAll("Bus", "MiniBus", "Lemozine");


                C1_To.getItems().addAll("Alexandria", "Cairo", "Giza", "Suez", "Dahab");
                C1_From.getItems().addAll("Alexandria", "Cairo", "Giza", "Suez", "Dahab");
                C1_Vechile.getItems().addAll("Bus", "MiniBus", "Lemozine");
            }
            else
            {
                C1_To.getItems().removeAll("Alexandria", "Cairo", "Giza", "Suez", "Dahab");
                C1_From.getItems().removeAll("Alexandria", "Cairo", "Giza", "Suez", "Dahab");
                C1_Vechile.getItems().removeAll("Bus", "MiniBus", "Lemozine");

                C1_To.getItems().addAll("Berlin", "Paris", "Madrid", "Zurich", "London");
                C1_From.getItems().addAll("Berlin", "Paris", "Madrid", "Zurich", "London");
                C1_Vechile.getItems().addAll("Bus", "MiniBus", "Lemozine");
            }
        });
//        C1_To.getItems().addAll("Alexandria", "Cairo", "Giza", "Suez", "Dahab");
//        C1_From.getItems().addAll("Alexandria", "Cairo", "Giza", "Suez", "Dahab");
//        C1_Vechile.getItems().addAll("Bus", "MiniBus", "Lemozine");
//

        C1_Driver.getItems().addAll("Ahmed", "Shawky", "Mohamed","Yassa");

        Button b1 = new Button("Reservation-internal");
        Button b2 = new Button("My Reservations-internal");
        Button Button_Myreservation = new Button("My Reservations-external");
        Button Button_Trips = new Button("Reservations-external");
        Button B_Summit = new Button("Submit");
        Button B_Delete_Reservation = new Button("Delete Trip");
        B_Delete_Reservation.setDisable(true);
        Label l_summit = new Label();
        Label l_summit_prompt = new Label();
        Button b3 = new Button("Internal-Trips");
        Button deleteButton = new Button("Delete");
        deleteButton.setDisable(true);
        Button b4 = new Button("External-Trips");
        Button b6 = new Button("Reserved Trips");
        Button b5 = new Button("Add Trips");

        ToggleGroup g2 = new ToggleGroup();
        RadioButton One = new RadioButton("One-Way-trip");
        RadioButton Two = new RadioButton("Round-trip");
        One.setToggleGroup(g2);
        One.setSelected(true);
        Two.setToggleGroup(g2);

        ToggleGroup g3 = new ToggleGroup();
            RadioButton oone = new RadioButton("One stop");
        RadioButton non = new RadioButton("non-stop");
        RadioButton many = new RadioButton("many-stops");
        oone.setToggleGroup(g3);
        non.setToggleGroup(g3);
        many.setToggleGroup(g3);


        Label ls = new Label();

        HBox h1 = new HBox(10);
        HBox h2 = new HBox(10);
        HBox h3 = new HBox(100);
        HBox h4 = new HBox(10);
        HBox h5 = new HBox(10);
        HBox h6 = new HBox(10);

        h5.getChildren().addAll(One,Two);
        h6.getChildren().addAll(oone, non, many);

        h3.getChildren().addAll(h5,h6);
        h4.getChildren().addAll(l_summit,l_summit_prompt,ls);
        h1.getChildren().addAll(Button_Myreservation,Button_Trips,b1, b2,  B_Summit, B_Delete_Reservation);
        h2.getChildren().addAll(b3, b4, b5, b6, deleteButton);
        GridPane g1 = new GridPane();
//        g1.setMinSize(600, 600);
        g1.setPadding(new Insets(20, 20, 20, 20));
        g1.setVgap(5);
        g1.setHgap(5);
        g1.setAlignment(Pos.CENTER);


        stage3 = new Stage();
        StackPane st = new StackPane(g1);
        st.setMinSize(600, 500);

        if (flage == 1) {
            stage3.setTitle("Welcome Manger");
            Table t1 = new Table("Trips.txt");
            Table t3 = new Table("Trips_external.txt");

        //    driver = 0;
            Table t2 = new Table("Reserved.txt");

            g1.add(h2, 0, 3);
            table = t1.table();
            table2 = t3.table();
            //g1.add(table, 0, 0);
            table1 = t2.table_re(id);

            b5.setOnAction(e -> {
                HBox H3 = new HBox(10);
                HBox H4 = new HBox(10);
                H3.getChildren().addAll(C1_Types,C1_From, C1_To, C1_Vechile,C1_Driver, T_price, T_Seats);
                Button B_Add = new Button("Add the trip");
                Label lf = new Label("");
                H4.getChildren().addAll(lf, B_Add);
                H4.setAlignment(Pos.BOTTOM_RIGHT);
                VBox v1 = new VBox(10);
                v1.getChildren().addAll(H3, H4);
                Add_Trips = new Scene(v1);
                B_Add.setOnAction(ex -> {
                    if (C1_From.getValue() == null || C1_To.getValue() == null || C1_Vechile.getValue() == null || T_price.getText().equals("") || T_Seats.getText().equals("")|| C1_Driver.getValue() == null)
                        lf.setText("Cannot Add");
                    else {
                        String file1;
                        if (C1_Types.getValue().equals("Internal"))
                        file1 = "Trips.txt";
                        else {
                            file1 = "Trips_external.txt";
                        }
                        x.Add_trip( C1_From.getValue().toString(),C1_To.getValue().toString(), C1_Vechile.getValue().toString(), T_price.getText(), T_Seats.getText(), file1,convert.stringConverter_Driver(C1_Driver.getValue()));
                        lf.setText("Adding successful");
                    }
                });
                stage3.setScene(Add_Trips);


            });
            deleteButton.setOnAction(eb -> {
                ObservableList<Trips> tripSelected, alltrips;
                if (flager==2) {
                    String a = table.getSelectionModel().getSelectedItem().getFrom();
                    String b = table.getSelectionModel().getSelectedItem().getTo();
                    String c = table.getSelectionModel().getSelectedItem().getVehicle();
                    String d = table.getSelectionModel().getSelectedItem().getTicketPrice();
                    String e = table.getSelectionModel().getSelectedItem().getAvailableSeats();
                    x.Delete_Item(a, b, c, d, e,"Trips.txt");
                    alltrips = table.getItems();
                    tripSelected = table.getSelectionModel().getSelectedItems();
                    tripSelected.forEach(alltrips::remove);
                }
                else if (flager==1){
                    String a = table2.getSelectionModel().getSelectedItem().getFrom();
                    String b = table2.getSelectionModel().getSelectedItem().getTo();
                    String c = table2.getSelectionModel().getSelectedItem().getVehicle();
                    String d = table2.getSelectionModel().getSelectedItem().getTicketPrice();
                    String e = table2.getSelectionModel().getSelectedItem().getAvailableSeats();
                    x.Delete_Item(a, b, c, d, e,"Trips_external.txt");
                    alltrips = table2.getItems();
                    tripSelected = table2.getSelectionModel().getSelectedItems();
                    tripSelected.forEach(alltrips::remove);
                }

            });
            b4.setOnAction(e->{
                deleteButton.setDisable(false);
                g1.getChildren().remove(table);
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table2);
                t3.table();
                g1.add(table2, 0, 0);
                flager = 1;
            });
            b3.setOnAction(e->{
                deleteButton.setDisable(false);
                g1.getChildren().remove(table);
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table2);
                t1.table();
                g1.add(table, 0, 0);
                flager =2;



            });

            b6.setOnAction(e->{
                deleteButton.setDisable(true);
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table);
                g1.getChildren().remove(table2);
                t2.table_re(id);

                g1.add(table1, 0, 0);
            });

        } else if (flage == 3) {
            stage3.setTitle("Welcome User");

            Table t1 = new Table("Trips.txt");
            Table t2 = new Table("Reserved.txt");
            Table t3 = new Table("Reserved_external.txt");
            Table t4 = new Table("Trips_external.txt");

            g1.add(h1, 0, 5);
            g1.add(h4, 0, 4);
            g1.add(h3, 0, 3);

            table = t1.table();
            table1 = t2.table_re(id);
            table2 = t4.table();
            table3 = t3.table_re(id);
            b2.setOnAction(ed -> {
                flager2=1;
                g1.getChildren().remove(table);
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table2);
                g1.getChildren().remove(table3);
                t1.table();
                table1.refresh();
                g1.add(table1, 0, 0);
                l_summit.setText("");
                B_Delete_Reservation.setDisable(false);
                B_Summit.setDisable(true);

            });
            Button_Myreservation.setOnAction(ed -> {
                flager2 =2;
                g1.getChildren().remove(table);
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table2);
                g1.getChildren().remove(table3);
                t1.table();
                table1.refresh();
                g1.add(table3, 0, 0);
                l_summit.setText("");
                B_Delete_Reservation.setDisable(false);
                B_Summit.setDisable(true);

            });
            b1.setOnAction(ec -> {
                flager2=1;
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table);
                g1.getChildren().remove(table2);
                g1.getChildren().remove(table3);
                t2.table_re(id);
                table.refresh();
                g1.add(table, 0, 0);
                l_summit.setText("");
                B_Delete_Reservation.setDisable(true);
                B_Summit.setDisable(false);

            });
            Button_Trips.setOnAction(ec -> {
                flager2=2;
                g1.getChildren().remove(table1);
                g1.getChildren().remove(table);
                g1.getChildren().remove(table2);
                g1.getChildren().remove(table3);
                g1.add(table2, 0, 0);
                l_summit.setText("");
                B_Delete_Reservation.setDisable(true);
                B_Summit.setDisable(false);

            });


            B_Summit.setOnAction(ef -> {
                if (flager2==1){
                    String temp = new String();
                    String temp1= new String();
                    String temp2= new String();
                    String temp4= new String();
                    temp2 = "-x2";
                ObservableList<Trips> tripSelected, alltrips;
                String a = table.getSelectionModel().getSelectedItem().getFrom();
                String b = table.getSelectionModel().getSelectedItem().getTo();
                    temp1 = b;
                String c = table.getSelectionModel().getSelectedItem().getVehicle();
                String d = table.getSelectionModel().getSelectedItem().getTicketPrice();
                    temp =d;
                    if(Two.isSelected()){
                        int aa = Integer.parseInt(d);
                        aa = (int)(aa*2-(aa*0.1));
                        temp= String.valueOf(aa);
                        temp1 = temp1.concat(temp2);
                        l_summit_prompt.setText("your trip is rounded with discount");
                    }
                String e = table.getSelectionModel().getSelectedItem().getAvailableSeats();
                String f = Integer.toString(id);
                String g= convert.search_Driver_from_file(a,b,c,d,e);
                if(!e.equals("0")){
                x.Add_trip1(a, b, c, temp, e, f, g,"Reserved.txt");
                x.Seats(a,b,c,d,e,"Trips.txt");
                l_summit.setText("Summit successfully");
                if(oone.isSelected())
                    ls.setText(oone.getText());
                else if (non.isSelected())
                    ls.setText(non.getText());
                else if (many.isSelected())
                    ls.setText(many.getText());
                else
                    ls.setText("");
                }
                else{
                    l_summit.setText("no available seats");
                    l_summit_prompt.setText("");
                }}

                else   if (flager2==2){
                  String temp = new String();
                  String temp1= new String();
                  String temp2= new String();
                  temp2 = "-x2";
                    ObservableList<Trips> tripSelected, alltrips;
                    String a = table2.getSelectionModel().getSelectedItem().getFrom();
                    String b = table2.getSelectionModel().getSelectedItem().getTo();
                    temp1 =b;

                    String c = table2.getSelectionModel().getSelectedItem().getVehicle();
                    String d = table2.getSelectionModel().getSelectedItem().getTicketPrice();
                    temp =d;
                    if(Two.isSelected()){
                        int aa = Integer.parseInt(d);
                        aa = (int)(aa*2-(aa*0.1));
                        l_summit_prompt.setText("your trip is rounded with discount");
                        temp1 = temp1.concat(temp2);
                        temp= String.valueOf(aa);
                    }
//                   d=temp;

                    String e = table2.getSelectionModel().getSelectedItem().getAvailableSeats();
                    String f = Integer.toString(id);
                    String g= convert.search_Driver_from_file1(a,b,c,d,e);
                    if(!e.equals("0")){
                    x.Add_trip1(a, b, c, temp, e, f, g,"Reserved_external.txt");
                    x.Seats(a,b,c,d,e,"Trips_external.txt");
                    l_summit.setText("Summit successfully");
                        if(oone.isSelected())
                            ls.setText(oone.getText());
                        else if (non.isSelected())
                            ls.setText(non.getText());
                        else if (many.isSelected())
                            ls.setText(many.getText());
                        else
                            ls.setText("");
                    }
                }
                else {
                    l_summit.setText("cannot be added");
                    l_summit_prompt.setText("");
                }
            });
            B_Delete_Reservation.setOnAction(ef -> {
                ObservableList<Trips_reservation> tripSelected, alltrips;
                if (flager2 == 1) {
                    String tmp;
                    String a = table1.getSelectionModel().getSelectedItem().getFrom();
                    String b = table1.getSelectionModel().getSelectedItem().getTo();
                    String c = table1.getSelectionModel().getSelectedItem().getVehicle();
                    String d = table1.getSelectionModel().getSelectedItem().getTicketPrice();
                    String e = table1.getSelectionModel().getSelectedItem().getAvailableSeats();
                    tmp = e;
                    String f = table1.getSelectionModel().getSelectedItem().getUser();
                    x.Seats_add(a,b,c,"Trips.txt");
                    x.Delete_Item_Reserved(a, b, c, d, e, f,"Reserved.txt");
                    alltrips = table1.getItems();
                    tripSelected = table1.getSelectionModel().getSelectedItems();
                    tripSelected.forEach(alltrips::remove);


                }
                if (flager2 == 2) {
                    String tmp;
                    String a = table3.getSelectionModel().getSelectedItem().getFrom();
                    String b = table3.getSelectionModel().getSelectedItem().getTo();
                    String c = table3.getSelectionModel().getSelectedItem().getVehicle();
                    String d = table3.getSelectionModel().getSelectedItem().getTicketPrice();
                    String e = table3.getSelectionModel().getSelectedItem().getAvailableSeats();
                    tmp = e;
                    String f = table3.getSelectionModel().getSelectedItem().getUser();
                    x.Seats_add(a,b,c,"Trips_external.txt");

                    x.Delete_Item_Reserved(a, b, c, d, e, f,"Reserved_external.txt");
                    alltrips = table3.getItems();
                    tripSelected = table3.getSelectionModel().getSelectedItems();
                    tripSelected.forEach(alltrips::remove);

                }
            });

        } else {
            stage3.setTitle("Welcome Driver");
            Table t1 = new Table("Trips.txt");
            Table t2 = new Table("Trips_external.txt");
            table2 = t2.table2(id);
            table = t1.table2(id);
            Button buttond1 = new Button("Internal");
            Button buttond2 = new Button("external");
            HBox HH1 = new HBox(10);
            VBox hh = new VBox(10);
            hh.getChildren().add(HH1);
            HH1.getChildren().addAll(buttond1, buttond2);
            buttond1.setOnAction(e->{
                hh.getChildren().removeAll(table, table2);
                hh.getChildren().addAll(table);
            });
            buttond2.setOnAction(e->{
                hh.getChildren().removeAll(table, table2);
                hh.getChildren().addAll(table2);
            });



            g1.getChildren().addAll(hh);
//            g1.getChildren().add(HH1);


        }
        s1 = new Scene(st);
        stage3.setMinWidth(400);
        stage3.setMinHeight(400);
        stage3.setScene(s1);
        stage3.show();


    }

}


