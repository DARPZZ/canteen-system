package com.example.canteensystem2;


import Model.DaOImplements.DaOEmployee;
import Model.DaOImplements.DaOItem;
import Model.DaOImplements.DaOTransaction;
import Model.DaOImplements.DaoStock;
import Model.DaoObjects.Employee;
import Model.DaoObjects.Item;
import Model.DaoObjects.Stock;
import Model.DaoObjects.Transaction;
import View.AdminPage;
import javafx.application.Application;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import javax.xml.stream.util.StreamReaderDelegate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PointOfSale extends AdminPage {

    private TableView<Item> display;
    private ObservableList<Item> purchaseItems;
    private Scene scene;
    private FloatProperty purchaseSum = new SimpleFloatProperty(0.0f);

    public PointOfSale() {

//region Buttons
        Button no_0 = new Button("0");
        no_0.setPrefSize(100, 100);
        no_0.setUserData("0");
        no_0.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_1 = new Button("1");
        no_1.setPrefSize(100, 100);
        no_1.setUserData("1");
        no_1.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_2 = new Button("2");
        no_2.setUserData("2");
        no_2.setPrefSize(100, 100);
        no_2.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_3 = new Button("3");
        no_3.setUserData("3");
        no_3.setPrefSize(100, 100);
        no_3.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_4 = new Button("4");
        no_4.setUserData("4");
        no_4.setPrefSize(100, 100);
        no_4.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_5 = new Button("5");
        no_5.setUserData("5");
        no_5.setPrefSize(100, 100);
        no_5.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_6 = new Button("6");
        no_6.setUserData("6");
        no_6.setPrefSize(100, 100);
        no_6.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_7 = new Button("7");
        no_7.setUserData("7");
        no_7.setPrefSize(100, 100);
        no_7.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_8 = new Button("8");
        no_8.setUserData("8");
        no_8.setPrefSize(100, 100);
        no_8.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button no_9 = new Button("9");
        no_9.setUserData("9");
        no_9.setPrefSize(100, 100);
        no_9.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_delete = new Button("Del");
        btn_delete.setPrefSize(100, 100);
        btn_delete.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_enter = new Button("Ent");
        btn_enter.setPrefSize(100, 100);
        btn_enter.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE");

        Button btn_buy = new Button("Skan medarbejderkort for betaling");
        btn_buy.setPrefSize(300, 120);
        btn_buy.setWrapText(true);
        btn_buy.setStyle("-fx-font-size: 24; -fx-background-color: #000065; -fx-text-fill: WHITE; -fx-font-weight: bold");


//endregion
        btn_back.setId("back-button");
        //Layout containers
        BorderPane root = new BorderPane();

        super.scene = new Scene(root,1280,768);


        FlowPane center = new FlowPane();

        FlowPane header = new FlowPane();
        header.setPrefHeight(250);

        VBox rightBox = new VBox();
        rightBox.setPrefSize(300, 600);

        VBox leftBox = new VBox();
        //region Gridpane
        GridPane numPad = new GridPane();

        numPad.addRow(3);
        numPad.addColumn(4);
        numPad.setHgap(0);
        numPad.setVgap(0);
        numPad.add(no_1, 0, 0);
        numPad.add(no_2, 1, 0);
        numPad.add(no_3, 2, 0);
        numPad.add(no_4, 0, 1);
        numPad.add(no_5, 1, 1);
        numPad.add(no_6, 2, 1);
        numPad.add(no_7, 0, 2);
        numPad.add(no_8, 1, 2);
        numPad.add(no_9, 2, 2);
        numPad.add(no_0, 0, 3);
        numPad.add(btn_delete, 1, 3);
        numPad.add(btn_enter, 2, 3);
        numPad.setPrefSize(300, 400);
        //endregion

        Pane filler = new Pane();
        filler.setPrefSize(1080,200);


        Label cardInfo = new Label();
        cardInfo.setPrefWidth(300);
        cardInfo.setPrefHeight(200);
        cardInfo.setStyle("-fx-font-size: 24; -fx-text-fill: BLACK");

        TextField inputItem = new TextField();
        inputItem.setPrefSize(300, 25);
        inputItem.setPromptText("Indtast varenr.  ");
        inputItem.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                inputItem.setText(oldValue);
            }

        });

        //region numpad listeners
        no_0.setOnAction(event -> {
            String value = (String) no_0.getUserData();
            inputItem.setText(inputItem.getText() + no_0.getText());
        });
        no_1.setOnAction(event -> {
            String value = (String) no_1.getUserData();
            inputItem.setText(inputItem.getText() + no_1.getText());
        });
        no_2.setOnAction(event -> {
            String value = (String) no_2.getUserData();
            inputItem.setText(inputItem.getText() + no_2.getText());
        });
        no_3.setOnAction(event -> {
            String value = (String) no_3.getUserData();
            inputItem.setText(inputItem.getText() + no_3.getText());
        });
        no_4.setOnAction(event -> {
            String value = (String) no_4.getUserData();
            inputItem.setText(inputItem.getText() + no_4.getText());
        });
        no_5.setOnAction(event -> {
            String value = (String) no_5.getUserData();
            inputItem.setText(inputItem.getText() + no_5.getText());
        });
        no_6.setOnAction(event -> {
            String value = (String) no_6.getUserData();
            inputItem.setText(inputItem.getText() + no_6.getText());
        });
        no_7.setOnAction(event -> {
            String value = (String) no_7.getUserData();
            inputItem.setText(inputItem.getText() + no_7.getText());
        });
        no_8.setOnAction(event -> {
            String value = (String) no_8.getUserData();
            inputItem.setText(inputItem.getText() + no_8.getText());
        });
        no_9.setOnAction(event -> {
            String value = (String) no_9.getUserData();
            inputItem.setText(inputItem.getText() + no_9.getText());
        });


        //endregion
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);

        TextField inputEmployee = new TextField();
        inputEmployee.setPrefSize(300, 25);
        inputEmployee.setPromptText("Indtast medarbejdernr. manuelt ");
        DaOEmployee daOEmployee = new DaOEmployee();
        DaoStock daoStock = new DaoStock();
        DaOTransaction daOTransaction = new DaOTransaction();
        inputEmployee.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                inputEmployee.setText(oldValue);
            }
            inputEmployee.setOnKeyPressed(event -> {

                if (event.getCode() == KeyCode.ENTER)
                {

                    Employee currentEmployee =daOEmployee.Get(Integer.parseInt(inputEmployee.getText()));
                    currentEmployee.setSaldo(currentEmployee.getSaldo() - purchaseSum.getValue());
                    daOEmployee.Update(currentEmployee,"fldSaldo",String.valueOf(currentEmployee.getSaldo()));
                    cardInfo.setText(currentEmployee.getName()+ "\nMedarbejdernr.:" + currentEmployee.getEmployeeID());

                    for (int i = 0; i < purchaseItems.size(); i++)
                    {
                        Stock tempStock = daoStock.Get(purchaseItems.get(i));
                        tempStock.setStockLevelProperty(tempStock.getStockLevelProperty() - 1);
                        daoStock.Update(tempStock,"fldStockLevel",String.valueOf(tempStock.getStockLevelProperty()));
                    }

                    Transaction tempTrans = new Transaction(daOTransaction.getLatestID(), LocalDate.now(),purchaseSum.getValue(),currentEmployee.getEmployeeID());
                    daOTransaction.Create(tempTrans);



                }
            });
        });


        Label sumText = new Label();
        sumText.setPrefSize(339,25);
        sumText.setStyle("-fx-font-size: 16; -fx-text-fill: BLACK");
        sumText.setText("Samlet pris: ");
        sumText.setAlignment(Pos.CENTER_LEFT);

        Label sum = new Label();
        sum.setPrefSize(339, 25);
        sum.textProperty().bind(purchaseSum.asString());
        sum.setStyle("-fx-font-size: 16; -fx-text-fill: BLACK");
        sum.setAlignment(Pos.CENTER_RIGHT);




        List<Item> purchaseList = new ArrayList<>();
        purchaseItems = FXCollections.observableList(purchaseList);

        display = new TableView<>(purchaseItems);
        display.setPrefSize((super.getScene().getWidth() - 600), (super.getScene().getHeight() - 355));
        display.setLayoutX((super.getScene().getWidth() - display.getPrefWidth()) / 2);
        display.setLayoutY(150);

        createColumns();

        btn_enter.setOnAction(e->{
            String vareNr = inputItem.getText();

            DaOItem dbItem = new DaOItem();
            Item vare = dbItem.Get(Integer.parseInt(vareNr));

            purchaseItems.add(vare);

            inputItem.clear();

            purchaseSum.setValue(purchaseSum.get()+ vare.getPrice());

        } );



        root.setRight(rightBox);
        rightBox.getChildren().addAll(btn_buy,inputEmployee, cardInfo);
        root.setLeft(leftBox);
        leftBox.getChildren().addAll(numPad, inputItem);
        root.setCenter(center);
        center.getChildren().addAll(display, sumText,sum);
        root.setTop(filler);
        filler.getChildren().addAll(backBtn,pointOfSaleBtn,InventoryManagementBtn,SalesHistoryBtn);


    }
/*
    public void createColumns() {
        int xSize = (int) (this.display.getPrefWidth() / 4);

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
        this.display.getColumns().setAll(ItemID, Description, Quantity, Price);
    }
*/
    public void createColumns() {
        int noColumn = 4;
        int xSize = (int) (display.getPrefWidth() / noColumn);

        TableColumn<Item, Number> itemID = new TableColumn<>("Varenr.");
        itemID.setCellValueFactory(data -> data.getValue().getItemIDProperty());

        TableColumn<Item, String> description = new TableColumn<>("Beskrivelse");
        description.setCellValueFactory(data -> data.getValue().getNameProperty());

        TableColumn<Item, Number> quantity = new TableColumn<>("Antal");

        TableColumn<Item, String> price = new TableColumn<>("pris");
        price.setCellValueFactory(data -> data.getValue().getPriceProperty().asString());

        display.getColumns().add(itemID);
        display.getColumns().add(description);
        display.getColumns().add(quantity);
        display.getColumns().add(price);

        for (TableColumn<Item, ?> column : display.getColumns()) {
            column.setReorderable(false);
            column.setResizable(false);
            column.setPrefWidth(xSize);

        }
    }
}
