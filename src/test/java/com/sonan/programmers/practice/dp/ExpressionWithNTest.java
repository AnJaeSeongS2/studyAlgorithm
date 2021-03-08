package com.sonan.programmers.practice.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/08
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class ExpressionWithNTest {

    @Test
    void solution() {
        assertEquals(new ExpressionWithN().solution(5, 12), 4);
        assertEquals(new ExpressionWithN().solution(5,  31168), -1);
    }
}
