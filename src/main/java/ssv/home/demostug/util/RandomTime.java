package ssv.home.demostug.util;

import java.util.Random;

public class RandomTime {

    private static final Random random = new Random();

    private RandomTime() {
    }

    /**
     * Возвращает случайное число в интервале 1000 ... 2000
     *
     * @return случайное число
     */
    public static int getRandomTime() {

        return 1000 + random.nextInt(1000);
    }
}
