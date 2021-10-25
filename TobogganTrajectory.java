import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TobogganTrajectory {
    public static void main(String[] args) {
        // System.out.println(trajectory(1,2));
        long a = trajectory(1, 1);
        System.out.println(a);

        long b = trajectory(3, 1);
        System.out.println(b);

        long c = trajectory(5, 1);
        System.out.println(c);

        long d = trajectory(7, 1);
        System.out.println(d);

        long e = trajectory(1, 2);
        System.out.println(e);

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
