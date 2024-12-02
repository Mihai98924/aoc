package year2020.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    public static int width, height;
    public static long productOfTrees = 1, numberOfTrees;
    public static int[][] forestMap, initialForestMap;


    static void goingThroughTheMap(int i, int j, int l, int k) {
        if (forestMap[i][j] == -5 || forestMap[i][j] == 3) {
            forestMap[i][j] = 3;
            numberOfTrees++;
        } else {
            forestMap[i][j] = 1;
        }
        if (i < height) {
            goingThroughTheMap(i + k, (j + l) % width, l, k);
        }
    }

    static void reset() {
        forestMap = initialForestMap;
    }

    static void displayForest() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (forestMap[i][j] == 0)
                    System.out.print(".");
                else if (forestMap[i][j] == -5)
                    System.out.print("#");
                else if (forestMap[i][j] == 3)
                    System.out.print("X");
                else
                    System.out.print("O");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day3/generatedInput.txt"))) {
            initialForestMap = new int[1001][1001];
            while (cin.hasNextLine()) {
                char[] input = cin.nextLine().toCharArray();
                if (width == 0)
                    width = input.length;
                for (int j = 0; j < input.length; j++) {
                    if (input[j] == '.') {
                        initialForestMap[height][j] = 0;
                    } else if (input[j] == '#') {
                        initialForestMap[height][j] = -5;
                    }
                }
                height++;
            }
            height++;

            for (int i = 1; i <= 7; i += 2) {
                reset();
                goingThroughTheMap(0, 0, i, 1);
                productOfTrees *= numberOfTrees;
                numberOfTrees = 0;
                displayForest();
            }
            reset();
            goingThroughTheMap(0, 0, 1, 2);
            productOfTrees *= numberOfTrees;
            numberOfTrees = 0;

            System.out.println(productOfTrees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
