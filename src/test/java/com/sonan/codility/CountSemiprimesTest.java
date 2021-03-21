package com.sonan.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class CountSemiprimesTest {

    @Test
    void isSemiPrime() {
        assertArrayEquals(new int[]{10,4,0}, new CountSemiprimes().solution(26, new int[]{1,4,16}, new int[]{26,10,20}));

        /**
         * 1: 0 2:0, 3:0 4:2, 5:0, 6:2 7:0, 8:2 9:3 10:2
         *
         */

    }
}
