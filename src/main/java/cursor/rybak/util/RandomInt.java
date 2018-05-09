package cursor.rybak.util;

import java.util.Random;

public class RandomInt {
    private static Random random = new Random();

    private RandomInt() {
    }

    /**
     * get random integer in range [1:maxValue)
     *
     * @param maxValue maxValue (exclusive)
     * @return random integer [1:maxValue)
     */
    public static int getRandom(int maxValue) {
        return random.nextInt(maxValue - 1) + 1;
    }
}
