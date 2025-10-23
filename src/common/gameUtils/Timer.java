<<<<<<< HEAD
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
=======
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
>>>>>>> d35a6f105c88dd6b403c2c1218c7bb2cf1d75e23
