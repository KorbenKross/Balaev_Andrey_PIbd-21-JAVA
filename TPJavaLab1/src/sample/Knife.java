package sample;

public class Knife {
    public void Clean_potato(Potato p) {
        if (p.getHave_skin())
        {
            p.setHave_skin(false);
        }
    }
    public void Clean_carrot(Carrot c)
    {
        if (c.getHave_skin())
        {
            c.setHave_skin(false);
        }
    }
}
