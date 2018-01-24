package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;


/**
 * Created by dns on 19.10.2017.
 */
public abstract class Locomotive implements ITransport {

    protected float startPosX;
    protected float startPosY;
    protected int countPassengers;

    public int MaxCountPassengers;

    public int MaxCapacityGenerator;

    public int MaxSpeed;

    public javafx.scene.paint.Color ColorBody;

    public double Weight;
    private Color color;
    private int pas;
    private int speed;
    private int generator;
    private double weight;
    protected Color ColorBody1;
    protected Color ColorBody2;

    public void setMaxCountPassengers(int pas) {
        this.pas = pas;
    }

    public int getMaxCountPassengers() {
        return pas;
    }

    public void setMaxSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return speed;
    }

    public void setMaxCapacityGenerator(int generator) {
        this.generator = generator;
    }

    public int getMaxCapacityGenerator() {
        return generator;
    }


    public void setColorBody(Color color) {
        this.color = color;
    }

    public Color getColorBody() {
        return color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public abstract void moveCar();

    public abstract Node drawCar();

    protected void setColorBody1(Color ColorBody1) {
        this.ColorBody1 = ColorBody1;
    }

    public Color getColorBody1() {
        return ColorBody1;
    }

    protected void setColorBody2(Color ColorBody2) {
        this.ColorBody2 = ColorBody2;
    }

    public Color getColorBody2() {
        return ColorBody2;
    }

    public void setPosition(int x, int y) {
        startPosX = x;
        startPosY = y;
    }

    public void loadPassenger(int count) {
        if (countPassengers + count < pas) {
            countPassengers += count;
        }
    }

    public int getPassenger() {
        int count = countPassengers;
        countPassengers = 0;
        return count;
    }

    public void setMainColor(Color c) {
        ColorBody1 = c;
    }

    public void setDopColor(Color c) {
        ColorBody2 = c;
    }
}
