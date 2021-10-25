import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PassportProcessing {
    static boolean byr = false, iyr = false, eyr = false, hgt = false, hcl = false, ecl = false, pid = false,
            newBatch = false;

    static int count = 0;

    public static void main(String[] args) {
        try {
            File file = new File("passports.txt");
            Scanner scan = new Scanner(file);
            String line = null;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                if (line.equals(""))
                    resetBatch();
                else {
                    String[] sa = null;
                    if (line.contains(" "))
                        sa = line.split(" ");
                    else {
                        sa = new String[0];
                        sa[0] = line;
                    }
                    for (int i=0; i<sa.length; i++) {
                        if (sa[i].contains("byr")) {
                            String[] a = sa[i].split(":");
                            int num = Integer.parseInt(a[1]);
                            if (num >= 1920 && num <= 2002)
                                byr = true;
                        }
                        if (sa[i].contains("iyr")) {
                            String[] a = sa[i].split(":");
                            int num = Integer.parseInt(a[1]);
                            if (num >= 2010 && num <= 2020)
                                byr = true;
                        }
                        if (sa[i].contains("eyr")) {
                            String[] a = sa[i].split(":");
                            int num = Integer.parseInt(a[1]);
                            if (num >= 2020 && num <= 2030)
                                byr = true;
                        }
                        if (sa[i].contains("hgt")) {
                            String[] a = sa[i].split(":");
                            if (a[1].contains("cm")) {
                                int num = Integer.parseInt(a[1].substring(0, a[1].length() - 2));
                                if (num >= 150 && num <= 193)
                                    byr = true;
                            } else if (a[1].contains("in")) {
                                int num = Integer.parseInt(a[1].substring(0, a[1].length() - 2));
                                if (num >= 59 && num <= 76)
                                    byr = true;
                            }
                        }
                        if (sa[i].contains("hcl")) {
                            String[] a = sa[i].split(":");
                            int num = Integer.parseInt(a[1]);
                            if (num > 1920 && num < 2002)
                                byr = true;
                        }
                        if (sa[i].contains("ecl")) {
                            String[] a = sa[i].split(":");
                            int num = Integer.parseInt(a[1]);
                            if (num > 1920 && num < 2002)
                                byr = true;
                        }
                        if (sa[i].contains("pid")) {
                            String[] a = sa[i].split(":");
                            int num = Integer.parseInt(a[1]);
                            if (num > 1920 && num < 2002)
                                byr = true;
                        }
                    }
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        resetBatch();
        System.out.println(count);
    }

    static void resetBatch() {
        if (byr && iyr && eyr && hgt && hcl && ecl && pid)
            count++;
        byr = false;
        iyr = false;
        eyr = false;
        hgt = false;
        hcl = false;
        ecl = false;
        pid = false;
    }
}
