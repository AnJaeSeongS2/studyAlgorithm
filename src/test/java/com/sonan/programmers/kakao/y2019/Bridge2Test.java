package com.sonan.programmers.kakao.y2019;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/18
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Bridge2Test {

    @Test
    void solution() {
        assertEquals(3, new Bridge2().solution(Arrays.asList(2, 4, 5, 3, 2, 1, 4, 2, 5, 1).stream().mapToInt(i -> i).toArray(), 3));
    }
}
