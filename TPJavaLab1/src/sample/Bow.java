package sample;

public class Bow {
    private boolean have_skin;
    private boolean have_cut;
    private int has_ready = 0;
    private int dirty = 10;

    public void setHave_skin(boolean have_skin){
        this.have_skin = have_skin;
    }

    public boolean getHave_skin(){
        return have_skin;
    }

    public void setHas_ready(int has_ready){
        this.has_ready = has_ready;
    }

    public int getHas_ready(){
        return has_ready;
    }

    public void setHave_cut(boolean have_skin){
        this.have_cut = have_cut;
    }

    public boolean getHave_cut(){
        return have_cut;
    }

    public void setDirty(int dirty){
        if (dirty > -1 && dirty < 11)
            this.dirty = dirty;
    }

    public int getDirty(){
        return dirty;
    }

    public void GetStew()
    {
        if (has_ready < 10)
        {
            has_ready++;
        }
    }
}
