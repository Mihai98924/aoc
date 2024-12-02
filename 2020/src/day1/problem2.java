package year2020.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day1/generatedInput.txt"))) {
            ArrayList<Integer> numbersFromInput = new ArrayList<>();
            while (cin.hasNextLine()) {
                numbersFromInput.add(cin.nextInt());
            }
            for (int i = 0; i < numbersFromInput.size(); i++) {
                for (int j = i + 1; j < numbersFromInput.size(); j++) {
                    for (int k = j + 1; k < numbersFromInput.size(); k++)
                        if ((numbersFromInput.get(i) + numbersFromInput.get(j) + numbersFromInput.get(k)) == 2020) {
                            System.out.println(numbersFromInput.get(i) * numbersFromInput.get(j) * numbersFromInput.get(k));
                        }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
