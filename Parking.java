package sample;


import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parking implements Serializable {
    List<ClassArray<ITransport>> parkingStages;
    public LinkedList<javafx.scene.Node> list= new LinkedList<Node>();
    int placceSizeWidth = 210;
    int placeSizeHeight = 80;
    int countPlaces = 4;
    int currentLevel;
    private ITransport inter;

    public int getCurrentLevel() {
        return currentLevel;
    }


    public Parking(){
        parkingStages = new ArrayList<ClassArray<ITransport>>();
        for (int i = 0; i < countPlaces; i++) {
            parkingStages.add(new ClassArray<ITransport>(countPlaces, null));
        }
        currentLevel = 0;
    }

    public void LevelUp() {
        if (currentLevel + 1 < parkingStages.size()) {
            currentLevel++;
        }
    }

    public void LevelDown() {
        if (currentLevel > 0) {
            currentLevel--;
        }
    }

    public int PutCarInParking(ITransport train) {
        return parkingStages.get(currentLevel).OpAddition(parkingStages.get(currentLevel), train);
    }

    public ITransport GetCarInParking(int statement) {
        return parkingStages.get(currentLevel).opSubtraction(parkingStages.get(currentLevel), statement);
    }

    public LinkedList<Node> Draw()  {
        list = new LinkedList<>();
        DrawMarking();
        for (int i = 0; i < countPlaces; i++) {
            ITransport train = parkingStages.get(currentLevel).getTrain(i);
            if (train != null) {
                train.setPosition(5 + i / 5 * placceSizeWidth + 5, i % 5 * placeSizeHeight + 30);
                list.add(train.drawCar());
            }
        }
        return list;
    }

    private void DrawMarking()
    {
        Text text = new Text(100, 100, "L" + (currentLevel + 1));
        list.add(text);
        list.add(new Rectangle(0, 0, (countPlaces / 5) * placceSizeWidth, 480));
        for (int i = 0; i < countPlaces; i++)
        {
            for (int j = 0; j < 6; ++j)
            {
                list.add(new Line(i * placceSizeWidth, j * placeSizeHeight, i * placceSizeWidth + 110, j * placeSizeHeight));
            }
            list.add(new Line(i * placceSizeWidth, 0, i * placceSizeWidth, 400));
        }
    }

    public boolean save(String fileName) throws IOException {
        FileOutputStream save = null;
        try {
            save = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream obSave = new ObjectOutputStream(save);
        System.out.println(parkingStages.get(0).getTrain(0).getInfo());
        obSave.writeObject(parkingStages);
        return true;
    }

    public boolean load(String filename) {
        try {
            ObjectInputStream obLoad = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
            try {
                parkingStages = ( ArrayList<ClassArray<ITransport>>) obLoad.readObject();
                System.out.println(parkingStages.get(0).getTrain(0).getInfo());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
