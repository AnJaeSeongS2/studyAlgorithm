package com.sonan.programmers.practice.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/07/01
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class BestFarNodeTest {

    @Test
    void solution() {
        assertEquals(3, new BestFarNode().solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}