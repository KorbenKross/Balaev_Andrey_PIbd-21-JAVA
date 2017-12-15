package sample;

public class Pan {
    private Water[] water;
    private Potato[] potatos;
    private Carrot[] carrots;
    private Tomato[] tomatoes;
    private Zucchini[] zucchinies;
    private Bow[] bows;
    private Salt salt;
    private Spice spice;
    private tomato_paste paste;
    private  boolean readytogo;

    public void setReadyToGo(boolean readytogo){
        this.readytogo = readytogo;
    }

    public boolean getReadyToGo(){
        return Check();
    }

    public void Init(int countPotatos, int countCarrot, int countBow, int countTomato, int countZucchini)
    {
        water = new Water[3];
        potatos = new Potato[countPotatos];
        carrots = new Carrot[countCarrot];
        bows = new Bow[countBow];
        tomatoes = new Tomato[countTomato];
        zucchinies = new Zucchini[countZucchini];
    }

    public void AddWater(Water w)
    {
        for (int i = 0; i < water.length; ++i)
        {
            if (water[i] == null)
            {
                water[i] = w;
                return;
            }
        }

    }

    public void AddSalt(Salt s)
    {
        salt = s;
    }
    public void AddPaste(tomato_paste tp)
    {
        paste = tp;
    }
    public void AddSpice(Spice sp)
    {
        spice = sp;
    }
    public void AddPotato(Potato p)
    {
        for (int i = 0; i < potatos.length; ++i)
        {
            if (potatos[i] == null)
            {
                potatos[i] = p;
                return;
            }
        }
    }
    public void AddCarrot(Carrot c)
    {
        for (int i = 0; i < carrots.length; ++i)
        {
            if (carrots[i] == null)
            {
                carrots[i] = c;
                return;
            }
        }
    }
    public void AddBow(Bow b)
    {
        for (int i = 0; i < bows.length; ++i)
        {
            if (bows[i] == null)
            {
                bows[i] = b;
                return;
            }
        }
    }
    public void AddTomato(Tomato t)
    {
        for (int i = 0; i < tomatoes.length; ++i)
        {
            if (tomatoes[i] == null)
            {
                tomatoes[i] = t;
                return;
            }
        }
    }
    public void AddZucchini(Zucchini z)
    {
        for (int i = 0; i < zucchinies.length; ++i)
        {
            if (zucchinies[i] == null)
            {
                zucchinies[i] = z;
                return;
            }
        }
    }

    private boolean Check()
    {
        if (water.length == 0)
        {
            return false;
        }
        if (potatos.length == 0)
        {
            return false;
        }
        if (carrots.length == 0)
        {
            return false;
        }
        if (tomatoes.length == 0)
        {
            return false;
        }
        if (zucchinies.length == 0)
        {
            return false;
        }
        if (bows.length == 0)
        {
            return false;
        }
        for (int i = 0; i < water.length; ++i)
        {
            if (water[i] == null)
            {
                return false;
            }
        }
        for (int i = 0; i < potatos.length; ++i)
        {
            if (potatos[i] == null)
            {
                return false;
            }
        }
        for (int i = 0; i < carrots.length; ++i)
        {
            if (carrots[i] == null)
            {
                return false;
            }
        }
        for (int i = 0; i < tomatoes.length; ++i)
        {
            if (tomatoes[i] == null)
            {
                return false;
            }
        }
        for (int i = 0; i < zucchinies.length; ++i)
        {
            if (zucchinies[i] == null)
            {
                return false;
            }
        }

        for (int i = 0; i < bows.length; ++i)
        {
            if (bows[i] == null)
            {
                return false;
            }
        }
        return true;

    }
    public void GetStew() {
        if (!Check()) {
            return;
        }
        if (water.length > 0) {
            if (water[0].getTemperature() < 100) {
                for (int i = 0; i < water.length; ++i)
                {
                    water[i].GetStew();
                }
                boolean flag = false;
                switch (water[0].getTemperature()) {
                    case 20: flag = true; break;
                    case 40: flag = true; break;
                    case 60: flag = true; break;
                    case 80: flag = true; break;
                    case 100: flag = true; break;
                }
                if (flag) {
                    for (int i = 0; i < potatos.length; ++i)
                    {
                        potatos[i].GetStew();
                    }
                    for (int i = 0; i < carrots.length; ++i)
                    {
                        carrots[i].GetStew();
                    }
                    for (int i = 0; i < zucchinies.length; ++i)
                    {
                        zucchinies[i].GetStew();
                    }
                    for (int i = 0; i < tomatoes.length; ++i)
                    {
                        tomatoes[i].GetStew();
                    }
                    for (int i = 0; i < bows.length; ++i)
                    {
                        bows[i].GetStew();
                    }
                }
            }
        }
    }

    public boolean IsReady() {
        for (int i = 0; i < water.length; ++i)
        {
            if (water[0].getTemperature() < 100)
            {
                return false;
            }
        }
        for (int i = 0; i < potatos.length; ++i)
        {
            if (potatos[i].getHas_ready() < 2)
            {
                return false;
            }
        }
        for (int i = 0; i < carrots.length; ++i)
        {
            if (carrots[i].getHas_ready() < 2)
            {
                return false;
            }
        }
        for (int i = 0; i < zucchinies.length; ++i)
        {
            if (zucchinies[i].getHas_ready() < 2)
            {
                return false;
            }
        }
        for (int i = 0; i < tomatoes.length; ++i)
        {
            if (tomatoes[i].getHas_ready() < 2)
            {
                return false;
            }
        }
        for (int i = 0; i < bows.length; ++i)
        {
            if (bows[i].getHas_ready() < 2)
            {
                return false;
            }
        }
        return true;
    }
    public Water[] Drain() {
        return water;
    }
    public Potato[] GetPotatos() {
        return potatos;
    }
    public Carrot[] GetCarrot()
    {
        return carrots;
    }
    public Bow[] GetBows()
    {
        return bows;
    }
    public Zucchini[] GetZuccgini()
    {
        return zucchinies;
    }
    public Tomato[] GetTomato()
    {
        return tomatoes;
    }
}
