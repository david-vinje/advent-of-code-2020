import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        while (scan.hasNextInt()) {
            nums.add(scan.nextInt());
        } scan.close();
        System.out.println(findTwoExpenses(nums, 2020)); 
        System.out.println(findThreeExpenses(nums, 2020)); 
    }

    static int findTwoExpenses(ArrayList<Integer> nums, int target) {
        for (int i = 0; i < nums.size(); i++)
            for (int j = i + 1; j < nums.size(); j++)
                if (nums.get(i) + nums.get(j) == target)
                    return nums.get(i) * nums.get(j);
        return 0;
    }
    static int findThreeExpenses(ArrayList<Integer> nums, int target) {
        for (int i = 0; i < nums.size(); i++)
            for (int j = i + 1; j < nums.size(); j++)
                for (int k = j + 1; k < nums.size(); k++)
                    if (nums.get(i) + nums.get(j) + nums.get(k) == target)
                        return nums.get(i) * nums.get(j) * nums.get(k);
        return 0;
    }
}