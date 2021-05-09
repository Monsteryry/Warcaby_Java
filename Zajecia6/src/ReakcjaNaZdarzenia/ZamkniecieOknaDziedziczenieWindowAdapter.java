package ReakcjaNaZdarzenia;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ZamkniecieOknaDziedziczenieWindowAdapter extends WindowAdapter
{
    Frame f;

    ZamkniecieOknaDziedziczenieWindowAdapter()
    {
        this.f = new Frame();
        f.addWindowListener(this);

        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void windowClosing(WindowEvent e)
    {
        f.dispose();
    }

    public static void main(String[] args)
    {
        new ZamkniecieOknaDziedziczenieWindowAdapter();
    }
}
