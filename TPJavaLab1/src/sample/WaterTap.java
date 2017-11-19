package sample;

public class WaterTap {
    private boolean state;

    public void setState(boolean state){
        this.state = state;
    }

    public boolean getState(){
        return state;
    }

    public void Wash(Potato p, Carrot c)
    {
        if (getState())
        {
            p.setDirty(0);
            c.setDirty(0);
        }
    }
    public Water GetWater()
    {
        if (getState())
        {
            return new Water();
        }
        else
        {
            return null;
        }
    }
}
