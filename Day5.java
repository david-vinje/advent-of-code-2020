import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<Integer> ids = new ArrayList<>();
        int id = 0; 
        File file = new File("seats.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        while (scan.hasNext()) {
            int max = 127; int min = 0;
            char[] letters = scan.nextLine().toCharArray();
            for (int i=0; i<7; i++) {
                int mid = (int) (max + min) / 2;
                max = letters[i] == 'F' ? (int) mid : max;
                min = letters[i] == 'B' ? (int) mid+1 : min;
            }
            int row = max;
            max = 7; min = 0;
            for (int i=7; i<10; i++) {
                int mid = (int) (max + min) / 2;
                max = letters[i] == 'L' ? (int) mid : max;
                min = letters[i] == 'R' ? (int) mid + 1 : min;
            }
            int column = max;
            id = Math.max(id, 8*row+column);
            ids.add(8 * row + column);
        }
        Collections.sort(ids);
        for (int i=1; i<ids.size(); i++) {
            if (ids.get(i-1)+1 != ids.get(i)) {
                System.out.println(ids.get(i)-1);
            }
        }
    }
}
