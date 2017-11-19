package sample;

public class Blender {
    private boolean state;

    public void setState(boolean state){
        this.state = state;
    }

    public boolean getState(){
        return state;
    }

    public void Cut_potato(Potato p)
    {
        if (p.getHave_cut())
        {
            p.setHave_cut(false);
        }
    }
    public void Cut_carrot(Carrot c)
    {
        if (c.getHave_cut())
        {
            c.setHave_cut(false);
        }
    }
    public void Cut_bow(Bow b)
    {
        if (b.getHave_cut())
        {
            b.setHave_cut(false);
        }
    }
    public void Cut_zucchini(Zucchini z)
    {
        if (z.getHave_cut())
        {
            z.setHave_cut(false);
        }
    }
    public void Cut_tomato(Tomato t)
    {
        if (t.getHave_cut())
        {
            t.setHave_cut(false);
        }
    }

    public Blender GetWater()
    {
        if (getState())
        {
            return new Blender();
        }
        else
        {
            return null;
        }
    }
}
