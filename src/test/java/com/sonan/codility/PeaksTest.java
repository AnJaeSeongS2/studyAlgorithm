package com.sonan.codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class PeaksTest {

    @Test
    void solution() {
        assertEquals(0, new Peaks().solution(new int[]{5}));
        assertEquals(0, new Peaks().solution(new int[]{1,2,3}));
        assertEquals(3, new Peaks().solution(new int[]{1,2,3,4,3,4,1,2,3,4,6,2}));
    }
}
