package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    @FXML
    Pane blueDrawPanel;

    @FXML
    protected Pane greenDrawPanel;

    @FXML
    protected Pane orangeDrawPanel;

    @FXML
    protected Pane blueseaDrawPanel;

    @FXML
    protected Pane grayDrawPanel;

    @FXML
    protected Pane redDrawPanel;

    @FXML
    Label trainID;

    @FXML
    Label pastrainID;

    @FXML
    Pane addTrainPanel;

    @FXML
    Label mainColorID;

    @FXML
    Label dopColorID;

    public Stage stage1;
    Parking parking = new Parking();
    public LinkedList<Node> list = new LinkedList<Node>();
    Color generalColor;
    static ITransport inter = null;
    static boolean r = false;
    Train train2;
    Stage GameStage2;
    Stage stage2;

    public void StatC(Stage stage) {
        this.stage1 = stage;
    }

    public boolean getR() {
        return r;
    }

    public ITransport getItransport() {
        return inter;
    }

    public void addBtnAction(ActionEvent actionEvent) throws IOException {
        r = true;
        new Controller();
        stage2 = new Stage();
        String fxmlFile = "sample.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = (Parent) fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));
        stage2.setMinHeight(150);
        stage2.setMinWidth(300);
        stage2.setResizable(false);
        stage2.setScene(new Scene(root));
        stage2.initStyle(StageStyle.UNDECORATED);
        stage2.initOwner(GameStage2);
        Controller formController = (Controller) fxmlLoader.getController();
        formController.StatC(stage2);
        stage2.show();
        stage1.close();
    }

    public void cancelAddBtnAction(ActionEvent actionEvent) {
        stage1.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addTrainPanel.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != addTrainPanel &&
                        event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        addTrainPanel.setOnDragExited(new EventHandler<DragEvent>() {
            public void handle(DragEvent t) {
                addTrainPanel.setEffect(null);
                t.consume();
            }
        });
        addTrainPanel.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    switch (db.getString()) {
                        case "Локомотив":
                            Train train = new Train(100, 4, 100, 1000, Color.WHITE);
                            inter = train;
                            train.setPosition(50, 50);
                            addTrainPanel.getChildren().removeAll();
                            addTrainPanel.getChildren().setAll(train.drawLoc());
                            r = true;
                            break;
                        case "Электровоз":
                            PasTrain pasTrain = new PasTrain(100, 4, 100, 1000, generalColor, true, true, true, Color.BLACK);
                            inter = pasTrain;
                            pasTrain.setPosition(50, 50);
                            addTrainPanel.getChildren().removeAll();
                            addTrainPanel.getChildren().setAll(pasTrain.drawLoc());
                            r = true;
                            break;
                    }
                    success = true;
                }
                event.setDropCompleted(true);
                event.consume();
            }
        });
        addTrainPanel.setOnDragDone(new EventHandler<Event>() {
            public void handle(Event event) {
                event.consume();
            }
        });

        mainColorID.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != mainColorID &&
                        event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        mainColorID.setOnDragExited(new EventHandler<DragEvent>() {
            public void handle(DragEvent t) {
                mainColorID.setEffect(null);
                t.consume();
            }
        });
        mainColorID.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    generalColor = Color.web(db.getString());
                    System.out.println(db.getString());
                    success = true;
                }
                event.setDropCompleted(true);
                event.consume();
            }
        });
    }

    public void pastrainIDDragEntered(DragEvent dragEvent) {
        if (dragEvent.getGestureSource() != pastrainID &&
                dragEvent.getDragboard().hasString()) {
            pastrainID.setTextFill(Color.GREEN);
        }
        dragEvent.consume();
    }

    public void trainIDDrag(MouseEvent mouseEvent) {
        Dragboard db = trainID.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(trainID.getText());
        db.setContent(content);
        mouseEvent.consume();
    }

    public void addTrainPanelEntered(DragEvent dragEvent) {
        if (dragEvent.getGestureSource() != addTrainPanel &&
                dragEvent.getDragboard().hasString()) {
            addTrainPanel.setStyle("-fx-background-color: cadetblue");
        }
        dragEvent.consume();
    }


    public void pastrainIDDrag(MouseEvent mouseEvent) {
        Dragboard db = pastrainID.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(pastrainID.getText());
        db.setContent(content);
        mouseEvent.consume();
    }

    public void blueDrawPanelDrag(MouseEvent mouseEvent) {
        Dragboard db = blueDrawPanel.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        String whatacolor = "";
        Object o = mouseEvent.getSource();
        if (o instanceof Region) {
            Background b = ((Region) o).getBackground();
            Paint p = b.getFills().get(0).getFill();
            Color color = (Color) p;
            whatacolor = color.toString();
        }
        content.putString(whatacolor);
        db.setContent(content);
        mouseEvent.consume();
    }

    public String getPanelColor(Color c) {
        String resColor = "";
        switch (c.toString()) {
            case "0x3333ffff":
                resColor = "0x3333ffff";
                break;
            case "0xff3333ff":
                resColor = "0xff3333ff";
                break;
            case "0xa59ba8ff":
                resColor = "0xa59ba8ff";
                break;
            case "0xff9900ff":
                resColor = "0xff9900ff";
                break;
            case "0x035450ff":
                resColor = "0x035450ff";
                break;
            case "0x004d00ff":
                resColor = "0x004d00ff";
                break;
        }
        return resColor;
    }

    public void redDrawPanelDrag(MouseEvent mouseEvent) {
        Dragboard db = redDrawPanel.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        String whatacolor = "";
        Object o = mouseEvent.getSource();
        if (o instanceof Region) {
            Background b = ((Region) o).getBackground();
            Paint p = b.getFills().get(0).getFill();
            Color color = (Color) p;
            whatacolor = color.toString();
        }
        content.putString(whatacolor);
        db.setContent(content);
        mouseEvent.consume();
    }

    public void greenDrawPanelDrag(MouseEvent mouseEvent) {
        Dragboard db = greenDrawPanel.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        String whatacolor = "";
        Object o = mouseEvent.getSource();
        if (o instanceof Region) {
            Background b = ((Region) o).getBackground();
            Paint p = b.getFills().get(0).getFill();
            Color color = (Color) p;
            whatacolor = color.toString();
        }
        content.putString(whatacolor);
        db.setContent(content);
        mouseEvent.consume();
    }

    public void blueseaDrawPanelDrag(MouseEvent mouseEvent) {
        Dragboard db = blueseaDrawPanel.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        String whatacolor = "";
        Object o = mouseEvent.getSource();
        if (o instanceof Region) {
            Background b = ((Region) o).getBackground();
            Paint p = b.getFills().get(0).getFill();
            Color color = (Color) p;
            whatacolor = color.toString();
        }
        content.putString(whatacolor);
        db.setContent(content);
        mouseEvent.consume();
    }

    public void grayDrawPanelDrag(MouseEvent mouseEvent) {
        Dragboard db = grayDrawPanel.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        String whatacolor = "";
        Object o = mouseEvent.getSource();
        if (o instanceof Region) {
            Background b = ((Region) o).getBackground();
            Paint p = b.getFills().get(0).getFill();
            Color color = (Color) p;
            whatacolor = color.toString();
        }
        content.putString(whatacolor);
        db.setContent(content);
        mouseEvent.consume();
    }

    public void orangeDrawPanelDrag(MouseEvent mouseEvent) {
        Dragboard db = orangeDrawPanel.startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        String whatacolor = "";
        Object o = mouseEvent.getSource();
        if (o instanceof Region) {
            Background b = ((Region) o).getBackground();
            Paint p = b.getFills().get(0).getFill();
            Color color = (Color) p;
            whatacolor = color.toString();
        }
        content.putString(whatacolor);
        db.setContent(content);
        mouseEvent.consume();
    }

    public ITransport getTrain() {
        return inter;
    }
}
