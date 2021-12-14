package year2020.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day1/generatedInput.txt"))) {
            ArrayList<Integer> numbersFromInput = new ArrayList<>();
            while (cin.hasNextLine()) {
                numbersFromInput.add(cin.nextInt());
            }
            for (int i = 0; i < numbersFromInput.size(); i++) {
                for (int j = i + 1; j < numbersFromInput.size(); j++)
                    if (numbersFromInput.get(i) + numbersFromInput.get(j) == 2020){
                        System.out.println(numbersFromInput.get(i) * numbersFromInput.get(j));
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
