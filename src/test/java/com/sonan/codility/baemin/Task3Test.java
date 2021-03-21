package com.sonan.codility.baemin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Task3Test {

    @Test
    void solution() {
        int[] test = new int[90_000];
        for (int i = 0; i < 90_000; i++) {
            if (i %2 == 1) {
                test[i] = -(i/2);
            } else {
                test[i] = (i/2);
            }
        }
        assertEquals(44_999,new Task3().solution(test));
    }
}
