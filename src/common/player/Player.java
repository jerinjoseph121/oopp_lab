<<<<<<< HEAD
package common.player;
/* Basic common.player model shared by all games. */
public class Player {
    private final String name;
    private final int id;
    private int score;
    private boolean isWinner;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = 0;
        this.isWinner = false;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public int getScore() { return score; }
    public void incrementScore() { score++; }
    public boolean isWinner() {return isWinner; }
    public void makeWinner() { isWinner = true; }
}
=======
package common.player;
/* Basic common.player model shared by all games. */
public class Player {
    private final String name;
    private final int id;
    private int score;
    private boolean isWinner;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        this.score = 0;
        this.isWinner = false;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public int getScore() { return score; }
    public void incrementScore() { score++; }
    public boolean isWinner() {return isWinner; }
    public void makeWinner() { isWinner = true; }
}
>>>>>>> d35a6f105c88dd6b403c2c1218c7bb2cf1d75e23
