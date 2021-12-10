import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day6 {
    public static void main(String[] args) {
        File file = new File("customs.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;
        ArrayList<String> answers = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equals("")) {
                count += checkAnswers(answers);
                answers = new ArrayList<>();
                continue;
            }
            answers.add(line);
        }
        System.out.println(count + checkAnswers(answers));
    }

    public static int checkAnswers(List<String> answers) {
        String s = answers.get(0);
        for (int i=1; i<answers.size(); i++) {
            s = intersection(s, answers.get(i));
            if (s.equals("")) return 0;
        }
        return s.length();
    }

    public static String intersection(String s1, String s2) {
        HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>();
        for (int i = 0; i < s1.length(); i++) {
            h1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            h2.add(s2.charAt(i));
        }
        h1.retainAll(h2);
        String res = "";
        for (char c : h1) 
            res += c;
        return res;
    }

    // First gold star solution
    public void customs1() {
        File file = new File("customs.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;
        HashSet<Character> answers = new HashSet<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equals("")) {
                count += answers.size();
                answers = new HashSet<>();
                continue;
            }
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                answers.add(chars[i]);
            }
        }
        scan.close();
        System.out.println(count + answers.size());
    }
}