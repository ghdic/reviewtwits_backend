package com.reviewtwits.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    public static String getRandomName(int len) {
        char[] randomName = new char[len];
        for(int i = 0; i < len; i++) {
            int randInt = ThreadLocalRandom.current().nextInt(0, 36);
            if(randInt < 10)
                randomName[i] = (char) ('0' + randInt);
            else
                randomName[i] = (char) ('a' + randInt - 10);
        }
        return String.valueOf(randomName);
    }
}
