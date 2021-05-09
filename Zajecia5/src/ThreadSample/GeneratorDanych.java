package ThreadSample;

import java.io.IOException;

public class GeneratorDanych implements Runnable
{

    private DataSet dane;

    public GeneratorDanych(DataSet dane)
    {
        this.dane = dane;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        System.out.println(name + " wystartował.");
        synchronized (dane)
        {
            for ( int i=10; i>=0; i--)
            {
                System.out.println("Pobieram dane - jeszcze " + i + "s");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Dane pobrane! Przekazuję dalej!");

            dane.setDane("DANE DANE, KOCHANE DANE!");
            try
            {
                //dane.notify();
                dane.notifyAll();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
