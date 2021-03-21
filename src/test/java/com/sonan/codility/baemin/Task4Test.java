package com.sonan.codility.baemin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Task4Test {

    @Test
    void solution() {
        int[] A = new int[100_000];
        int[] B = new int[100_000];
        for (int i = 100_000; i > 0; i--) {
            A[100_000 - i] = i/10;
        }

        for (int i = 100_000; i > 0; i--) {
            B[100_000 - i] = (i+100_000)/10;
        }
        assertEquals(10_000, new Task4().solution(A, B));
        assertEquals(10_000, new Task4().solution(B, A));
        A[99_999] = 999999;
        assertEquals(-1, new Task4().solution(B, A));
        assertEquals(2, new Task4().solution(new int[]{1,3,2,1}, new int[]{4,2,5,3,2}));
        assertEquals(2, new Task4().solution(new int[]{1,1,2,3}, new int[]{2,2,3,4,5}));
        assertEquals(2, new Task4().solution(new int[]{2,2,3,4,5}, new int[]{1,1,2,3}));
        assertEquals(-1, new Task4().solution(new int[]{2,1}, new int[]{3,3}));
        assertEquals(4, new Task4().solution(new int[]{2,1,4}, new int[]{3,4,3}));
        assertEquals(-1, new Task4().solution(new int[]{3,4,3}, new int[]{9,10}));
        assertEquals(-1, new Task4().solution(new int[]{9,10}, new int[]{3,4,3}));
    }
}
