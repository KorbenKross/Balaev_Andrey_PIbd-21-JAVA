package sample;

import java.awt.*;

/**
 * Created by dns on 19.10.2017.
 */
public abstract class Locomotive implements ITransport {

    protected float startPosX;
    protected float startPosY;
    protected int countPassengers;

    public int MaxCountPassengers;

    public int  MaxCapacityGenerator;

    public int MaxSpeed;

    public javafx.scene.paint.Color ColorBody;

    public double Weight;
    private Color color;
    private int pas;
    private int speed;
    private int generator;
    private double weight;
    public void setMaxCountPassengers(int pas){
        this.pas = pas;
    }
    public int getMaxCountPassengers(){
        return pas;
    }
    public void setMaxSpeed(int speed){
        this.speed = speed;
    }
    public int getMaxSpeed(){
        return speed;
    }
    public void setMaxCapacityGenerator(int generator){
        this.generator = generator;
    }
    public int getMaxCapacityGenerator(){
        return generator;
    }


    public void setColorBody(Color color){
        this.color = color;
    }
    public Color getColorBody(){
        return color;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }

    public abstract void moveCar();

    public abstract void drawCar();

    public void setPosition(int x, int y)
    {
        startPosX = x;
        startPosY = y;
    }

    public void loadPassenger(int count)
    {
        if (countPassengers + count < pas)
        {
            countPassengers += count;
        }
    }

    public int getPassenger()
    {
        int count = countPassengers;
        countPassengers = 0;
        return count;
    }
}
