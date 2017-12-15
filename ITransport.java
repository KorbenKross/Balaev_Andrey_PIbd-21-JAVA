package sample;

import java.awt.*;

/**
 * Created by dns on 20.10.2017.
 */
public interface ITransport {
    void moveCar();

    void drawCar();

    void setPosition(int x, int y);

    void loadPassenger(int count);

    int getPassenger();
}
