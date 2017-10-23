package sample;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

//import java.awt.*;
import java.awt.Color;

/**
 * Created by dns on 20.10.2017.
 */
public class Train extends Locomotive {



    protected int a = 10;
    protected int b = 200;
    protected int startPosX = a + (int) (Math.random() * b); // Генерация 1-го числа
    protected int startPosY = a + (int) (Math.random() * b);  // Генерация 2-го числа

//    public Train(int maxSpeed, int maxCountPassengers, double weight, javafx.scene.paint.Color color) {
//        this.MaxSpeed = maxSpeed;
//        this.MaxCountPassengers = maxCountPassengers;
//        this.ColorBody = color;
//        this.Weight = weight;
//        this.countPassengers = 0;
//
//    }

    public Train(int maxSpeed, int maxCountPassenger, int maxCapacityGenerator, double weight, javafx.scene.paint.Color color) {
        this.MaxSpeed = maxSpeed;
        this.MaxCountPassengers = maxCountPassenger;
        this.MaxCapacityGenerator = maxCapacityGenerator;
        this.ColorBody = color;
        this.Weight = weight;
        this.countPassengers = 0;
//        super();
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



    public void drawCar()
    {
        drawLoc();

    }

    protected Node drawLoc()
    {
        Line line1 = new Line(startPosX + 100, startPosY , startPosX+105, startPosY + 5);
        Line line2 = new Line(startPosX + 10, startPosY + 40, startPosX + 30, startPosY + 40);
        Line line3 = new Line(startPosX + 75, startPosY + 40, startPosX + 95, startPosY + 40);
        Line line4 = new Line(startPosX - 5, startPosY + 20, startPosX, startPosY + 20);
        Line line5 = new Line(startPosX - 5, startPosY + 10, startPosX - 5, startPosY + 25);
        Line line6 = new Line(startPosX, startPosY + 10, startPosX + 10, startPosY );
        Line line7 = new Line(startPosX, startPosY + 25, startPosX + 100, startPosY + 25);

        Rectangle rectangle3 = new Rectangle(startPosX, startPosY, 100, 30);
        rectangle3.setFill(javafx.scene.paint.Paint.valueOf(String.valueOf(ColorBody)));

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


        Pane pane=new Pane(line1, line2, line3, line4, line5, line6, line7,ellipse2,ellipse4,rectangle1,rectangle2,rectangle3 );

        return pane;

    }

    public void moveCar()
    {
        startPosX += (MaxSpeed * 50 / (float)Weight) / (countPassengers == 0 ? 1 : countPassengers);
        drawCar();
    }
}
