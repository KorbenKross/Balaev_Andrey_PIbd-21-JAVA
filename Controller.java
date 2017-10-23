package sample;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        color = Color.GREEN;
        dopColor = Color.YELLOW;
        maxSpeed = 200;
        maxCountPass = 50;
        weight = 1000;
    }

    public void btnActLoc(ActionEvent actionEvent) {
        generalColor.setOnAction((ActionEvent t) -> {
            color = generalColor.getValue();
        });
        try{
            maxSpeed = Integer.parseInt(fieldMaxSpeed.getText());
            maxCountPass = Integer.parseInt(fieldMaxPas.getText());
            weight = Integer.parseInt(fieldWeight.getText());

            Rectangle rectangle = new Rectangle(700, 270, javafx.scene.paint.Paint.valueOf("White"));
            drawPanel.getChildren().add(rectangle);

            Train train = new Train(maxSpeed, maxCountPass, maxCapacityGenerator, weight, color);
            inter = train;
            drawPanel.getChildren().addAll(train.drawLoc());

        }catch (Exception e){

        }
    }

    public void btnActPasLoc(ActionEvent actionEvent) {
        doColor.setOnAction((ActionEvent t) -> {
            dopColor = doColor.getValue();
        });
        try {
            maxSpeed=Integer.parseInt(fieldMaxSpeed.getText());
            maxCountPass=Integer.parseInt(fieldMaxPas.getText());
            weight=Integer.parseInt(fieldWeight.getText());
            Rectangle rectangle = new Rectangle(700, 270, Paint.valueOf("White"));
            drawPanel.getChildren().add(rectangle);

            PasTrain cartLocomotive = new PasTrain(maxSpeed, maxCountPass, maxCapacityGenerator, weight, color, checkBox1.isSelected(), checkBox2.isSelected(), checkBox3.isSelected(), dopColor);
            inter = cartLocomotive;
            drawPanel.getChildren().addAll(cartLocomotive.drawLoc());

        }catch (Exception e){

        }
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
}
