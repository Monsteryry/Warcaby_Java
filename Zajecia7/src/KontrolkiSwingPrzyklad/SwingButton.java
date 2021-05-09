package KontrolkiSwingPrzyklad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingButton
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("SwingButton");
        JButton btn1 = new JButton("Kliknij mnie!");

        btn1.setBounds(10, 10, 200, 200);
        frame.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "HELLO WORLD!");
            }
        });

        frame.setSize(235, 255);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
