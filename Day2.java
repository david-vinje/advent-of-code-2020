import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        oldPolicy();
        newPolicy();
    }

    static void newPolicy() throws FileNotFoundException {
        File file = new File("day2.txt");
        Scanner scan = new Scanner(file);
        String line = null;
        int a = 0, b = 0;
        char letter = 0;
        char[] password = null;
        int count = 0;
        while (scan.hasNext()) {
            line = scan.nextLine();
            a = Integer.parseInt(line.substring(0, line.indexOf("-")));
            b = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(":") - 2));
            letter = line.charAt(line.indexOf(":") - 1);
            password = line.substring(line.indexOf(":") + 2).toCharArray();
            if (password[a-1] == letter ^ password[b-1] == letter)
                count++;
        }
        scan.close();
        System.out.println(count);
    }

    static void oldPolicy() throws FileNotFoundException {        
        File file = new File("day2.txt");
        Scanner scan = new Scanner(file);
        String line = null;
        int lower = 0, upper = 0;
        char[] password = null;
        char match = 0;
        int matches = 0;
        int count = 0;
        while (scan.hasNext()) {
            line = scan.nextLine();
            lower = Integer.parseInt(line.substring(0, line.indexOf("-")));
            upper = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(":") - 2));
            match = line.charAt(line.indexOf(":") - 1);
            password = line.substring(line.indexOf(":") + 2).toCharArray();
            for (char letter : password)
                if (letter == match)
                    matches++;
            if (matches <= upper && matches >= lower)
                count++;
            matches = 0;
        }
        System.out.println(count);
    }
}
