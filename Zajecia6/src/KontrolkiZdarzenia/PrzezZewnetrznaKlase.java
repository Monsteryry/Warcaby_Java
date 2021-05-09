package KontrolkiZdarzenia;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrzezZewnetrznaKlase extends Frame
{

    // Kontrolki:
    TextField tf = new TextField();
    Button btn = new Button("Kliknij tutaj!");
    Label lbl = new Label("Tutaj pojawi się tekst z pola powyżej", Label.CENTER);

    PrzezZewnetrznaKlase()
    {
        setSize(640, 320);
        setLayout(null);
        setVisible(true);

        // TextField:
        tf.setBounds(20, 80, 600, 20);
        add(tf);

        // Button:
        btn.setBounds(120, 140, 400, 30);
        ZewnetrznaKlasaObslugiZdarzenia outer = new ZewnetrznaKlasaObslugiZdarzenia(this);
        btn.addActionListener(outer);
        add(btn);

        // Label:
        lbl.setBounds(20, 210, 600, 30);
        lbl.setBackground(Color.lightGray);
        add(lbl);

        // Zamknięcie okna - klasa anonimowa:
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
        new PrzezZewnetrznaKlase();
    }
}
