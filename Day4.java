import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    static String[] keywords = new String[] { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };
    public static void main(String[] args) {
        int count = 0;
        Scanner scan = null;
        try {
            File file = new File("passports.txt");
            scan = new Scanner(file);
        } catch (Exception e) {}
        while (scan.hasNextLine()) {
            String passport = "";
            String word = scan.nextLine();
            while (!word.equals("") && scan.hasNextLine()) {
                passport += word + " ";
                word = scan.nextLine();
            }
            if (passportIsValid(passport)) {
                count++;
            }
        }
        System.out.println(count+1);
    }
    static boolean passportIsValid(String passport) {
        for (String keyword : keywords) {
            if (!passport.contains(keyword))
                return false;
        }
        for (String field : passport.split(" ")) {
            String[] keyword = field.split(":");
            switch (keyword[0]) {
                case "byr":
                    int num = Integer.parseInt(keyword[1]);
                    if (num > 2002 || num < 1920)
                        return false;
                    break;
                case "iyr":
                    num = Integer.parseInt(keyword[1]);
                    if (num > 2020 || num < 2010)
                        return false;
                    break;
                case "eyr":
                    num = Integer.parseInt(keyword[1]);
                    if (num > 2030 || num < 2020)
                        return false;
                    break;
                case "hgt":
                    if (isNumeric(keyword[1])) return false;
                    num = Integer.parseInt(keyword[1].substring(0, keyword[1].length()-2));
                    if (keyword[1].substring(keyword[1].length()-2).equals("cm")){
                        if (num < 150 || num > 193)
                            return false;
                    } 
                    if (keyword[1].substring(keyword[1].length()-2).equals("in")) {
                        if (num < 59 || num > 76)
                            return false;
                    } 
                    break;
                case "hcl":
                    if (!keyword[1].contains("#") || keyword[1].length() != 7) 
                        return false;
                    break;
                case "ecl":
                    if (!(keyword[1].equals("amb") || keyword[1].equals("blu") || keyword[1].equals("brn")
                            || keyword[1].equals("gry") || keyword[1].equals("grn")
                            || keyword[1].equals("hzl") || keyword[1].equals("oth")))
                        return false;
                    break;
                case "pid":
                    if (keyword[1].length() !=  9) 
                        return false;
                    if (!isNumeric(keyword[1]))
                        return false;
                    break;
            }
        }
        return true;
    }
    
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
