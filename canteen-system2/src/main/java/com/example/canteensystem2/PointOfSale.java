package com.example.canteensystem2;

import DaoObjects.Item;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class PointOfSale extends Application {

    private TableView<Item>display;
    private ObservableList<Item> purchaseItems;
    private Scene scene;


    public void start(Stage primaryStage) throws Exception {

//region Buttons
        Button no_0 = new Button("0");
        no_0.setPrefSize(100,100);
        no_0.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_1 = new Button("1");
        no_1.setPrefSize(100,100);
        no_1.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_2 = new Button("2");
        no_2.setPrefSize(100,100);
        no_2.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_3 = new Button("3");
        no_3.setPrefSize(100,100);
        no_3.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_4 = new Button("4");
        no_4.setPrefSize(100,100);
        no_4.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_5 = new Button("5");
        no_5.setPrefSize(100,100);
        no_5.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_6 = new Button("6");
        no_6.setPrefSize(100,100);
        no_6.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_7 = new Button("7");
        no_7.setPrefSize(100,100);
        no_7.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_8 = new Button("8");
        no_8.setPrefSize(100,100);
        no_8.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_9 = new Button("9");
        no_9.setPrefSize(100,100);
        no_9.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_delete = new Button("Del");
        btn_delete.setPrefSize(100,100);
        btn_delete.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_enter = new Button("Ent");
        btn_enter.setPrefSize(100,100);
        btn_enter.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_buy = new Button("Skan medarbejderkort for betaling");
        btn_buy.setPrefSize(300,120);
        btn_buy.setWrapText(true);
        btn_buy.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE; -fx-font-weight: bold");

        Button btn_back = new Button("Tilbage");
        btn_back.setPrefSize(100,25);
        btn_back.setStyle("-fx-font-size: 16; -fx-background-color: #000065; -fx-text-fill: WHITE");


//endregion


        //Layout containers
        BorderPane root = new BorderPane();

        scene = new Scene(root, 1278,780);

        FlowPane center = new FlowPane();

        FlowPane header = new FlowPane();
        header.setPrefHeight(250);

        VBox rightBox = new VBox();
        rightBox.setPrefSize(300,600);

        VBox leftBox = new VBox();

            GridPane numPad = new GridPane();
                //Indexing the gridPane
                numPad.addRow(3);
                numPad.addColumn(4);
                numPad.setHgap(0);
                numPad.setVgap(0);
                numPad.add(no_1,0,0);
                numPad.add(no_2,1,0);
                numPad.add(no_3,2,0);
                numPad.add(no_4,0,1);
                numPad.add(no_5,1,1);
                numPad.add(no_6,2,1);
                numPad.add(no_7,0,2);
                numPad.add(no_8,1,2);
                numPad.add(no_9,2,2);
                numPad.add(no_0,0,3);
                numPad.add(btn_delete,1,3);
                numPad.add(btn_enter,2,3);
                numPad.setPrefSize(300,400);


        Label headLine = new Label();
        headLine.setText("Administrator Portal");
        headLine.setStyle("-fx-font-size: 30; -fx-text-fill: WHITE; -fx-alignment: CENTER");
        headLine.setAlignment(Pos.CENTER);
        headLine.setPrefWidth(1080);

        Label cardInfo = new Label();
        cardInfo.setPrefWidth(300);
        cardInfo.setPrefHeight(200);
        cardInfo.setStyle("-fx-font-size: 24; -fx-text-fill: WHITE");
        cardInfo.setText("Peter Madsen \nMedarbejdernr.: 1235");

        TextField input = new TextField();
        input.setPrefSize(300,25);
        input.setPromptText("Indtast varenr.  ");


        List<Item> purchaseList = new ArrayList<>();
        purchaseItems = FXCollections.observableList(purchaseList);

        display = new TableView<>(purchaseItems);
        display.setPrefSize((scene.getWidth() - 600),(scene.getHeight()-355));
        display.setLayoutX((scene.getWidth() - display.getPrefWidth()) /2);
        display.setLayoutY(150);

        createColumns();


        root.setRight(rightBox);
            rightBox.getChildren().addAll(btn_buy,cardInfo);
        root.setLeft(leftBox);
            leftBox.getChildren().addAll(numPad, input);
        root.setCenter(center);
            center.getChildren().addAll(display);
        root.setTop(header);
            header.getChildren().addAll(btn_back,headLine);
        root.setBackground(Background.fill(Color.BLACK));


        primaryStage.setTitle("Administrator portal - Point of Sales");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void createColumns()
    {
        int xSize = (int) (this.display.getPrefWidth()/4);

        TableColumn<Item, String> ItemID = new TableColumn<>("Varenr.");
        ItemID.setCellValueFactory(new PropertyValueFactory<>("ItemID"));
        ItemID.setPrefWidth(xSize);

        TableColumn<Item, String> Description = new TableColumn<>("Beskrivelse");
        Description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        Description.setPrefWidth(xSize);

        TableColumn<Item, String> Quantity = new TableColumn<>("Antal");
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Quantity.setPrefWidth(xSize);

        TableColumn<Item, String> Price = new TableColumn<>("Pris");
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Price.setPrefWidth(xSize);

        //noinspection unchecked
        this.display.getColumns().setAll(ItemID,Description,Quantity,Price);
    }
}
