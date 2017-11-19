package sample;

public class Oven {
    private boolean state;
    private Pan pan;

    public void setState(boolean state){
        this.state = state;
    }

    public boolean getState(){
        return state;
    }

    public void setPan(Pan pan){
        this.pan = pan;
    }

    public Pan getPan(){
        return pan;
    }

    public void Cook() {
        if (getState()) {
            while (!pan.IsReady()) {
                pan.GetStew();
            }
        }
    }
}
