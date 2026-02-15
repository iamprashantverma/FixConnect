package com.fixconnect.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomIdGen {

    public static String gen(String prefix) {
        int r = ThreadLocalRandom.current().nextInt(100000, 999999);
        return prefix + r;
    }

}
