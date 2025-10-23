package common;

import javafx.util.Pair;

import java.util.Scanner;

public abstract class Board<T> {
    public static Pair<Integer, Integer> setupBoardDimensions(Scanner sc) {
        // setup board size
        System.out.print("Rows: ");
        int rows = sc.nextInt();
        while (rows < 2 || rows > 10) {
            System.out.println("\nRows value should be between 2 and 10");
            System.out.print("Rows: ");
            rows = sc.nextInt();
        }
        System.out.print("Cols: ");
        int cols = sc.nextInt();
        while (cols < 2 || cols > 10) {
            System.out.println("\nCols value should be between 2 and 10");
            System.out.print("Cols: ");
            cols = sc.nextInt();
        }

        sc.nextLine();// clear newline

        return new Pair<>(rows, cols);
    }
    public abstract boolean isSolved();
    public abstract T displayBoard();
}
