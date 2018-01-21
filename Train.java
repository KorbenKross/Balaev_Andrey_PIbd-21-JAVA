package sample;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by dns on 20.10.2017.
 */
public class Train extends Locomotive implements Serializable {



    protected int a = 10;
    protected int b = 200;

    public Train(int maxSpeed, int maxCountPassenger, int maxCapacityGenerator, double weight, javafx.scene.paint.Color color) {
        this.MaxSpeed = maxSpeed;
        this.MaxCountPassengers = maxCountPassenger;
        this.MaxCapacityGenerator = maxCapacityGenerator;
        this.setColorBody1(color);
        this.ColorBody1 = color;
        this.Weight = weight;
        this.countPassengers = 0;
        this.startPosX = a + (int) (Math.random() * b); // Генерация 1-го числа
        this.startPosY = a + (int) (Math.random() * b);  // Генерация 2-го числа
    }

    @Override
    public int getMaxSpeed() {
        return super.MaxSpeed;
    }
    @Override
    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 0 && maxSpeed < 200) {
            super.MaxSpeed = maxSpeed;
        } else {
            super.MaxSpeed = 150;
        }
    }


    @Override
    public double getWeight(){
        return super.Weight;
    }

    @Override
    public void setWeight(double weight) {
        if (weight > 800 && weight < 1300)
        {
            super.Weight = weight;
        }
        else
        {
            super.Weight = 1000;
        }
    }



    public Node drawCar()
    {
        return drawLoc();
    }


    protected Node drawLoc()
    {
        Parking parking = new Parking();

        Line line1 = new Line(startPosX + 100, startPosY , startPosX+105, startPosY + 5);
        Line line2 = new Line(startPosX + 10, startPosY + 40, startPosX + 30, startPosY + 40);
        Line line3 = new Line(startPosX + 75, startPosY + 40, startPosX + 95, startPosY + 40);
        Line line4 = new Line(startPosX - 5, startPosY + 20, startPosX, startPosY + 20);
        Line line5 = new Line(startPosX - 5, startPosY + 10, startPosX - 5, startPosY + 25);
        Line line6 = new Line(startPosX, startPosY + 10, startPosX + 10, startPosY );
        Line line7 = new Line(startPosX, startPosY + 25, startPosX + 100, startPosY + 25);

        Rectangle rectangle3 = new Rectangle(startPosX, startPosY, 100, 30);
        rectangle3.setFill(javafx.scene.paint.Paint.valueOf(String.valueOf(ColorBody1)));

        Rectangle rectangle1=new Rectangle(startPosX + 85, startPosY + 5, 20, 20);
        Rectangle rectangle2=new Rectangle(startPosX + 65, startPosY + 5, 10, 20);

        Ellipse ellipse1 = new Ellipse(startPosX + 10, startPosY + 30, 20, 20); //красный карандаш
        Ellipse ellipse2 = new Ellipse(startPosX + 25, startPosY+ 30, 15, 15); //красный карандаш
        Ellipse ellipse3 = new Ellipse(startPosX + 60, startPosY + 30, 15, 15); //красный карандаш
        Ellipse ellipse4 = new Ellipse( startPosX + 75, startPosY + 30, 15, 15); //красный карандаш
        ellipse1.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse2.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse3.setFill(javafx.scene.paint.Paint.valueOf("Red"));
        ellipse4.setFill(javafx.scene.paint.Paint.valueOf("Red"));

        Pane pane = new Pane(line1, line2, line3, line4, line5, line6, line7,ellipse2,ellipse4,rectangle1,rectangle2,rectangle3);
        parking.list.add(pane);
        return pane;
    }

    public void moveCar()
    {
        startPosX += (MaxSpeed * 50 / (float)Weight) / (countPassengers == 0 ? 1 : countPassengers);
        drawCar();
    }

    @Override
    public String getInfo() {
        return MaxSpeed + ";" + MaxCapacityGenerator + ";" + MaxCountPassengers + ";" + Weight + ";" + ColorBody1;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject(ColorBody1.toString());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        ColorBody1 = Color.web((String)s.readObject());
    }
}
