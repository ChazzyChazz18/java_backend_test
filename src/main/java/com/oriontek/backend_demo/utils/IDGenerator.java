package com.oriontek.backend_demo.utils;

import java.util.UUID;

public class IDGenerator {

    /**
     * Generate a Random Long type ID
     */
    public static long generate () {
        return Math.abs(UUID.randomUUID().getMostSignificantBits());
    }
    
}
