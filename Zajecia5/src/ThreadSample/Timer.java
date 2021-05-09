package ThreadSample;

public class Timer extends Thread
{
    private long seconds;

    Timer()
    {
        this.seconds = 0;
    }

    public long getSeconds()
    {
        return seconds;
    }

    @Override
    public void run()
    {

        while ( true )
        {
            System.out.println(seconds);
            seconds++;
            try
            {
                this.sleep(1000);
            }
            catch ( InterruptedException e) { }
        }
    }
}
