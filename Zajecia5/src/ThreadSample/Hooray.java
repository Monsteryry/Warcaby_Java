package ThreadSample;

public class Hooray implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("HOORAY! Countdown has just finished!");
    }
}
