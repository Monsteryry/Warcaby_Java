import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class checkers extends JPanel implements ActionListener, MouseListener {
    @Serial
    private static final long serialVersionUID = 1L;
    public static int szer = 720, wys = szer;
    public static final int liczbaKratek = szer / 8;
    public static final int liczbaKratekWiersz = szer / liczbaKratek;
    public static int[][] planszaTab = new int[liczbaKratekWiersz][liczbaKratekWiersz];
    public static int[][] pionkiTab = new int[liczbaKratekWiersz][liczbaKratekWiersz];
    public static final int PUSTY = 0, CZERWONY = 1, CZERWONY_KROL = 2, BIALY = 3, BIALY_KROL = 4;
    public int wybrGracz = CZERWONY;
    public boolean wRuchu = false;
    public static int[][] dostZagraniaTab = new int[liczbaKratekWiersz][liczbaKratekWiersz];
    public int wybrWiersz, wybrKolumna;
    public boolean czySkok = false;
    static BufferedImage koronaObraz = null;

    public static void main(String[] args)
    {
        try
        {
            koronaObraz = ImageIO.read(new File("PROJEKT/crown.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        new checkers();
    }

    public checkers()
    {
        okno(szer, wys, this);
        stworzPlansze();
        repaint();
    }

    public boolean koniecGry()
    {
        return sprKoniecGry(0, 0, 0, 0);
    }

    public boolean sprKoniecGry(int kol, int wier, int czerwony, int bialy)
    {
        if (pionkiTab[kol][wier] == CZERWONY || pionkiTab[kol][wier] == CZERWONY_KROL)
            czerwony += 1;
        if (pionkiTab[kol][wier] == BIALY || pionkiTab[kol][wier] == BIALY_KROL)
            bialy += 1;
        if (kol == liczbaKratekWiersz - 1 && wier == liczbaKratekWiersz - 1)
        {
            if (czerwony == 0 || bialy == 0)
                return true;
            else return false;
        }
        if (kol == liczbaKratekWiersz - 1)
        {
            wier += 1;
            kol = -1;
        }
        return sprKoniecGry(kol + 1, wier, czerwony, bialy);
    }

    public void okno(int szer, int wys, checkers game)
    {
        JFrame ramka = new JFrame();
        ramka.setTitle("Warcaby");
        ramka.setSize(szer, wys);
        ramka.setIconImage(koronaObraz);
        ramka.setBackground(Color.darkGray);
        ramka.setLocationRelativeTo(null);
        ramka.pack();
        Insets insets = ramka.getInsets();
        int ramkaLewaKrawedz = insets.left;
        int ramkaPrawaKrawedz = insets.right;
        int ramkaGornaKrawedz = insets.top;
        int ramkaDolnaKrawedz = insets.bottom;
        ramka.setPreferredSize(new Dimension(szer + ramkaLewaKrawedz + ramkaPrawaKrawedz, wys + ramkaDolnaKrawedz + ramkaGornaKrawedz));
        ramka.setMaximumSize(new Dimension(szer + ramkaLewaKrawedz + ramkaPrawaKrawedz, wys + ramkaDolnaKrawedz + ramkaGornaKrawedz));
        ramka.setMinimumSize(new Dimension(szer + ramkaLewaKrawedz + ramkaPrawaKrawedz, wys + ramkaDolnaKrawedz + ramkaGornaKrawedz));
        ramka.setLocationRelativeTo(null);
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.addMouseListener(this);
        ramka.requestFocus();
        ramka.setVisible(true);
        ramka.add(game);
    }

    public void stworzPlansze()
    {
        for (int kol = 0; kol < (liczbaKratekWiersz); kol += 2)
        {
            pionkiTab[kol][5] = CZERWONY;
            pionkiTab[kol][7] = CZERWONY;
        }
        for (int kol = 1; kol < (liczbaKratekWiersz); kol += 2)
            pionkiTab[kol][6] = CZERWONY;
        for (int kol = 1; kol < (liczbaKratekWiersz); kol += 2)
        {
            pionkiTab[kol][0] = BIALY;
            pionkiTab[kol][2] = BIALY;
        }
        for (int kol = 0; kol < (liczbaKratekWiersz); kol += 2)
            pionkiTab[kol][1] = BIALY;
    }

    public static void drawPiece(int kol, int wier, Graphics g, Color color)
    {
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setColor(color);
        g.fillOval((kol * liczbaKratek) + 2, (wier * liczbaKratek) + 2, liczbaKratek - 4, liczbaKratek - 4);
    }

    public void paint(Graphics g)
    {
        super.paintComponent(g);
        for (int wier = 0; wier < liczbaKratekWiersz; wier++)
        {
            for (int kol = 0; kol < liczbaKratekWiersz; kol++)
            {
                if ((wier % 2 == 0 && kol % 2 == 0) || (wier % 2 != 0 && kol % 2 != 0))
                {
                    planszaTab[kol][wier] = 0;
                    g.setColor(Color.gray);
                }
                else
                {
                    planszaTab[kol][wier] = 1;
                    g.setColor(Color.darkGray);
                }
                g.fillRect(kol * liczbaKratek, wier * liczbaKratek, liczbaKratek, liczbaKratek);
                if (sprCzyjPionek(kol, wier))
                {
                    g.setColor(Color.darkGray.darker());
                    g.fillRect(kol * liczbaKratek, wier * liczbaKratek, liczbaKratek, liczbaKratek);
                }
                if (dostZagraniaTab[kol][wier] == 1)
                {
                    g.setColor(Color.CYAN.darker());
                    g.fillRect(kol * liczbaKratek, wier * liczbaKratek, liczbaKratek, liczbaKratek);
                }
                if (pionkiTab[kol][wier] == BIALY)
                    drawPiece(kol, wier, g, Color.white);
                else if (pionkiTab[kol][wier] == BIALY_KROL)
                {
                    drawPiece(kol, wier, g, Color.white);
                    g.drawImage(koronaObraz, (kol * liczbaKratek) + 6, (wier * liczbaKratek) + 6, liczbaKratek - 12, liczbaKratek - 12, null);
                }
                else if (pionkiTab[kol][wier] == CZERWONY)
                    drawPiece(kol, wier, g, Color.red);
                else if (pionkiTab[kol][wier] == CZERWONY_KROL)
                {
                    drawPiece(kol, wier, g, Color.red);
                    g.drawImage(koronaObraz, (kol * liczbaKratek) + 6, (wier * liczbaKratek) + 6, liczbaKratek - 12, liczbaKratek - 12, null);
                }
            }
        }
        if (koniecGry())
            gameOverDisplay(g);
    }

    public void gameOverDisplay(Graphics g)
    {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (szer - metr.stringWidth(msg)) / 2, szer / 2);
    }

    public void reset()
    {
        wybrKolumna = 0;
        wybrWiersz = 0;
        wRuchu = false;
        czySkok = false;
        for (int wier = 0; wier < liczbaKratekWiersz; wier++)
        {
            for (int kol = 0; kol < liczbaKratekWiersz; kol++)
            {
                dostZagraniaTab[kol][wier] = 0;
            }
        }
        repaint();
    }

    public void mousePressed(java.awt.event.MouseEvent evt)
    {
        int kol = (evt.getX() - 8) / liczbaKratek;
        int wier = (evt.getY() - 30) / liczbaKratek;
        if (!wRuchu  && pionkiTab[kol][wier] != 0 || wRuchu && sprCzyjPionek(kol, wier))
        {
            reset();
            wybrKolumna = kol;
            wybrWiersz = wier;
            getAvailablePlays(kol, wier);
        }
        else if (wRuchu && dostZagraniaTab[kol][wier] == 1)
        {
            wykonajRuch(kol, wier, wybrKolumna, wybrWiersz);
        }
        else if (wRuchu && dostZagraniaTab[kol][wier] == 0)
        {
            reset();
        }
    }

    public void zmianaGracza()
    {
        if (wybrGracz == CZERWONY)
            wybrGracz = BIALY;
        else wybrGracz = CZERWONY;
    }

    public void wykonajRuch(int kol, int wier, int wybrKolumna, int wybrWiersz)
    {
        int x = pionkiTab[wybrKolumna][wybrWiersz];
        pionkiTab[kol][wier] = x;
        pionkiTab[wybrKolumna][wybrWiersz] = PUSTY;
        sprKrol(kol, wier);
        if (czySkok)
            usunPionek(kol, wier, wybrKolumna, wybrWiersz);
        reset();
        zmianaGracza();
    }

    public void sprKrol(int kol, int wier)
    {
        if (pionkiTab[kol][wier] == CZERWONY && wier == 0)
            pionkiTab[kol][wier] = CZERWONY_KROL;
        else if (pionkiTab[kol][wier] == BIALY && wier == liczbaKratekWiersz - 1)
            pionkiTab[kol][wier] = BIALY_KROL;
    }

    public void usunPionek(int kol, int wier, int wybrKolumna, int wybrWiersz)
    {
        int pionekWiersz = -1;
        int pionekKolumna = -1;
        if (kol > wybrKolumna && wier > wybrWiersz)
        {
            pionekWiersz = wier - 1;
            pionekKolumna = kol - 1;
        }
        if (kol > wybrKolumna && wier < wybrWiersz)
        {
            pionekWiersz = wier + 1;
            pionekKolumna = kol - 1;
        }
        if (kol < wybrKolumna && wier > wybrWiersz)
        {
            pionekWiersz = wier - 1;
            pionekKolumna = kol + 1;
        }
        if (kol < wybrKolumna && wier < wybrWiersz)
        {
            pionekWiersz = wier + 1;
            pionekKolumna = kol + 1;
        }
        pionkiTab[pionekKolumna][pionekWiersz] = PUSTY;
    }

    public void getAvailablePlays(int kol, int wier)
    {
        wRuchu = true;
        if ((sprCzyjPionek(kol, wier)))
        {
            if (pionkiTab[kol][wier] == CZERWONY)
            {
                doGory(kol, wier);
            }
            if (pionkiTab[kol][wier] == BIALY)
            {
                naDol(kol, wier);
            }
            if (pionkiTab[kol][wier] == CZERWONY_KROL || pionkiTab[kol][wier] == BIALY_KROL)
            {
                doGory(kol, wier);
                naDol(kol, wier);
            }
            repaint();
        }
    }

    public void doGory(int kol, int wier)
    {
        int wierszGora = wier - 1;
        if (kol == 0 && wier != 0)
        {
            for (int i = kol; i < kol + 2; i++)
            {
                if (pionkiTab[kol][wier] != 0 && pionkiTab[i][wierszGora] != 0)
                {
                    if (czySkok(kol, wier, i, wierszGora))
                    {
                        int skokKol = pobierzPozycjeSkoku(kol, wier, i, wierszGora)[0];
                        int skokWier = pobierzPozycjeSkoku(kol, wier, i, wierszGora)[1];
                        dostZagraniaTab[skokKol][skokWier] = 1;
                    }
                }
                else if (planszaTab[i][wierszGora] == 1 && pionkiTab[i][wierszGora] == 0)
                    dostZagraniaTab[i][wierszGora] = 1;
            }
        }
        else if (kol == (liczbaKratekWiersz - 1) && wier != 0)
        {
            if (pionkiTab[kol][wier] != 0 && pionkiTab[kol - 1][wierszGora] != 0)
            {
                if (czySkok(kol, wier, kol - 1, wierszGora))
                {
                    int skokKol = pobierzPozycjeSkoku(kol, wier, kol - 1, wierszGora)[0];
                    int skokWier = pobierzPozycjeSkoku(kol, wier, kol - 1, wierszGora)[1];
                    dostZagraniaTab[skokKol][skokWier] = 1;
                }
            }
            else if (planszaTab[kol - 1][wierszGora] == 1 && pionkiTab[kol - 1][wierszGora] == 0)
                dostZagraniaTab[kol - 1][wierszGora] = 1;
        }
        else if (kol != liczbaKratekWiersz - 1 && kol != 0 && wier != 0)
        {
            for (int i = kol - 1; i <= kol + 1; i++)
            {
                if (pionkiTab[kol][wier] != 0 && pionkiTab[i][wierszGora] != 0)
                {
                    if (czySkok(kol, wier, i, wierszGora))
                    {
                        int skokKol = pobierzPozycjeSkoku(kol, wier, i, wierszGora)[0];
                        int skokWier = pobierzPozycjeSkoku(kol, wier, i, wierszGora)[1];
                        dostZagraniaTab[skokKol][skokWier] = 1;
                    }
                }
                else if (planszaTab[i][wierszGora] == 1 && pionkiTab[i][wierszGora] == 0)
                    dostZagraniaTab[i][wierszGora] = 1;
            }
        }
    }

    public void naDol(int kol, int wier)
    {
        int wierszDol = wier + 1;
        if (kol == 0 && wier != liczbaKratekWiersz - 1)
        {
            if (pionkiTab[kol][wier] != 0 && pionkiTab[kol + 1][wierszDol] != 0)
            {
                if (czySkok(kol, wier, kol + 1, wierszDol))
                {
                    int skokKol = pobierzPozycjeSkoku(kol, wier, kol + 1, wierszDol)[0];
                    int skokWier = pobierzPozycjeSkoku(kol, wier, kol + 1, wierszDol)[1];
                    dostZagraniaTab[skokKol][skokWier] = 1;
                }
            }
            else if (planszaTab[kol + 1][wierszDol] == 1 && pionkiTab[kol + 1][wierszDol] == 0)
                dostZagraniaTab[kol + 1][wierszDol] = 1;
        }
        else if (kol == liczbaKratekWiersz - 1 && wier != liczbaKratekWiersz - 1)
        {
            if (pionkiTab[kol][wier] != 0 && pionkiTab[kol - 1][wierszDol] != 0)
            {
                if (czySkok(kol, wier, kol - 1, wierszDol))
                {
                    int skokKol = pobierzPozycjeSkoku(kol, wier, kol - 1, wierszDol)[0];
                    int skokWier = pobierzPozycjeSkoku(kol, wier, kol - 1, wierszDol)[1];
                    dostZagraniaTab[skokKol][skokWier] = 1;
                }
            }
            else if (planszaTab[kol - 1][wierszDol] == 1 && pionkiTab[kol - 1][wierszDol] == 0)
                dostZagraniaTab[kol - 1][wierszDol] = 1;
        }
        else if (kol != liczbaKratekWiersz - 1 && kol != 0 && wier != liczbaKratekWiersz - 1)
        {
            for (int i = kol - 1; i <= kol + 1; i++)
            {
                if (pionkiTab[kol][wier] != 0 && pionkiTab[i][wierszDol] != 0)
                {
                    if (czySkok(kol, wier, i, wierszDol))
                    {
                        int skokKol = pobierzPozycjeSkoku(kol, wier, i, wierszDol)[0];
                        int skokWier = pobierzPozycjeSkoku(kol, wier, i, wierszDol)[1];
                        dostZagraniaTab[skokKol][skokWier] = 1;
                    }
                }
                else if (planszaTab[i][wierszDol] == 1 && pionkiTab[i][wierszDol] == 0)
                    dostZagraniaTab[i][wierszDol] = 1;
            }
        }
    }

    public boolean sprCzyjPionek(int kol, int wier)
    {
        if (wybrGracz == CZERWONY && (pionkiTab[kol][wier] == CZERWONY || pionkiTab[kol][wier] == CZERWONY_KROL)) //bottom
            return true;
        if (wybrGracz == BIALY && (pionkiTab[kol][wier] == BIALY || pionkiTab[kol][wier] == BIALY_KROL)) //top
            return true;
        else
            return false;
    }

    public boolean czyDozwolonaPozycja(int kol, int wier)
    {
        if (wier < 0 || wier >= liczbaKratekWiersz || kol < 0 || kol >= liczbaKratekWiersz)
            return false;
        else return true;
    }

    public boolean czySkok(int kol, int wier, int przeciwnikKol, int przeciwnikWier)
    {
        if (((pionkiTab[kol][wier] == BIALY || pionkiTab[kol][wier] == BIALY_KROL) && (pionkiTab[przeciwnikKol][przeciwnikWier] == CZERWONY || pionkiTab[przeciwnikKol][przeciwnikWier] == CZERWONY_KROL)) || (pionkiTab[kol][wier] == CZERWONY || pionkiTab[kol][wier] == CZERWONY_KROL) && (pionkiTab[przeciwnikKol][przeciwnikWier] == BIALY || pionkiTab[przeciwnikKol][przeciwnikWier] == BIALY_KROL))
        {
            if (przeciwnikKol == 0 || przeciwnikKol == liczbaKratekWiersz - 1 || przeciwnikWier == 0 || przeciwnikWier == liczbaKratekWiersz - 1)
                return false;
            int[] toData = pobierzPozycjeSkoku(kol, wier, przeciwnikKol, przeciwnikWier);
            if (!czyDozwolonaPozycja(toData[0], toData[1]))
                return false;
            if (pionkiTab[toData[0]][toData[1]] == 0)
            {
                czySkok = true;
                return true;
            }
        }
        return false;
    }

    public int[] pobierzPozycjeSkoku(int kol, int wier, int przeciwnikKol, int przeciwnikWier)
    {
        if (kol > przeciwnikKol && wier > przeciwnikWier && pionkiTab[kol - 2][wier - 2] == 0)
            return new int[] { kol - 2, wier - 2 };
        else if (kol > przeciwnikKol && wier < przeciwnikWier && pionkiTab[kol - 2][wier + 2] == 0)
            return new int[] { kol - 2, wier + 2 };
        else if (kol < przeciwnikKol && wier > przeciwnikWier && pionkiTab[kol + 2][wier - 2] == 0)
            return new int[] { kol + 2, wier - 2 };
        else
            return new int[] { kol + 2, wier + 2 };
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void actionPerformed(ActionEvent e) { }
}