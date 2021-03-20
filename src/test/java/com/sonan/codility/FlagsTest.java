package com.sonan.codility;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/20
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class FlagsTest {

    @Test
    void solution() {
        assertEquals(1, new Flags().solution(new int[]{1,2,1}));
        assertEquals(1, new Flags().solution(new int[]{1,2,2}));
        assertEquals(2, new Flags().solution(new int[]{1,2,2,2,1}));
        assertEquals(0, new Flags().solution(new int[]{1,2,3,4,5}));
        assertEquals(0, new Flags().solution(new int[]{5,4,3,2,1}));
        assertEquals(0, new Flags().solution(new int[]{3,2,3}));
        assertEquals(3, new Flags().solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
    }

    @Test
    void genPeaks() {
        assertEquals(new HashSet<Integer>(){{add(1);}}, new Flags().genPeaks(new int[]{1,2,1}));
        assertEquals(new HashSet<Integer>(){{add(1); add(3); add(5); add(10);}}, new Flags().genPeaks(new int[]{1,5,3,4,3,4,1,2,3,4,6,2}));
    }
    @Test
    void genPeakDists() {
        assertArrayEquals(new int[]{}, new Flags().genPeakDists(new HashSet<Integer>(){{add(1);}}));
        assertArrayEquals(new int[]{2,2,5}, new Flags().genPeakDists(new HashSet<Integer>(){{add(1); add(3); add(5); add(10);}}));
    }

    @Test
    void canSetFlag() {
        assertEquals(true, new Flags().canSetFlag(2, new int[]{2,2,5}));
        assertEquals(true, new Flags().canSetFlag(3, new int[]{2,2,5}));
        assertEquals(false, new Flags().canSetFlag(4, new int[]{2,2,5}));
    }
}
