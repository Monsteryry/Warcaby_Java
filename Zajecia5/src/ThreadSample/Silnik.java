package ThreadSample;

public class Silnik extends Thread
{
    private float spalanieNaSekunde;
    public float zbiornik;

    public Silnik(float spalanieNaSekunde, float zbiornik)
    {
        this.spalanieNaSekunde = spalanieNaSekunde;
        this.zbiornik = zbiornik;
    }

    public void run()
    {
        boolean dziala = true;
        while ( dziala )
        {
            dziala = dzialaj();
            System.out.println("Silnik " +  this.getName() + " spalił paliwo. Pozostało: " + zbiornik);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean dzialaj()
    {
        if ( this.zbiornik > spalanieNaSekunde )
        {
            zbiornik -= spalanieNaSekunde;
            return true;
        }
        else {
            return false;
        }
    }
}
