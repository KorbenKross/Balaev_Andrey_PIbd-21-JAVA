package sample;

public class Water {
    private int temperature = 0;

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public int getTemperature(){
        return temperature;
    }

    public void GetStew() {
        if (temperature < 100)
        {
            temperature++;
        }
    }
}
