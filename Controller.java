package sample;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

//import java.awt.*;
import java.net.URL;

import java.util.ResourceBundle;

public class Controller implements Initializable {
    Color color;
    Color dopColor;
    int maxSpeed;
    int maxCountPass;
    double weight;
    int maxCapacityGenerator;

    Parking parking = new Parking();
    private ITransport inter;

    @FXML
    TextField fieldMaxSpeed;

    @FXML
    TextField fieldMaxPas;

    @FXML
    TextField fieldWeight;

    @FXML
    Button btnLoc;

    @FXML
    Button btnPasLoc;

    @FXML
    Button btnMove;

    @FXML
    CheckBox checkBox1;

    @FXML
    CheckBox checkBox2;

    @FXML
    CheckBox checkBox3;

    @FXML
    Pane drawPanel;

    @FXML
    ColorPicker generalColor;

    @FXML
    ColorPicker doColor;

    @FXML
    TextField countTrain;

    @FXML
    Pane dopDrawPanel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        color = Color.GREEN;
        dopColor = Color.YELLOW;
        maxSpeed = 200;
        maxCountPass = 50;
        weight = 1000;
        drawPanel.getChildren().addAll(parking.Draw());
    }

    public void btnActLoc(ActionEvent actionEvent) {
        generalColor.setOnAction((ActionEvent t) -> {
            color = generalColor.getValue();
        });
        try{
            maxSpeed = Integer.parseInt(fieldMaxSpeed.getText());
            maxCountPass = Integer.parseInt(fieldMaxPas.getText());
            weight = Integer.parseInt(fieldWeight.getText());
            Train train = new Train(maxSpeed, maxCountPass, maxCapacityGenerator, weight, color);
            inter = train;
            drawPanel.getChildren().addAll(train.drawLoc());
        }catch (Exception e){

        }
    }

    public void btnActPasLoc(ActionEvent actionEvent) {

    }

    public void btnActMove(ActionEvent actionEvent) {
        Rectangle rectangle = new javafx.scene.shape.Rectangle(700,270, javafx.scene.paint.Paint.valueOf("Grey"));
        drawPanel.getChildren().add(rectangle);
        inter.moveCar();
        PasTrain cartLocomotive = new PasTrain(maxSpeed, maxCountPass, maxCapacityGenerator, weight, color, checkBox1.isSelected(), checkBox2.isSelected(), checkBox3.isSelected(), dopColor);
        drawPanel.getChildren().addAll(cartLocomotive.drawLoc());
    }


    public void btnDopColor(ActionEvent actionEvent) {
    }

    public void btnGenColor(ActionEvent actionEvent) {
    }

    public void buttonSelectColor_Click_1(ActionEvent actionEvent) {
    }

    public void buttonSelectDopColor_Click_1(ActionEvent actionEvent) {
    }

    public void putPasTrainBtnAction(ActionEvent actionEvent) {
        PasTrain train = new PasTrain(100, 4, 240, 1000, color, true, true, true, dopColor);
        inter = train;
        int place = parking.PutCarInParking(train);
        drawPanel.getChildren().setAll(parking.Draw());
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Ваше место: " + place);
    }

    public void putTrainBtnAction(ActionEvent actionEvent) {
        Train train = new Train(100, 4, 240, 1000, color);
        inter = train;
        int place = parking.PutCarInParking(train);
        drawPanel.getChildren().setAll(parking.Draw());
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Ваше место: " + place);
    }

    public void takeBtnActionA(ActionEvent actionEvent) {
        if (countTrain.getText() != "") {
            ITransport train = parking.GetCarInParking(Integer.parseInt(countTrain.getText()));
            train.setPosition(5, 5);
            dopDrawPanel.getChildren().setAll(parking.Draw());
        }
    }
}
