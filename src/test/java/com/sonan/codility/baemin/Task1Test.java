package com.sonan.codility.baemin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Task1Test {

    @Test
    void solution() {
        int[] maxIntArray = new int[100_000];
        for (Integer i = 0; i < 100_000; i++) {
            maxIntArray[i]=2;
        }

        StringJoiner result = new StringJoiner(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb.append(1);
        }
        result.add(sb.toString());
        result.add(sb.toString());

        assertEquals(result.toString(), new Task1().solution(100_000,100_000, maxIntArray));
        assertEquals("IMPOSSIBLE", new Task1().solution(2,3,new int[]{0,0,1,1,2}));
        assertEquals("11100,10001", new Task1().solution(3,2,new int[]{2,1,1,0,1}));
        assertEquals("1010,1010", new Task1().solution(2,2,new int[]{2,0,2,0}));
    }
}
