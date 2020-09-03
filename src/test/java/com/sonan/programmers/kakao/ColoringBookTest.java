package com.sonan.programmers.kakao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-17
 * @since: 1.8
 */
class ColoringBookTest {

  @Test
  void solution() {
    int m = 6;
    int n = 4;
    int[][] picture = new int[m][];
    picture[0] = new int[]{1,1,1,0};
    picture[1] = new int[]{1, 2, 2, 0};
    picture[2] = new int[]{1,0,0,1};
    picture[3] = new int[]{0,0,0,1};
    picture[4] = new int[]{0,0,0,3};
    picture[5] = new int[]{0,0,0,3};



    assertArrayEquals(new int[]{4,5}, new ColoringBook2().solution(m,n,picture));


    int[][] picture2 =
        {{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0}
        ,{0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0}
        ,{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}
        ,{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0}
        ,{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0}
        ,{0,1,1,1,1,2,1,1,1,1,2,1,1,1,1,0}
        ,{0,1,1,1,2,1,2,1,1,2,1,2,1,1,1,0}
        ,{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0}
        ,{0,1,3,3,3,1,1,1,1,1,1,3,3,3,1,0}
        ,{0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0}
        ,{0,0,1,1,1,1,1,2,2,1,1,1,1,1,0,0}
        ,{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0}
        ,{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}};
    assertArrayEquals(new int[]{12,120}, new ColoringBook2().solution(13,16,picture2));



    int[][] picture3 =
      {{0,0,0},
      {0,0,0},
      {0,0,0},
      {0,0,0}};
    int m3 = 4;
    int n3 = 3;
    assertArrayEquals(new int[]{0,0}, new ColoringBook2().solution(m3,n3,picture3));
  }
}