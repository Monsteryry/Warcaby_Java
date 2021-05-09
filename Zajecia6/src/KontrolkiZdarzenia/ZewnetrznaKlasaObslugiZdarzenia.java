package KontrolkiZdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZewnetrznaKlasaObslugiZdarzenia implements ActionListener
{
    PrzezZewnetrznaKlase obj;
    ZewnetrznaKlasaObslugiZdarzenia(PrzezZewnetrznaKlase obj)
    {
        this.obj = obj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        obj.lbl.setText(obj.tf.getText());
    }
}
