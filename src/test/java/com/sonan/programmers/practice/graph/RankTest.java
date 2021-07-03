package com.sonan.programmers.practice.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/07/03
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class RankTest {

    @Test
    void solution() {
        assertEquals(2, new Rank().solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}