package com.sonan.programmers.kakao.y2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2020/09/05
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class LockAndKeyTest {

    @Test
    void solution() {
        assertTrue(new LockAndKey().solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
        assertTrue(new LockAndKey().solution(new int[][] {{0, 0, 1}, {0, 1, 0}, {0, 1, 0}}, new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }
}