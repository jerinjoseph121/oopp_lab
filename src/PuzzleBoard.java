import java.util.Random;

public class PuzzleBoard {
    int length;
    int breadth;

    int[] emptyPiecePosition = new int[2];

    int[][] board;

    public PuzzleBoard(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        board = new int[this.length][this.breadth];
        emptyPiecePosition[0] = length - 1;
        emptyPiecePosition[1] = breadth - 1;
    }

    public PuzzleBoard(int size) {
        this(size, size);
    }

    public PuzzleBoard() {
        this(3);
    }

    public void shuffleGrid() {
        int totalCount = (length * breadth) - 1;
        int[] randomArr = new int[totalCount];
        for (int i = 0; i < totalCount; i++) {
            randomArr[i] = i + 1;
        }
        Random random = new Random();
        for (int i = totalCount - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = random.nextInt(i + 1);

            // Swap arr[i] with the element at random index j
            int temp = randomArr[i];
            randomArr[i] = randomArr[j];
            randomArr[j] = temp;
        }

        int k = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                if (i == emptyPiecePosition[0] && j == emptyPiecePosition[1])
                    continue;
                board[i][j] = randomArr[k++];
            }
        }
    }

    private int totalDigits(int num) {
        return String.valueOf(num).length();
    }

    public void displayGrid() {
        int digits;
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++)
                System.out.print("+-----");
            System.out.println("+");
            for (int j = 0; j < breadth; j++) {
                if (board[i][j] == 0)
                    System.out.print("|     ");
                else{
                    digits = totalDigits(board[i][j]);

                    if (digits >= 3)
                        System.out.print("| ");
                    else
                        System.out.print("|  ");

                    System.out.print(board[i][j]);

                    if (digits == 1)
                        System.out.print("  ");
                    else
                        System.out.print(" ");
                }

            }
            System.out.println("|");
        }

        for (int k = 0; k < length; k++)
            System.out.print("+-----");
        System.out.println("+");
    }

    public boolean isComplete() {
        int k = 1;
        boolean isComplete = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                if (i == (length - 1) && j == (breadth - 1))
                    break;
                if (board[i][j] != k++)
                    isComplete = false;
            }
        }

        return isComplete;
    }

    private boolean isDirectionValid(char direction) {
        if (direction == 'U' || direction == 'u'
        || direction == 'D' || direction == 'd'
        || direction == 'R' || direction == 'r'
        || direction == 'L' || direction == 'l')
            return true;
        return false;
    }

    public int move(char direction) {
        int emptyPosX = emptyPiecePosition[0];
        int emptyPosY = emptyPiecePosition[1];

        if (emptyPosX < 0 || emptyPosX >= length || emptyPosY < 0 || emptyPosY >= breadth)
            return -1;

        if (!isDirectionValid(direction))
            return -1;

        if (direction == 'U' || direction == 'u') {
            if (emptyPosX == (length-1))
                return -1;

            int temp = board[emptyPosX + 1][emptyPosY];
            board[emptyPosX + 1][emptyPosY] = 0;
            board[emptyPosX][emptyPosY] = temp;
            emptyPiecePosition[0] =  emptyPosX + 1;

        } else if (direction == 'D' || direction == 'd') {
            if (emptyPosX == 0)
                return -1;

            int temp = board[emptyPosX - 1][emptyPosY];
            board[emptyPosX - 1][emptyPosY] = 0;
            board[emptyPosX][emptyPosY] = temp;
            emptyPiecePosition[0] =  emptyPosX - 1;

        } else if (direction == 'L' || direction == 'l') {
            if (emptyPosY == (breadth-1))
                return -1;

            int temp = board[emptyPosX][emptyPosY + 1];
            board[emptyPosX][emptyPosY + 1] = 0;
            board[emptyPosX][emptyPosY] = temp;
            emptyPiecePosition[1] =  emptyPosY + 1;

        } else if (direction == 'R' || direction == 'r') {
            if (emptyPosY == 0)
                return -1;

            int temp = board[emptyPosX][emptyPosY - 1];
            board[emptyPosX][emptyPosY - 1] = 0;
            board[emptyPosX][emptyPosY] = temp;
            emptyPiecePosition[1] =  emptyPosY - 1;

        }

        return 1;
    }
}
