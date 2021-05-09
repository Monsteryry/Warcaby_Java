package PrzegladKontrolek;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class ControlsSample
{
    public static void main(String[] args)
    {
        Frame f = new Frame("Przykład użycia kontrolek");
        f.setSize(800, 600);
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                f.dispose();
            }
        });

        // Button
        int width = 200;
        int height = 50;
        int x = (800 - width)/2;
        int y = (600 - height)/2;

        Button button = new Button("Kliknij mnie!");
        button.setBounds(x, y, width, height);
        f.add(button);

        // Label
        Label label = new Label("To jest etykieta!");
        label.setBounds(20, 50, 200, 20);
        label.setBackground(Color.orange);
        label.setForeground(Color.red);
        f.add(label);

        // TextField
        TextField textField = new TextField();
        textField.setBounds(20, 100, 200, 20);
        textField.setText("To jest pole tekstowe!");
        f.add(textField);

        // TextArea
        TextArea textArea = new TextArea();
        textArea.setBounds(20, 150, 200, 80);
        textArea.setRows(4);
        textArea.setColumns(25);
        textArea.setText("To jest wieloliniowe pole tekstowe!");
        f.add(textArea);

        // CheckBox
        Checkbox checkBox1 = new Checkbox("CheckBox niezaznaczony");
        checkBox1.setBounds(20, 250, 200, 20);
        f.add(checkBox1);

        Checkbox checkBox2 = new Checkbox("CheckBox zaznaczony", true);
        checkBox2.setBounds(20, 280, 200, 20);
        f.add(checkBox2);

        // CheckBox Group (Radio Button)
        CheckboxGroup chkboxgrp = new CheckboxGroup();
        Checkbox chkbox1 = new Checkbox("Zaznaczony", chkboxgrp,true);
        chkbox1.setBounds(20, 310, 200, 20);
        Checkbox chkbox2 = new Checkbox("Nieznaznaczony", chkboxgrp, false);
        chkbox2.setBounds(20, 330, 200, 20);
        f.add(chkbox1);
        f.add(chkbox2);

        // Choice
        Choice choice = new Choice();
        choice.setBounds(20, 380, 200, 20);
        choice.add("Opcja 1");
        choice.add("Opcja 2");
        choice.add("Opcja 3");
        choice.add("Opcja 4");
        choice.add("Opcja 5");
        f.add(choice);

        // List
        List list = new List(5);
        list.setBounds(20, 430, 200, 50);
        list.add("Opcja 1");
        list.add("Opcja 2");
        list.add("Opcja 3");
        list.add("Opcja 4");
        list.add("Opcja 5");
        list.setMultipleMode(true);
        f.add(list);

        // Canvas
        class MyCanvas extends Canvas
        {
            public MyCanvas()
            {
                setBackground(Color.lightGray);
                setSize(200, 150);
                setBounds(550, 50, 200, 150);
            }

            @Override
            public void paint(Graphics g) {
                g.setColor(Color.magenta);
                g.drawString("HELLO FROM CANVAS", 30, 75);
            }
        }
        f.add(new MyCanvas());

        // Scrollbar
        Scrollbar scrollbar = new Scrollbar();
        scrollbar.setBounds(400, 50, 20, 150);
        f.add(scrollbar);

        // MenuBar, Menu & MenuItem
        MenuBar menubar = new MenuBar();
        Menu menu1 = new Menu("Menu");
        Menu menu2 = new Menu( "Menu 2");
        Menu submenu = new Menu ("SubMenu");
        menu1.add(new MenuItem("Menu 1"));
        menu1.add(new MenuItem("Menu 2"));
        submenu.add(new MenuItem("Submenu 1"));
        submenu.add(new MenuItem("Submenu 2"));
        menu1.add(submenu);
        menubar.add(menu1);
        menubar.add(menu2);
        f.setMenuBar(menubar);

        // PopUp Menu
        PopupMenu popupmenu = new PopupMenu("PopUp Menu");
        popupmenu.add("Pozycja 1");
        popupmenu.add("Pozycja 2");
        popupmenu.add("Pozycja 3");
        popupmenu.add("Pozycja 4");
        popupmenu.add("Pozycja 5");
        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                popupmenu.show(f, e.getX() + 50, e.getY() + 20);
            }
        });
        f.add(popupmenu);

        // Panel
        Panel panel = new Panel();
        panel.setBounds(550, 250, 200, 150);
        panel.setBackground(Color.GREEN);
        Button btn1 = new Button("Panel button 1");
        btn1.setBounds(50, 25, 100, 50);
        Button btn2 = new Button("Panel button 2");
        btn2.setBounds(50, 75, 100, 50);
        panel.add(btn1);
        panel.add(btn2);
        f.add(panel);

        // Dialog
        Dialog dialog = new Dialog(f, "Okno dialogowe", true);
        dialog.setSize(250, 250);
        dialog.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation((int)(screenSize.getWidth()/2 - 125), (int)(screenSize.getHeight()/2 - 125));
        dialog.setVisible(false);

        Button okBtn = new Button("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });
        dialog.add(okBtn);

        Button dialogToggler = new Button("Pokaż okno dialogowe");
        dialogToggler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });

        dialogToggler.setBounds(550, 450, 200, 50);
        f.add(dialogToggler);



    }


}