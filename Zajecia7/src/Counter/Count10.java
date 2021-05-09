package Counter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Count10 implements Runnable
{
    private JButton STARTButton;
    private JPanel panel1;
    private JButton STOPButton;
    private JLabel label1;

    private int min = 9;
    private int sec = 59;

    Thread t = null;

    public Count10() {
        t = new Thread(this);

        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.start();
            }
        });
        STOPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Programista zapomniał zaimplementować!");
            }
        });
    }

    @Override
    public void run()
    {
        while ( min > -1 ) {
            if (sec > 0) {
                sec--;
            } else {
                sec = 59;
                min--;
            }
            label1.setText("00:"+String.valueOf(min) + ":" + String.valueOf(sec));
            try {
                t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Odliczanie");
        frame.setContentPane(new Count10().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
