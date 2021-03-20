package com.sonan.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/20
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class MaxDoubleSliceSumTest {

    @Test
    void solution() {
        assertEquals(17, new MaxDoubleSliceSum().solution(new int[]{3,2,6,-1,4,5,-1,2}));
    }
}
