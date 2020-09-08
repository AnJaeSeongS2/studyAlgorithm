package com.sonan.programmers.kakao.y2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2020/09/08
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class PillarAndBeamTest {

    @Test
    void solution() {
        //5	{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}}	{{1,0,0},{1,1,1},{2,1,0},{2,2,1},{3,2,1},{4,2,1},{5,0,0},{5,1,0}}
        //5	{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}}	{{0,0,0},{0,1,1},{1,1,1},{2,1,1},{3,1,1},{4,0,0}}

        int[][] expected = new int[][]{{1,0,0},{1,1,1},{2,1,0},{2,2,1},{3,2,1},{4,2,1},{5,0,0},{5,1,0}};
        int[][] tested = new PillarAndBeam().solution(5, new int[][]{{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}});
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], tested[i]);
        }

        int[][] expected2 = new int[][]{{0,0,0},{0,1,1},{1,1,1},{2,1,1},{3,1,1},{4,0,0}};
        int[][] tested2 = new PillarAndBeam().solution(5, new int[][]{{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}});
        for (int i = 0; i < expected2.length; i++) {
            assertArrayEquals(expected2[i], tested2[i]);
        }
    }
}