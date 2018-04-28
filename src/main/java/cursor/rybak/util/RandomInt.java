package cursor.rybak.util;

import java.util.Random;

public interface RandomInt {
    Random random = new Random();

    /**
     * get random integer in range [1:maxValue)
     *
     * @param maxValue maxValue (exclusive)
     * @return random integer [1:maxValue)
     */
    default int getRandom(int maxValue) {
        return random.nextInt(maxValue - 1) + 1;
    }
}
