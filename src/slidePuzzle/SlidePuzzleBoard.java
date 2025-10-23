<<<<<<< HEAD
package slidePuzzle;

import common.Board;

import java.util.*;

/**
 * Represents the internal logic of the Slide Puzzle board.
 * Handles moves, solvability, and display formatting.
 */
public class SlidePuzzleBoard extends Board<String> {
    private final int rows;
    private final int cols;
    private final int[] tiles; // 0 = blank tile

    public SlidePuzzleBoard(int rows, int cols) {
        if (rows < 2 || cols < 2)
            throw new IllegalArgumentException("Minimum puzzle size is 2x2.");
        this.rows = rows;
        this.cols = cols;
        this.tiles = new int[rows * cols];
        for (int i = 0; i < tiles.length - 1; i++) tiles[i] = i + 1;
        tiles[tiles.length - 1] = Tile.BLANK_ID;
    }

    /** Copy constructor */
    public SlidePuzzleBoard(SlidePuzzleBoard other) {
        this.rows = other.rows;
        this.cols = other.cols;
        this.tiles = Arrays.copyOf(other.tiles, other.tiles.length);
    }

    public int rows() { return rows; }
    public int cols() { return cols; }

    /** Returns true if puzzle is solved */
    @Override
    public boolean isSolved() {
        for (int i = 0; i < tiles.length - 1; i++)
            if (tiles[i] != i + 1) return false;
        return tiles[tiles.length - 1] == Tile.BLANK_ID;
    }

    /** Finds the position of the blank tile */
    public Position blankPos() {
        int b = indexOf(Tile.BLANK_ID);
        return Position.of(b / cols, b % cols);
    }

    /** Move the blank tile in a direction (U/D/L/R) */
    public boolean slide(Direction dir) {
        Position blank = blankPos();
        int nr = blank.row + dir.dRow;
        int nc = blank.col + dir.dCol;
        if (!inBounds(nr, nc)) return false;
        swap(idx(blank.row, blank.col), idx(nr, nc));
        return true;
    }

    /** Move a tile by its ID if adjacent to blank */
    public boolean slide(int tileId) {
        if (!canSlide(tileId)) return false;
        int t = indexOf(tileId);
        int b = indexOf(Tile.BLANK_ID);
        swap(t, b);
        return true;
    }

    /** Check whether a tile can slide into blank */
    public boolean canSlide(int tileId) {
        if (tileId <= 0 || tileId >= tiles.length) return false;
        int tileIdx = indexOf(tileId);
        int blankIdx = indexOf(Tile.BLANK_ID);
        int tr = tileIdx / cols, tc = tileIdx % cols;
        int br = blankIdx / cols, bc = blankIdx % cols;
        return Math.abs(tr - br) + Math.abs(tc - bc) == 1;
    }

    /** Shuffle the puzzle by making legal blank moves (always solvable) */
    public void shuffleSolvable(int steps, Random rng) {
        for (int s = 0; s < steps; s++) {
            List<Direction> moves = legalBlankMoves();
            slide(moves.get(rng.nextInt(moves.size())));
        }
    }

    /** Get list of all valid blank move directions */
    private List<Direction> legalBlankMoves() {
        List<Direction> ds = new ArrayList<>(4);
        Position b = blankPos();
        if (inBounds(b.row - 1, b.col)) ds.add(Direction.UP);
        if (inBounds(b.row + 1, b.col)) ds.add(Direction.DOWN);
        if (inBounds(b.row, b.col - 1)) ds.add(Direction.LEFT);
        if (inBounds(b.row, b.col + 1)) ds.add(Direction.RIGHT);
        return ds;
    }

    /** Swap two tile positions */
    private void swap(int i, int j) {
        int t = tiles[i];
        tiles[i] = tiles[j];
        tiles[j] = t;
    }

    /** Convert row/col to linear index */
    private int idx(int r, int c) { return r * cols + c; }

    /** Find index of a specific tile ID */
    private int indexOf(int id) {
        for (int i = 0; i < tiles.length; i++)
            if (tiles[i] == id) return i;
        return -1;
    }

    /** Check if position is inside board bounds */
    private boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    /** Return nicely formatted string of current board (auto-aligned) */
    @Override
    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        int width = String.valueOf(rows * cols - 1).length() + 1; // adjust width dynamically

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int v = tiles[idx(r, c)];
                if (v == Tile.BLANK_ID)
                    sb.append(String.format("%" + width + "s", "_"));
                else
                    sb.append(String.format("%" + width + "d", v));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
=======
package slidePuzzle;

import common.Board;

import java.util.*;

/**
 * Represents the internal logic of the Slide Puzzle board.
 * Handles moves, solvability, and display formatting.
 */
public class SlidePuzzleBoard extends Board<String> {
    private final int rows;
    private final int cols;
    private final int[] tiles; // 0 = blank tile

    public SlidePuzzleBoard(int rows, int cols) {
        if (rows < 2 || cols < 2)
            throw new IllegalArgumentException("Minimum puzzle size is 2x2.");
        this.rows = rows;
        this.cols = cols;
        this.tiles = new int[rows * cols];
        for (int i = 0; i < tiles.length - 1; i++) tiles[i] = i + 1;
        tiles[tiles.length - 1] = Tile.BLANK_ID;
    }

    /** Copy constructor */
    public SlidePuzzleBoard(SlidePuzzleBoard other) {
        this.rows = other.rows;
        this.cols = other.cols;
        this.tiles = Arrays.copyOf(other.tiles, other.tiles.length);
    }

    public int rows() { return rows; }
    public int cols() { return cols; }

    /** Returns true if puzzle is solved */
    @Override
    public boolean isSolved() {
        for (int i = 0; i < tiles.length - 1; i++)
            if (tiles[i] != i + 1) return false;
        return tiles[tiles.length - 1] == Tile.BLANK_ID;
    }

    /** Finds the position of the blank tile */
    public Position blankPos() {
        int b = indexOf(Tile.BLANK_ID);
        return Position.of(b / cols, b % cols);
    }

    /** Move the blank tile in a direction (U/D/L/R) */
    public boolean slide(Direction dir) {
        Position blank = blankPos();
        int nr = blank.row + dir.dRow;
        int nc = blank.col + dir.dCol;
        if (!inBounds(nr, nc)) return false;
        swap(idx(blank.row, blank.col), idx(nr, nc));
        return true;
    }

    /** Move a tile by its ID if adjacent to blank */
    public boolean slide(int tileId) {
        if (!canSlide(tileId)) return false;
        int t = indexOf(tileId);
        int b = indexOf(Tile.BLANK_ID);
        swap(t, b);
        return true;
    }

    /** Check whether a tile can slide into blank */
    public boolean canSlide(int tileId) {
        if (tileId <= 0 || tileId >= tiles.length) return false;
        int tileIdx = indexOf(tileId);
        int blankIdx = indexOf(Tile.BLANK_ID);
        int tr = tileIdx / cols, tc = tileIdx % cols;
        int br = blankIdx / cols, bc = blankIdx % cols;
        return Math.abs(tr - br) + Math.abs(tc - bc) == 1;
    }

    /** Shuffle the puzzle by making legal blank moves (always solvable) */
    public void shuffleSolvable(int steps, Random rng) {
        for (int s = 0; s < steps; s++) {
            List<Direction> moves = legalBlankMoves();
            slide(moves.get(rng.nextInt(moves.size())));
        }
    }

    /** Get list of all valid blank move directions */
    private List<Direction> legalBlankMoves() {
        List<Direction> ds = new ArrayList<>(4);
        Position b = blankPos();
        if (inBounds(b.row - 1, b.col)) ds.add(Direction.UP);
        if (inBounds(b.row + 1, b.col)) ds.add(Direction.DOWN);
        if (inBounds(b.row, b.col - 1)) ds.add(Direction.LEFT);
        if (inBounds(b.row, b.col + 1)) ds.add(Direction.RIGHT);
        return ds;
    }

    /** Swap two tile positions */
    private void swap(int i, int j) {
        int t = tiles[i];
        tiles[i] = tiles[j];
        tiles[j] = t;
    }

    /** Convert row/col to linear index */
    private int idx(int r, int c) { return r * cols + c; }

    /** Find index of a specific tile ID */
    private int indexOf(int id) {
        for (int i = 0; i < tiles.length; i++)
            if (tiles[i] == id) return i;
        return -1;
    }

    /** Check if position is inside board bounds */
    private boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    /** Return nicely formatted string of current board (auto-aligned) */
    @Override
    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        int width = String.valueOf(rows * cols - 1).length() + 1; // adjust width dynamically

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int v = tiles[idx(r, c)];
                if (v == Tile.BLANK_ID)
                    sb.append(String.format("%" + width + "s", "_"));
                else
                    sb.append(String.format("%" + width + "d", v));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
>>>>>>> d35a6f105c88dd6b403c2c1218c7bb2cf1d75e23
