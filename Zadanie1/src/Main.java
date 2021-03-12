import java.io.*;
import java.util.Scanner;



public class Main {

    String file = "Zadanie1/src/wizytowki.csv";

    public static void main(String[] args) {
        Main menu = new Main();
        menu.Menu();
    }

    private void Menu() {
        System.out.println("\nPodaj plik (domyslnie wizytowki.csv): ");
        getFile();
        drukujMenu();
        getInput();
    }

    private String getFile() {
        Scanner scan = new Scanner(System.in);
        String newFile = scan.nextLine();
        if (newFile == "") newFile = file;
        return ("Zadanie1/src/" + newFile);
    }

    private void drukujMenu() {
        System.out.println("\nWybierz opcje:");
        System.out.println("\n1.Wyswietlenie wszystkich wizytówek");
        System.out.println("\n2.Dodanie nowej wizytówk");
        System.out.println("\n3.Wyświetlenie wizytówki dla osób o określonym nazwisku");
        System.out.println("\n4.Zakończenie działania programu");
    }

    private void getInput() {
        Scanner scan = new Scanner(System.in);
        int a = 0;
        do{
            a = scan.nextInt();
            switch (a) {
                case 1:
                    showAll();
                    drukujMenu();
                    break;
                case 2:
                    addCard();
                    drukujMenu();
                    break;
                case 3:
                    showSpecific();
                    drukujMenu();
                    break;
                case 4:
                    System.out.println("\nZakończenie działania programu");
                    System.exit(0);
            }
        }while (a != 4);
    }

    private void createArray(String[] a1, String[] a2, int x) {
        int y = 0;
        for (int i = x; i < a1.length; i+=4) {
            a2[y] = a1[i];
            y++;
        }
    }

    private void showAll() {
        String data = readFile(file);
        String[] newData = data.split(";");
        int max = newData.length/4;

        String[] name = new String[max+1];
        String[] surname = new String[max+1];
        String[] phone = new String[max+1];
        String[] email = new String[max+1];

        createArray(newData, name, 0);
        createArray(newData, surname, 1);
        createArray(newData, phone, 2);
        createArray(newData, email, 3);

        for(int i = 0; i < max; i++) {
            System.out.println("Nr: " + (i+1));
            System.out.println("Imie: " + name[i]);
            System.out.println("Nazwisko: " + surname[i]);
            System.out.println("Telefon: " + phone[i]);
            System.out.println("Email: "+ email[i] + "\n");
        }
    }

    private void addCard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Imie:");
        String name = scan.nextLine();
        System.out.println("Nazwisko:");
        String surname = scan.nextLine();
        System.out.println("Telefon:");
        String phone = scan.nextLine();
        System.out.println("Email:");
        String email = scan.nextLine();

        String newL = "\n" + name + ";" + surname + ";" + phone + ";" + email;
        writeFile(file, newL);

    }

    private void showSpecific() {
        String data = readFile(file);
        String[] newData = data.split(";");
        int max = newData.length/4;

        String[] name = new String[max+1];
        String[] surname = new String[max+1];
        String[] phone = new String[max+1];
        String[] email = new String[max+1];

        createArray(newData, name, 0);
        createArray(newData, surname, 1);
        createArray(newData, phone, 2);
        createArray(newData, email, 3);

        System.out.println("Podaj nazwisko: ");
        Scanner scan = new Scanner(System.in);
        String x = scan.nextLine();

        for(int i = 0; i < max; i++) {
            if(surname[i].equals(x)) {
                System.out.println("Nr: " + (i+1));
                System.out.println("Imie: " + name[i]);
                System.out.println("Nazwisko: " + surname[i]);
                System.out.println("Telefon: " + phone[i]);
                System.out.println("Email: "+ email[i] + "\n");
            }
        }
    }

    public String readFile(String fileName) {
        String result = "";
        try {
            File myFile = new File(fileName);
            Scanner myScanner = new Scanner(myFile);
            while ( myScanner.hasNextLine() ) {
                result += myScanner.nextLine();
                result += ";";
            }
            myScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Ooops... Wystąpił błąd: ");
            e.printStackTrace();
        }
        return result;
    }

    public void writeFile(String fileName, String line) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(line);
            fw.close();
        }
        catch (IOException e) {
            System.out.println("Ooops... Wystąpił błąd: ");
            e.printStackTrace();
        }
    }
}