import java.util.ArrayList;
import java.util.HashSet;

public class Da77 extends Day7 {
    static int m(ArrayList list) {
        return 2;
    }

    public static void main(String[] args) {
        int sum = 0;
        int cnt = 0;

        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int i = 1; i < 6; i++) {

            hashSet.add(i * 2);

        }

        for (int t : hashSet) {
            if (cnt < 3) {

                sum += t;
                cnt++;
            } else {
                break;
            }
        }
        
    System.out.println("done");
    }
}
