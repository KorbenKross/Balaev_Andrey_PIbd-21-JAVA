package sample;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * Created by dns on 20.10.2017.
 */
public class PasTrain extends Train {
    private boolean lightEngine;
    private boolean anthen;
    private boolean roof;
    Line line1;
    Rectangle rectangle1;
    Rectangle rectangle3;

    private Color dopColor;

    public PasTrain(int maxSpeed, int maxCountPassenger, int maxCapacityGenerator, double weight, javafx.scene.paint.Color color, boolean lightEngine, boolean anthen, boolean roof, Color dopColor)
    {
        super(maxSpeed, maxCountPassenger, maxCapacityGenerator,weight, color);
        this.lightEngine = lightEngine;
        this.anthen = anthen;
        this.roof = roof;
        this.dopColor = dopColor;
    }

    @Override
    protected Node drawLoc()
    {
        Pane pane = null;
        if (anthen)
        {
            line1 = new Line(startPosX, startPosY - 30, startPosX + 30, startPosY - 30);
            Line line2 = new Line(startPosX, startPosY - 30, startPosX + 20, startPosY);
            Line line3 = new Line(startPosX + 30, startPosY - 30, startPosX + 20, startPosY);

            Line line4 = new Line(startPosX + 50, startPosY - 30, startPosX + 80, startPosY - 30);
            Line line5 = new Line(startPosX + 50, startPosY - 30, startPosX + 70, startPosY);
            Line line6 = new Line(startPosX + 80, startPosY - 30, startPosX + 70, startPosY);

            pane = new Pane(super.drawLoc(), line1, line2, line3, line4, line5, line6);
            return pane;
        }

        if (roof)
        {
            rectangle1 = new Rectangle(startPosX + 10, startPosY + 10, 80, 10);
            Rectangle rectangle2 = new Rectangle(startPosX + 10, startPosY + 30, 80, 10);
            rectangle2.setFill(javafx.scene.paint.Paint.valueOf(String.valueOf(dopColor)));
            pane = new Pane(super.drawLoc(), rectangle1, rectangle2);
            return pane;

        }
        if (lightEngine)
        {
            rectangle3 = new Rectangle(startPosX + 10, startPosY - 5, 70, 10);
            Rectangle rectangle4 = new Rectangle(startPosX + 10, startPosY - 5, 70, 10);
            pane = new Pane(super.drawLoc(), rectangle3, rectangle4);
            return pane;
        }

        return new Pane(super.drawLoc(),line1,rectangle1,rectangle3);
    }
}
