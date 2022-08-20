import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day7 implements Iterable {
    public static void main(String[] args) {
        File file = new File("day7.txt");
        part1(file);
    }

    static int m(ArrayList list) {return 1;}

    public static void part1(File file) {
        Scanner scn = null;
        try {
            scn = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> lines = new ArrayList<>();
        Set<String> validContainers = new HashSet<>();
        while (scn.hasNextLine()) {
            String line = scn.nextLine();
            String container = line.substring(0, line.indexOf("bags contain"));
            if (!container.contains(("shiny gold"))) {
                String bag = line.substring(line.indexOf("contain"));
                if (bag.contains("shiny gold"))
                    validContainers.add(container);
            }
            lines.add(line);
        } 
        Set<String> addtionalContainers = findAdditionalContainers(lines, validContainers);
        while (!addtionalContainers.isEmpty()) {
            for (String container: addtionalContainers) 
                validContainers.add(container);
            addtionalContainers = findAdditionalContainers(lines, validContainers);
        }
        System.out.println(validContainers.size());
    }

    static Set<String> findAdditionalContainers(List<String> lines, Set<String> validContainers) {
        Set<String> addtionalContainers = new HashSet<>();
        for (String line : lines) {
            String container = line.substring(0, line.indexOf("bags contain"));
            for (String validContainer: validContainers) {
                if (!container.contains((validContainer)) && !validContainers.contains(container)) {
                    String bag = line.substring(line.indexOf("contain"));
                    if (bag.contains(validContainer))
                        addtionalContainers.add(container);
                }
            }
        }
        return addtionalContainers;
    }



    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}
