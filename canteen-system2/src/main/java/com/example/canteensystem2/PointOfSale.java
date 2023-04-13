package com.example.canteensystem2;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.geometry.Pos.*;

public class PointOfSale extends Application {

    Label pointOfSalesHeader;
    Label pointOfSalesDiplay;
    TextArea display;

    public void start(Stage pointOfSaleStage) throws Exception {


        Button no_0 = new Button("0");
        no_0.setPrefSize(75,75);
        no_0.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_1 = new Button("1");
        no_1.setPrefSize(75,75);
        no_1.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_2 = new Button("2");
        no_2.setPrefSize(75,75);
        no_2.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_3 = new Button("3");
        no_3.setPrefSize(75,75);
        no_3.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_4 = new Button("4");
        no_4.setPrefSize(75,75);
        no_4.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_5 = new Button("5");
        no_5.setPrefSize(75,75);
        no_5.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_6 = new Button("6");
        no_6.setPrefSize(75,75);
        no_6.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_7 = new Button("7");
        no_7.setPrefSize(75,75);
        no_7.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_8 = new Button("8");
        no_8.setPrefSize(75,75);
        no_8.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_9 = new Button("9");
        no_9.setPrefSize(75,75);
        no_9.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_Delete = new Button("Del");
        btn_Delete.setPrefSize(75,75);
        btn_Delete.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_Enter = new Button("Ent");
        btn_Enter.setPrefSize(75,75);
        btn_Enter.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Label pointOfSalesHeader = new Label();

        TextField input = new TextField();
        input.setPrefSize(245,40);
        input.setPromptText("Input from keyboard");

        TextArea display = new TextArea();
        display.setPrefSize(500,300);
        display.setStyle("-fx-background-color: BLACK; -fx-text-fill: WHITE; -fx-font-size: 25; -fx-border-color: WHITE");


        BorderPane root = new BorderPane();
        GridPane numPad = new GridPane();
        Scene pointOfSale = new Scene(root,1280,768);
        root.setBackground(Background.fill(Color.BLACK));

        root.setCenter(numPad);
        root.setTop(pointOfSalesHeader);
        root.setBottom(input);
        root.setRight(display);

        pointOfSalesHeader.setText("Administrator Portal");
        pointOfSalesHeader.setTextFill(Color.WHITE);
        pointOfSalesHeader.setPrefSize(pointOfSale.getWidth(),175);
        pointOfSalesHeader.setAlignment(CENTER);
        pointOfSalesHeader.setStyle("-fx-font-family: 'Calibri'; -fx-font-size: 40; -fx-font-weight: Bold");

        numPad.addRow(3);
        numPad.addColumn(4);
        numPad.setHgap(10);
        numPad.setVgap(10);
        numPad.setGridLinesVisible(true);
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
        numPad.add(btn_Delete,1,3);
        numPad.add(btn_Enter,2,3);

        numPad.setPrefSize(500,500);

        pointOfSaleStage.setTitle("Administrator portal - Point of Sales");
        pointOfSaleStage.setScene(pointOfSale);
        pointOfSaleStage.show();

    }
}
