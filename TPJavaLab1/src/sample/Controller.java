package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.print.attribute.IntegerSyntax;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    final int initialValue = 0 ;
    private SpinnerValueFactory<Integer> valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);
    private Potato[] potatos;
    private Bow[] bow;
    private Carrot[] carrot;
    private Zucchini[] zucchini;
    private Tomato[] tomato;

    private Salt salt;
    private Spice spice;
    private tomato_paste tomato_paste;

    private WaterTap waterTap = new WaterTap();

    private Knife knife = new Knife();
    private Blender blender = new Blender();

    private Pan pan = new Pan();
    private Oven oven = new Oven();

    @FXML
    protected RadioButton radioButton1_CheckedChanged;

    @FXML
    protected RadioButton radioButton2_CheckedChanged;

    @FXML
    protected Spinner<Integer> numericUpDown1 = new Spinner<Integer>();

    @FXML
    protected Spinner<Integer> numericUpDown2 = new Spinner<Integer>();

    @FXML
    protected Spinner<Integer> numericUpDown3 = new Spinner<Integer>();

    @FXML
    protected Spinner<Integer> numericUpDown4 = new Spinner<Integer>();

    @FXML
    protected Spinner<Integer> numericUpDown5 = new Spinner<Integer>();

    @FXML
    protected Spinner<Integer> numericUpDown6 = new Spinner<Integer>();

    @FXML
    protected Spinner<Integer> numericUpDown7 = new Spinner<Integer>();

    @FXML
    protected Spinner<Integer> numericUpDown8 = new Spinner<Integer>();

    @FXML
    protected Button washPotato;

    @FXML
    protected Button washCarrot;

    @FXML
    protected Button washBow;

    @FXML
    protected Button washZucchini;

    @FXML
    protected Button washTomato;

    @FXML
    protected Button blendBtn;

    @FXML
    protected Button btnCleanPotatoBtn;

    @FXML
    protected Button btnCleanCarrotBtn;

    @FXML
    protected Button btnAddWater;

    @FXML
    protected Button btnAddPotato;

    @FXML
    protected Button btnAddBow;

    @FXML
    protected Button btnAddSalt;

    @FXML
    protected Button btnAddTomato;

    @FXML
    protected Button btnAddSpice;

    @FXML
    protected Button btnAddZucchini;

    @FXML
    protected Button btnAddCarrot;

    @FXML
    protected Button btnAddTomatePaste;

    @FXML
    protected CheckBox checkBoxOven;

    @FXML
    protected Button setOvenBtn;

    @FXML
    protected Button getReadyBtn;

    @FXML
    protected  Button getOutBtn;

    @FXML
    protected  Button dropWaterBtn;

    @FXML
    protected  Button getDishBtn;



    public void radioButton1_CheckedChanged(ActionEvent actionEvent) {
        if (radioButton1_CheckedChanged.isSelected())
        {
            waterTap.setState(true);
        }
    }

    public void radioButton2_CheckedChanged(ActionEvent actionEvent) {
        if (radioButton2_CheckedChanged.isSelected())
        {
            waterTap.setState(false);
        }
    }


    public void washPotato(ActionEvent actionEvent) {
        pan.Init(Integer.parseInt(String.valueOf(numericUpDown1.getValue())), Integer.parseInt(String.valueOf(numericUpDown2.getValue())), Integer.parseInt(String.valueOf(numericUpDown3.getValue())), Integer.parseInt(String.valueOf(numericUpDown4.getValue())), Integer.parseInt(String.valueOf(numericUpDown5.getValue())));

        if (numericUpDown1.getValue()> 0)
        {
            if (!waterTap.getState())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Кран закрыт, как мыть?");
                alert.showAndWait();
                return;
            }
            potatos = new Potato[numericUpDown1.getValue()];
            for (int i = 0; i < potatos.length; ++i)
            {
                potatos[i] = new Potato();
            }
            for (int i = 0; i < potatos.length; ++i)
            {
                potatos[i].setDirty(0);

            }
            washPotato.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Картошку помыли, можно чистить");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Картошки то нет, что мыть?");
            alert.showAndWait();
        }
    }

    public void washCarrot(ActionEvent actionEvent) {
        pan.Init(Integer.parseInt(String.valueOf(numericUpDown1.getValue())), Integer.parseInt(String.valueOf(numericUpDown2.getValue())), Integer.parseInt(String.valueOf(numericUpDown3.getValue())), Integer.parseInt(String.valueOf(numericUpDown4.getValue())), Integer.parseInt(String.valueOf(numericUpDown5.getValue())));

        if (numericUpDown2.getValue()> 0)
        {
            if (!waterTap.getState())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Кран закрыт, как мыть?");
                alert.showAndWait();
                return;
            }
            carrot = new Carrot[numericUpDown2.getValue()];
            for (int i = 0; i < carrot.length; ++i)
            {
                carrot[i] = new Carrot();
            }
            for (int i = 0; i < carrot.length; ++i)
            {
                carrot[i].setDirty(0);

            }
            washCarrot.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Морковь помыли, можно чистить");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Моркови то нет, что мыть?");
            alert.showAndWait();
        }
    }

    public void washZucchini(ActionEvent actionEvent) {
        pan.Init(Integer.parseInt(String.valueOf(numericUpDown1.getValue())), Integer.parseInt(String.valueOf(numericUpDown2.getValue())), Integer.parseInt(String.valueOf(numericUpDown3.getValue())), Integer.parseInt(String.valueOf(numericUpDown4.getValue())), Integer.parseInt(String.valueOf(numericUpDown5.getValue())));

        if (numericUpDown3.getValue()> 0)
        {
            if (!waterTap.getState())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Кран закрыт, как мыть?");
                alert.showAndWait();
                return;
            }
            zucchini = new Zucchini[numericUpDown3.getValue()];
            for (int i = 0; i < zucchini.length; ++i)
            {
                zucchini[i] = new Zucchini();
            }
            for (int i = 0; i < zucchini.length; ++i)
            {
                zucchini[i].setDirty(0);

            }
            washZucchini.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Кабачок помыли, можно чистить");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Кабачка то нет, что мыть?");
            alert.showAndWait();
        }
    }

    public void washTomato(ActionEvent actionEvent) {
        pan.Init(Integer.parseInt(String.valueOf(numericUpDown1.getValue())), Integer.parseInt(String.valueOf(numericUpDown2.getValue())), Integer.parseInt(String.valueOf(numericUpDown3.getValue())), Integer.parseInt(String.valueOf(numericUpDown4.getValue())), Integer.parseInt(String.valueOf(numericUpDown5.getValue())));

        if (numericUpDown4.getValue()> 0)
        {
            if (!waterTap.getState())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Кран закрыт, как мыть?");
                alert.showAndWait();
                return;
            }
            tomato = new Tomato[numericUpDown4.getValue()];
            for (int i = 0; i < bow.length; ++i)
            {
                tomato[i] = new Tomato();
            }
            for (int i = 0; i < tomato.length; ++i)
            {
                tomato[i].setDirty(0);

            }
            washTomato.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Помидоры помыли, можно чистить");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Помидор то нет, что мыть?");
            alert.showAndWait();
        }
    }

    public void washBow(ActionEvent actionEvent) {
        pan.Init(Integer.parseInt(String.valueOf(numericUpDown1.getValue())), Integer.parseInt(String.valueOf(numericUpDown2.getValue())), Integer.parseInt(String.valueOf(numericUpDown3.getValue())), Integer.parseInt(String.valueOf(numericUpDown4.getValue())), Integer.parseInt(String.valueOf(numericUpDown5.getValue())));

        if (numericUpDown5.getValue()> 0)
        {
            if (!waterTap.getState())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Кран закрыт, как мыть?");
                alert.showAndWait();
                return;
            }
            bow = new Bow[numericUpDown5.getValue()];
            for (int i = 0; i < bow.length; ++i)
            {
                bow[i] = new Bow();
            }
            for (int i = 0; i < bow.length; ++i)
            {
                bow[i].setDirty(0);

            }
            washBow.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Лук помыли, можно чистить");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Лука то нет, что мыть?");
            alert.showAndWait();
        }
    }

    public void radioBtnBlenderOnAction(ActionEvent actionEvent) {
        blender.setState(true);
    }

    public void radioBtnBlenderOffAction(ActionEvent actionEvent) {
        blender.setState(false);
    }

    public void blendBtnAction(ActionEvent actionEvent) {
        if (!blender.getState())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Блендер выключен, включите, чтоб измельчить ингредиенты!");
            alert.showAndWait();
            return;
        }
        pan.Init(Integer.parseInt(String.valueOf(numericUpDown1.getValue())), Integer.parseInt(String.valueOf(numericUpDown2.getValue())), Integer.parseInt(String.valueOf(numericUpDown3.getValue())), Integer.parseInt(String.valueOf(numericUpDown4.getValue())), Integer.parseInt(String.valueOf(numericUpDown5.getValue())));

        for (int i = 0; i < potatos.length; ++i)
        {
            blender.Cut_potato(potatos[i]);
        }

        for (int i = 0; i < carrot.length; ++i)
        {
            blender.Cut_carrot(carrot[i]);
        }

        for (int i = 0; i < bow.length; ++i)
        {
            blender.Cut_bow(bow[i]);
        }

        for (int i = 0; i < zucchini.length; ++i)
        {
            blender.Cut_zucchini(zucchini[i]);
        }
        for (int i = 0; i < tomato.length; ++i)
        {
            blender.Cut_tomato(tomato[i]);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Ингридиенты измельчены");
        alert.showAndWait();
        numericUpDown1.setDisable(true);
        numericUpDown2.setDisable(true);
        numericUpDown3.setDisable(true);
        numericUpDown4.setDisable(true);
        numericUpDown5.setDisable(true);
        blendBtn.setDisable(true);
    }

    public void btnCleanCarrotBtnAction(ActionEvent actionEvent) {
        if (carrot == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Моркови то нет, что чистить?");
            alert.showAndWait();
            return;
        }

        for (int i = 0; i < carrot.length; ++i)
        {
            if (carrot[i].getDirty() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Морковь грязная!!! Помыть бы ее сначала, а потом чистить");
                alert.showAndWait();
                return;
            }
        }
        for (int i = 0; i < carrot.length; ++i)
        {
            knife.Clean_carrot(carrot[i]);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Морковь помыли, можно кидать в кастрюлю");
        alert.showAndWait();
        btnCleanCarrotBtn.setDisable(true);
    }

    public void btnCleanPotatoBtnAction(ActionEvent actionEvent) {
        if (potatos == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Картошки то нет, что чистить?");
            alert.showAndWait();
            return;
        }

        for (int i = 0; i < potatos.length; ++i)
        {
            if (potatos[i].getDirty() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Картошка грязная!!! Помыть бы ее сначала, а потом чистить");
                alert.showAndWait();
                return;
            }
        }
        for (int i = 0; i < potatos.length; ++i)
        {
            knife.Clean_potato(potatos[i]);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Картошку помыли, можно кидать в кастрюлю");
        alert.showAndWait();
        btnCleanPotatoBtn.setDisable(true);
    }

    public void btnAddWaterAction(ActionEvent actionEvent) {
        if (!waterTap.getState())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Кран закрыт, как заливать?");
            alert.showAndWait();
            return;
        }
        for (int i = 0; i < 3; ++i)
        {
            pan.AddWater(waterTap.GetWater());
        }
        btnAddWater.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Воду залили");
        alert.showAndWait();
    }

    public void btnAddPotatoAction(ActionEvent actionEvent) {
        if (potatos == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Картошки то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        if (potatos.length == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Картошки то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        for (int i = 0; i < potatos.length; ++i)
        {
            if (potatos[i].getDirty() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Картошка грязная!!! Какой ее варить, а ну мыть ее быстро!!!");
                alert.showAndWait();
                return;
            }
            if (potatos[i].getHave_skin())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("У нас обычная картошка, не в мундире. Надо почистить!!!");
                alert.showAndWait();
                return;
            }
        }
        for (int i = 0; i < potatos.length; ++i)
        {
            pan.AddPotato(potatos[i]);
        }
        btnAddPotato.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Картошку положили, можно и на плиту.");
        alert.showAndWait();
    }

    public void btnAddBowAction(ActionEvent actionEvent) {
        if (bow == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Лука то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        if (bow.length == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Лука то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        for (int i = 0; i < bow.length; ++i)
        {
            if (bow[i].getDirty() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Лук грязный!!! Какой ее варить, а ну мыть ее быстро!!!");
                alert.showAndWait();
                return;
            }
            if (bow[i].getHave_cut())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Лук нужно измельчить!");
                alert.showAndWait();
                return;
            }
        }
        for (int i = 0; i < bow.length; ++i)
        {
            pan.AddBow(bow[i]);
        }
        btnAddBow.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Лук положили, можно и на плиту");
        alert.showAndWait();
    }

    public void btnAddSaltAction(ActionEvent actionEvent) {
        salt = new Salt();
        salt.setCount(numericUpDown6.getValue());
        if (salt.getCount() > 0)
        {
            pan.AddSalt(salt);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Соль добавили");
            alert.showAndWait();
            btnAddSalt.setDisable(true);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Соли же нет, что добавлять?");
            alert.showAndWait();
        }
    }

    public void btnAddTomatoAction(ActionEvent actionEvent) {
        if (tomato == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Помидор то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        if (tomato.length == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Помидор то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        for (int i = 0; i < tomato.length; ++i)
        {
            if (tomato[i].getDirty() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Помидора грязная!!! Какой ее варить, а ну мыть ее быстро!!!");
                alert.showAndWait();
                return;
            }
            if (tomato[i].getHave_cut())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Сначала измельчите ингридиент!!!");
                alert.showAndWait();
                return;
            }
        }
        for (int i = 0; i < tomato.length; ++i)
        {
            pan.AddTomato(tomato[i]);
        }
        btnAddTomato.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Томатной пасты же нет, что добавлять?");
        alert.showAndWait();
    }

    public void btnAddSpiceAction(ActionEvent actionEvent) {
        spice = new Spice();
        spice.setCount(numericUpDown7.getValue());
        if (spice.getCount() > 0)
        {
            pan.AddSpice(spice);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Специи добавили");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Специй же нет, что добавлять?");
            alert.showAndWait();
        }
        btnAddSpice.setDisable(true);
    }

    public void btnAddZucchiniAction(ActionEvent actionEvent) {
        if (zucchini == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Кабачков то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        if (zucchini.length == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Кабачков то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        for (int i = 0; i < zucchini.length; ++i)
        {
            if (zucchini[i].getDirty() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Кабачок грязный!!! Какой его варить, а ну мыть его быстро!!!");
                alert.showAndWait();
                return;
            }
            if (zucchini[i].getHave_cut())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Нужно сначала измельчить кабачок!!!");
                alert.showAndWait();
                return;
            }
        }
        for (int i = 0; i < zucchini.length; ++i)
        {
            pan.AddZucchini(zucchini[i]);
        }
        btnAddZucchini.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Кабачок положили, можно и на плиту");
        alert.showAndWait();
    }

    public void btnAddCarrotAction(ActionEvent actionEvent) {
        if (carrot == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Моркови то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        if (carrot.length == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Моркови то нет, что варить собрались?");
            alert.showAndWait();
            return;
        }
        for (int i = 0; i < carrot.length; ++i)
        {
            if (carrot[i].getDirty() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Морковь грязная!!! Какой ее варить, а ну мыть ее быстро!!!");
                alert.showAndWait();
                return;
            }
            if (carrot[i].getHave_skin())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("У нас обычная морковь, не в мундире. Надо почистить!!!");
                alert.showAndWait();
                return;
            }
        }
        for (int i = 0; i < carrot.length; ++i)
        {
            pan.AddCarrot(carrot[i]);
        }
        btnAddCarrot.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Морковь положили, можно и на плиту");
        alert.showAndWait();
    }

    public void btnAddTomatePasteAction(ActionEvent actionEvent) {
        tomato_paste = new tomato_paste();
        tomato_paste.setCount(numericUpDown8.getValue());
        if (tomato_paste.getCount() > 0)
        {
            pan.AddPaste(tomato_paste);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Томатную пасту добавили");
            alert.showAndWait();
            btnAddTomatePaste.setDisable(true);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Томатной пасты же нет, что добавлять?");
            alert.showAndWait();
        }
    }

    public void setOvenBtnAction(ActionEvent actionEvent) {
        oven.setPan(pan);
        setOvenBtn.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Жаровня на плите");
        alert.showAndWait();
    }

    public void checkBoxOvenAction(ActionEvent actionEvent) {
        oven.setState(checkBoxOven.isSelected());
    }

    public void getReadyBtnAction(ActionEvent actionEvent) {

        System.out.println(checkBoxOven.isSelected());
        if (!oven.getState())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Томить собрались энергией космоса или все же включим плиту?");
            alert.showAndWait();
            return;
        }
        if (!pan.getReadyToGo())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("У нас не все готово для томления!");
            alert.showAndWait();
            return;
        }

        oven.Cook();
        if (oven.getPan().IsReady())
        {
            checkBoxOven.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Готово!");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Что-то пошло не так...");
            alert.showAndWait();
            return;
        }
        getReadyBtn.setDisable(true);
    }

    public void getOutBtnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Убрали с плиты");
        alert.showAndWait();
        getOutBtn.setDisable(true);
    }

    public void dropWaterBtnAction(ActionEvent actionEvent) {
        pan.Drain();
        dropWaterBtn.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Воду слили");
        alert.showAndWait();
    }

    public void getDishBtnAction(ActionEvent actionEvent) {
        potatos = pan.GetPotatos();
        carrot = pan.GetCarrot();
        bow = pan.GetBows();
        zucchini = pan.GetZuccgini();
        tomato = pan.GetTomato();
        getDishBtn.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Мы сделали это! Приятного аппетита!");
        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        numericUpDown1.setValueFactory(valueFactory);
        numericUpDown2.setValueFactory(valueFactory);
        numericUpDown3.setValueFactory(valueFactory);
        numericUpDown4.setValueFactory(valueFactory);
        numericUpDown5.setValueFactory(valueFactory);
        numericUpDown6.setValueFactory(valueFactory);
        numericUpDown7.setValueFactory(valueFactory);
        numericUpDown8.setValueFactory(valueFactory);



    }
}
