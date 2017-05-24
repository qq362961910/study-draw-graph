package com.jy.draw.graph.common;

import java.util.Random;

public class DigitalUtil {
    private static final Random random = new Random();

    /**
     * 获取int随机数
     * @param min 随机的最小数值
     * @param max　随机的最大数值
     * */
    public static int randomInt(int min, int max) {
        int num = random.nextInt(max);
        if (num < min) {
            int range = max - min;
            int times = (min - num + range - 1) / range;
            num = num + range * times;
        }
        return num;
    }
}
