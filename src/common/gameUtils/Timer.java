package common.gameUtils;

public class Timer {
    /* Formats time as Xm Ys */
    public static String formatTime(long totalSec) {
        long min = totalSec / 60;
        long sec = totalSec % 60;
        if (min == 0) return sec + "sec";
        return min + "min " + sec + "sec";
    }
}
