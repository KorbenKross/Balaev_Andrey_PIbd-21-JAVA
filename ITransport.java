package sample;

import javafx.scene.Node;

import java.awt.*;

/**
 * Created by dns on 20.10.2017.
 */
public interface ITransport {
    void moveCar();

    Node drawCar();

    void setPosition(int x, int y);

    void loadPassenger(int count);

    int getPassenger();

    void setMainColor(Color color);

    void setDopColor(Color color);

}
