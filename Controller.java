package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

public class Controller implements Initializable {
    Color color;
    Color dopColor;
    int maxSpeed;
    int maxCountPass;
    double weight;
    int maxCapacityGenerator;
    String[] arrData = new String[6];
    Parking parking = new Parking();
    private ITransport inter;
    Stage stage;
    Stage GameStage;

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

    @FXML
    ListView listBoxLevels;

    @FXML
    Button superAddBtn;

    public Stage stage1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        color = Color.GREEN;
        dopColor = Color.YELLOW;
        maxSpeed = 200;
        maxCountPass = 50;
        weight = 1000;

        for (int i = 0; i < 6; i++) {
            arrData[i] = "Уровень" + i;
        }
        ObservableList<String> data = FXCollections.observableArrayList(arrData);
        listBoxLevels.setItems(data);
        drawPanel.getChildren().addAll(parking.Draw());
        FormController formController = new FormController();
        if (formController.r == true) {
            System.out.println(formController.getR() + "e");
            int place = parking.PutCarInParking(formController.getItransport());
            Draw();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Ваше место: " + place);
        }

    }

    public void StatC(Stage stage) {
        this.stage1 = stage;
    }

    public void btnActLoc(ActionEvent actionEvent) {
        generalColor.setOnAction((ActionEvent t) -> {
            color = generalColor.getValue();
        });
        try {
            maxSpeed = Integer.parseInt(fieldMaxSpeed.getText());
            maxCountPass = Integer.parseInt(fieldMaxPas.getText());
            weight = Integer.parseInt(fieldWeight.getText());
            Train train = new Train(maxSpeed, maxCountPass, maxCapacityGenerator, weight, color);
            inter = train;
            drawPanel.getChildren().addAll(train.drawLoc());
        } catch (Exception e) {

        }
    }

    public void Draw() {
        drawPanel.getChildren().removeAll();
        if (listBoxLevels.getSelectionModel().getSelectedIndex() > -1) {//если выбран один из пуктов в listBox (при старте программы ни один пункт не будет выбран и может возникнуть ошибка, если мы попытаемся обратиться к элементу listBox)

            drawPanel.getChildren().setAll(parking.Draw());
        }
    }

    public void DrawTrain(ITransport inter1) {
        int place = parking.PutCarInParking(inter);
        drawPanel.getChildren().addAll(inter1.drawCar());
    }

    public void getTrainFromForm() {
        FormController formController = new FormController();
        ITransport train2 = formController.getTrain();
        inter = train2;
        int place = parking.PutCarInParking(inter);
        Draw();
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Ваше место: " + place);
    }

    public void btnActPasLoc(ActionEvent actionEvent) {

    }

    public void btnActMove(ActionEvent actionEvent) {
        Rectangle rectangle = new javafx.scene.shape.Rectangle(700, 270, javafx.scene.paint.Paint.valueOf("Grey"));
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
        int place = parking.PutCarInParking(inter);
        Draw();
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Ваше место: " + place);
    }

    public void putTrainBtnAction(ActionEvent actionEvent) {
        Train train = new Train(100, 4, 240, 1000, color);
        inter = train;
        int place = parking.PutCarInParking(inter);
        Draw();
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Ваше место: " + place);
    }

    public void takeBtnActionA(ActionEvent actionEvent) {
        if (countTrain.getText() != "") {
            ITransport train = parking.GetCarInParking(Integer.parseInt(countTrain.getText()));
            train.setPosition(5, 50);
            Draw();
            dopDrawPanel.getChildren().addAll(train.drawCar());
        }
    }

    public void lvlDownBtnAction(ActionEvent actionEvent) {
        parking.LevelDown();
        listBoxLevels.getSelectionModel().select(parking.getCurrentLevel());
        Draw();
    }

    public void lvlUpBtnAction(ActionEvent actionEvent) {
        parking.LevelUp();
        listBoxLevels.getSelectionModel().select(parking.getCurrentLevel());
        Draw();
    }

    public void superAddBtnAction(ActionEvent actionEvent) {
        try {
            stage = new Stage();
            String fxmlFile = "form.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = (Parent) fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));
            stage.setMinHeight(150);
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initOwner(GameStage);
            FormController formController = (FormController) fxmlLoader.getController();
            formController.StatC(stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
