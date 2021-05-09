package ThreadSample;

public class Konsument implements Runnable
{
    private DataSet dane;

    public Konsument(DataSet dane)
    {
        this.dane=dane;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread().getName();
        synchronized (dane)
        {
            try
            {
                System.out.println( name + " gotowy, będzie czekał na dane.");
                dane.wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(name + " otrzymał dane: " + dane.getDane());
        }
    }

}