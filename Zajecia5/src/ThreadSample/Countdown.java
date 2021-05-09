package ThreadSample;

public class Countdown extends Thread
{
    private int counter;

    public Countdown()
    {
        counter = 10;
    }

    public void run()
    {
        while ( counter > 0)
        {
            System.out.println(counter);
            counter--;
            try
            {
                this.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if ( counter == 0 )
            {
                return;
            }
        }
    }
}
