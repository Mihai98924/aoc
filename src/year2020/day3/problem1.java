package year2020.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1 {
    public static int width, height, numberOfTrees;
    public static int[][] forestMap;

    static boolean isInRange(int i, int j) {
        return i < height;
    }

    static void goingThroughTheMap(int i, int j) {
        if (forestMap[i][j] == -5) {
            forestMap[i][j] = 3;
            numberOfTrees++;
        } else {
            forestMap[i][j] = 1;
        }
        if (isInRange(i + 1, j + 3)) {
            goingThroughTheMap(i + 1, (j + 3) % width);
        }
    }

    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day3/generatedInput.txt"))) {
            forestMap = new int[1001][1001];
            while (cin.hasNextLine()) {
                char[] input = cin.nextLine().toCharArray();
                if (width == 0)
                    width = input.length;
                for (int j = 0; j < input.length; j++) {
                    if (input[j] == '.') {
                        forestMap[height][j] = 0;
                    } else if (input[j] == '#') {
                        forestMap[height][j] = -5;
                    }
                }
                height++;
            }
            height++;
            goingThroughTheMap(0,0);
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++) {
                    if (forestMap[i][j] == 0)
                        System.out.print(".");
                    else if (forestMap[i][j] == -5)
                        System.out.print("#");
                    else if(forestMap[i][j]==3)
                        System.out.print("X");
                    else
                        System.out.print("O");
                }
                System.out.println();
            }
            System.out.println(numberOfTrees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
