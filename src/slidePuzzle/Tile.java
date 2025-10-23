package slidePuzzle;

/*Represents the blank tile constant for Slide Puzzle.*/
public final class Tile {
    public static final int BLANK_ID = 0;

    private final int id;

    public Tile(int id) { this.id = id; }

    public int id() { return id; }

    public boolean isBlank() { return id == BLANK_ID; }
}
