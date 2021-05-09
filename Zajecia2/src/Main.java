import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] arg) throws IOException {
        while ( true )
        {
            System.out.print("Podaj nazwę pliku, który chcesz wczytać: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            System.out.println(fileName);
        }
    }

    public static String readFile(String fileName)
    {
        String result = "";
        try
        {
            File myFile = new File(fileName);
            Scanner myScanner = new Scanner(myFile);
            while ( myScanner.hasNextLine() )
            {
                result += (myScanner.nextLine() + "\r\n");
            }
            myScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Ooops... Wystąpił błąd: ");
            e.printStackTrace();
        }
        return result;
    }

    public static void writeFile(String fileName, String line)
    {
        try
        {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(line);
            fw.close();
        }
        catch (IOException e)
        {
            System.out.println("Ooops... Wystąpił błąd: ");
            e.printStackTrace();
        }


    }
}
