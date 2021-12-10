import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        long a = trajectory(1, 1);
        long b = trajectory(3, 1);
        long c = trajectory(5, 1);
        long d = trajectory(7, 1);
        long e = trajectory(1, 2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        // RESULT
        System.out.println(a*b*c*d*e);
    }

    static int trajectory(int right, int down) {
        int encounters = 0;
        int i = 0;
        String s = null;
        char[] a = null;
        try {
            File file = new File("trajectory.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) { 
                s = scan.nextLine();
                a = s.toCharArray();
                if (a[i] == '#')
                    encounters++;
                i += right;
                i %= a.length;
                for (int j = 1; j < down; j++)
                    if (scan.hasNextLine())
                        scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return encounters;
    }
}
