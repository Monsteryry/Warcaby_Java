package KontrolkiSwingPrzyklad;

import javax.swing.*;

public class SwingJTable
{
    private String data[][] = {
            {"001", "Jan", "Kowalski"},
            {"002", "Henryk", "Nowak"},
            {"007", "James", "Bond"},
            {"07", "Porucznik", "Borewicz"}
    };
    private String columns[] = {"ID_Agenta", "Imię", "Nazwisko"};
    JFrame frame;
    JTable jtable;

    SwingJTable()
    {
        frame = new JFrame();
        jtable = new JTable(data, columns);

        jtable.setBounds(10, 10, 620, 400);

        JScrollPane scrollPane = new JScrollPane(jtable);

        frame.add(scrollPane);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new SwingJTable();
    }
}
