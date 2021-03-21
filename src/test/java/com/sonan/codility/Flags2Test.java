package com.sonan.codility;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Jaeseong on 2021/03/20
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Flags2Test {

    @Test
    void solution() {
        assertEquals(2, new Flags2().solution(new int[]{3,2,3}));
        assertEquals(1, new Flags2().solution(new int[]{1,2,1}));
        assertEquals(1, new Flags2().solution(new int[]{1,2,3,4,5}));
        assertEquals(1, new Flags2().solution(new int[]{5,4,3,2,1}));
        assertEquals(3, new Flags2().solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
//        assertEquals(1, new Flags2().solution(new int[]{1,2,2}));
//        assertEquals(2, new Flags2().solution(new int[]{1,2,2,2,1}));
    }

    @Test
    void genPeaks() {
        assertEquals(new int[]{1}, new Flags2().genPeaks(new int[]{1,2,1}));
        assertEquals(new int[]{1,3,5,10}, new Flags2().genPeaks(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
    }
    @Test
    void genPeakDists() {
        assertArrayEquals(new int[]{}, new Flags2().genPeakDists(new int[]{1}));
        assertArrayEquals(new int[]{2,2,5}, new Flags2().genPeakDists(new int[]{1,3,5,10}));
    }

    @Test
    void canSetFlag() {
        assertEquals(true, new Flags2().canSetFlag(2, new int[]{2,2,5}));
        assertEquals(true, new Flags2().canSetFlag(3, new int[]{2,2,5}));
        assertEquals(false, new Flags2().canSetFlag(4, new int[]{2,2,5}));
    }
}
