import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the sliding puzzle game!!!");

        System.out.println("Choose the length and breadth of the sliding puzzle board.");
        System.out.println("Length: ");
        int length = scanner.nextInt();

        System.out.println("Breadth: ");
        int breadth = scanner.nextInt();

        PuzzleBoard board = new PuzzleBoard(length, breadth);
        board.shuffleGrid();

        char slideDirection;

        while (true) {
            System.out.println("\nChoose a move!");
            System.out.println("U -> Slide up");
            System.out.println("D -> Slide down");
            System.out.println("L -> Slide left");
            System.out.println("R -> Slide right");

            board.displayGrid();

            slideDirection = scanner.next().charAt(0);

            if (board.move(slideDirection) == -1) {
                System.out.println("Invalid move!\n");
            } else {
                board.displayGrid();
            }

            if(board.isComplete()) {
                System.out.println("Congrats!! You solved the sliding puzzle!\n");
                break;
            }
        }
    }
}