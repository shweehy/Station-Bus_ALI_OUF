package pkj1;

import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Observable;

public class Gui extends Application {
    //Gui1 c = new Gui1();
    int id,driver;
    String fileName;
    Stage stage2;//second screen
    Stage stage3;//User Stage
    Stage primaryStage;
    int flag1; // flag of radio Buttons 'Mangers''Employee''Users'
    Scene scene2 , scene , Add_Trips ;
    Add_User x = new Add_User();
    public void start(Stage primaryStage) {


        Label l1 = new Label("Welcome to the Station");
        Label l2 = new Label("UserName");
        Label l3 = new Label("Password");
        Label l4= new Label("");


        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Manger");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        RadioButton button2 = new RadioButton("Employee");
        button2.setToggleGroup(group);
        RadioButton button3 = new RadioButton("User");
        button3.setToggleGroup(group);
// scene of login
        TextField t1 = new TextField();
        PasswordField p1 = new PasswordField();

        Button b1 = new Button("Next");
        Button b2 = new Button("Login");
        Button b3 = new Button("Back");
        Button b4 = new Button("Sign-Up");


       b2.setOnAction(e->{
           int v = x.CheckAbility(fileName,t1.getText(),p1.getText());
           if(v==1) {
               this.id=x.getId();
               l4.setText("login successful");
//               Second_Screen();
                new Gui1().User_Screen(flag1,id);

                           }
           else
               l4.setText("Unsuccessful");
       });

        b1.setOnAction(  e->
                {
                    if (button1.isSelected()){
                        fileName = "Manger.txt";
                        b4.setDisable(true);
                        flag1=1;
                    }

                    else if (button2.isSelected()){
                        fileName = "drivers.txt";
                        b4.setDisable(true);
                        flag1=2;
                    }
                    else if (button3.isSelected()){
                        fileName = "users.txt";
                        flag1=3;
                        b4.setDisable(false);

                    }

                      primaryStage.setScene(scene2);

                });
        GridPane gridPane = new GridPane();
        GridPane g1 = new GridPane();
        GridPane g2 = new GridPane();
        g1.setMinSize(500, 100);
        g1.setPadding(new Insets(10, 10, 10, 10));
        g1.setVgap(5);
        g1.setHgap(5);
        g1.setAlignment(Pos.CENTER);

        g1.add(l2,0,0);
        g1.add(l3,0,1);
        g1.add(t1,1,0);
        g1.add(p1,1,1);
        g1.add(b2,3,2);
        g1.add(b3,2,2);
        g1.add(b4,1,2);
        g1.add(l4,2,4);

        gridPane.setMinSize(300, 100);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(l1,1,0);
        gridPane.add(button1,0,1);
        gridPane.add(button2,1,1);
        gridPane.add(button3,2,1);
        gridPane.add(b1,3,3);

        scene = new Scene(gridPane);
        scene2 = new Scene(g1);
      //  SignUp = new Scene(g2);


        b4.setOnAction(e->primaryStage.setScene(SignUp(primaryStage)));

        b3.setOnAction(e->{primaryStage.setScene(scene);
        t1.setText("");
        p1.setText("");
        l4.setText("");
        });
        primaryStage.setTitle("login in page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void Start(String[] args) {
        Application.launch(args);
    }

    Scene SignUp(Stage p) {
        Scene s1 ;
        Button b1 = new Button("Submit");
        Button b2 = new Button("Back");
        Label l1 = new Label("Welcome Sign-Up Page");
        Label l2 = new Label("UserName");
        Label l3 = new Label("Password");
        Label l4 = new Label("Re-Password");
        Label l5 = new Label();

        TextField T1 = new TextField();
        PasswordField p1 = new PasswordField();
        PasswordField p2 = new PasswordField();

        b1.setOnAction(e->{
            if(p1.getText().equals(p2.getText())){
               try{
                    x.OverWrite("users.txt",T1.getText(),p1.getText());
                    l5.setText("your Account hasbeen created ");
                    b1.setDisable(true);
                }
                catch (Exception ex){
                   l5.setText("Error in system");
                }


            }
            else
                l5.setText("your Password is not matched");
        });
        b2.setOnAction(e->{
            p.setScene(scene);
        });

        GridPane g1= new GridPane();
        g1.setMinSize(500, 100);
        g1.setPadding(new Insets(10, 10, 10, 10));
        g1.setVgap(5);
        g1.setHgap(5);
        g1.setAlignment(Pos.CENTER);

        g1.add(l1,1,0);
        g1.add(T1,1,1);
        g1.add(l2,0,1);
        g1.add(p1,1,2);
        g1.add(l3,0,2);
        g1.add(p2,1,3);
        g1.add(l4,0,3);
        g1.add(l5,1,4);
        g1.add(b1,2,5);
        g1.add(b2,1,5);





        s1 = new Scene(g1);
        return s1;
    }

    void Second_Screen(){


//        Table t1 = new Table("Trips.txt");
        Table t1 = new Table();
        stage2 = new Stage();
        //ArrayList<ArrayList<String>> AList = new ArrayList<ArrayList<String>>();
      //  AList=x.ReadFile("users.txt");
        TableView<Trips> table=t1.table();


        HBox h1 = new HBox(10);
        h1.getChildren().addAll(table);
        Scene s1 = new Scene(h1);
        stage2.setTitle("Reservation Mode");
        stage2.setScene(s1);
        stage2.show();
    }


}
