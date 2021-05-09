package ThreadSample;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws InterruptedException, IOException {
     /*   Timer timer = new Timer();

        timer.start();
*/

      /*  Countdown fc = new Countdown();
        Thread[] hooray = new Thread[10];
        fc.start();
        fc.join();
        Thread.sleep(2000);
        for ( int i=0; i<10; i++)
        {
            hooray[i] = new Thread(new Hooray());
            Thread.sleep(100);
            hooray[i].start();
        }
        */

        /*Scanner s = new Scanner(System.in);
        boolean suspended = false;
        Timer timer = new Timer();
        timer.start();
        while ( true )
        {
             if ( System.in.read() == 10 )
             {
                    if ( !suspended )
                    {
                        suspended = true;
                        timer.suspend();
                    }
                    else
                    {
                        suspended = false;
                        timer.resume();

                    }

             }
        }
        */

        /*

        float zbiornik = 100;

        Silnik silnik1 = new Silnik(1, zbiornik);
        Silnik silnik2= new Silnik(25, zbiornik);

        silnik1.start();
        silnik2.start();

    */

        DataSet d = new DataSet("DANE DO OBRÓBKI");

        Konsument k1 = new Konsument(d);
        new Thread(k1, "Konsument 1.").start();
        Konsument k2 = new Konsument(d);
        new Thread(k2, "Konsument 2.").start();

        GeneratorDanych gd = new GeneratorDanych(d);
        new Thread(gd, "Generator danych").start();

        System.out.println("WĄTKI WYSTARTOWANE!");
    }
}
