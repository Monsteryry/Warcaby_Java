package ReakcjaNaZdarzenia;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ZamkniecieOknaImplementacjaWindowListenera extends Frame implements WindowListener
{
    ZamkniecieOknaImplementacjaWindowListenera()
    {
        addWindowListener(this);

        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new ZamkniecieOknaImplementacjaWindowListenera();
    }

    @Override
    public void windowOpened(WindowEvent e) { }

    @Override
    public void windowClosing(WindowEvent e)
    {
        dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }
}
