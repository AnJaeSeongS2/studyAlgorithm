package com.sonan.programmers.naverwebtoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/07/04
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Sol1Test {

    @Test
    void solution() {
        assertEquals(45275, new Sol1().solution(new int[]{32000, 18000, 42500}, new int[]{50, 20, 65}));
    }
}