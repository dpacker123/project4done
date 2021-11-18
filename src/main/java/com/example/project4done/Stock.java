package com.example.project4done;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


// David Packer
//This is the best I could come up with, I have spent 10s of hours on this and its just not clicking
// I tried building it through scenebuilder but found that getting data to show up on the listview was
// much harder than I thought

//I know it looks like I have nothing here and I am aware the majority of the project is missing
// I have done the absolute best I can do.

public class Stock extends Application {

    public static final ObservableList Products = FXCollections.observableArrayList();
    public static final ObservableList Catagories = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Product List");
        final ListView listView = new ListView(Catagories);
        listView.setPrefSize(400, 400);
        listView.setEditable(true);

//This is my attempt to read in the file "ItemsForSale" and break it apart into names, price, and count
        // I could not get it to work but I wanted to leave it in.
        var filename = "ItemsForSale";
        var products = Paths.get(filename);
        var productName = new ArrayList<String>();
        var productPrice = new ArrayList<Float>();
        var productCount = new ArrayList<Integer>();
        var productLines = Files.readAllLines(products);
        for (var line : productLines) {
            var splitline = line.split(",");
            productName.add(splitline[0]);
            productPrice.add(Float.valueOf(splitline[1]));
            productCount.add(Integer.valueOf(splitline[2]));
        }
//This is simply adding data to the observable list called products through the .addALL function
        Products.addAll("Chicken", "Mushroom", "Milk", "Noddles", "Spinach", "Saffron",
                "Vanilla", "Jeans", "Socks", "Coat", "Sports car endoresed shoes", "Suit", "Fancy Suit",
                "Dress", "Fancy Dress", "Computer", "Gaming Computer", "Chair", "PLate Set", "School Book",
                "Fun Book", "Couch");
// Thisis my attempt to create catagories but  I am struggling with a way to assgin particular products to
        // each catagory
        Catagories.addAll("Food", "Clothes", "Items");

        listView.setItems(Catagories);
        listView.setCellFactory(ComboBoxListCell.forListView(Products));
        StackPane stack = new StackPane();
        stack.getChildren().add(listView);
        // this sets the scene and size of the scene
        stage.setScene(new Scene(stack, 400, 400));
        stage.show();
    }
}

// These are some of my previous attempts:
/* Here I tried to mimic the calculator but substitute it and change it so you could add or subtract
Items from your cart. I kind of work but used buttons instead of a List.

    public class HelloController {
        @FXML
        private TextField textField = new TextField("Please select an Item");

        @FXML
        public void ChickenPressed(){
            var price = 20;
            textField.setText("Chicken is " +price+ " dollars a bird");
        }

        @FXML
        public void MushroomPressed(){
            var price = 5;
            textField.setText("Mushroom's are " +price+ " dollars a bag");
        }

        @FXML
        public void MilkPressed(){
            var price = 2;
            textField.setText("Milk is " +price+ " dollars a gallon" );
        }

        @FXML
        public void NoodlePressed(){
            var price = 1;
            textField.setText("Noodles are " +price+ " dollar a box");
        }

        @FXML
        public void ChickenPlus(){
            textField.setText("You have entered 1 chicken to your cart for a total of $20");
        }

        @FXML
        public void ChickenMinus(){

            textField.setText("you have no chicken in your cart");
        }

        @FXML
        public void MushroomPlus(){
            textField.setText("You have added one mushroom for a total of 5 dollars");
        }

        @FXML
        public void MushroomMinus(){
            textField.setText("You do not have any mushrooms in your cart");

        }

        @FXML
        public void MilkPlus(){
            textField.setText("You have one gallon of milk in your cart");

        }

        @FXML
        public void MilkMinus(){
            textField.setText("You do not have any Milk in your cart");

        }

        @FXML
        public void NoodlesPlus(){
            textField.setText("You have one box of noodles in your cart");

        }

        @FXML
        public void NoodlesMinus(){
            textField.setText("You do not have nay noodles in your cart");
        }
    }
}


This was my attempt to build the list in scene builder and then assign it to the fx:id but no matter
what I did I could not get the list to fill with my values.

public class Stock {

    @FXML
    private ListView<String> myListView;

    @FXML
    private Label mylabel;

    String[] food = {"Chicken", "Noodles", "Milk"};

    String currentFood;


    public void intialize(URL arg0, ResourceBundle arg1){

        myListView.getItems().addAll(food);

        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                currentFood = myListView.getSelectionModel().getSelectedItem();
            }
        });


    }

}
 */