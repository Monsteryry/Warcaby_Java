package ReakcjaNaZdarzenia;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ZamkniecieOknaKlasaAnonimowa extends Frame
{
    ZamkniecieOknaKlasaAnonimowa()
    {
        setSize(300,300);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter()
        {
           public void windowClosing(WindowEvent e)
           {
               dispose();
           }
        });
    }

    public static void main(String[] args)
    {
        new ZamkniecieOknaKlasaAnonimowa();
    }
}


