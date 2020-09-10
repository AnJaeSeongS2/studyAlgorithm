package com.sonan.programmers.monthlyTest.month9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-09-10
 * @since: 1.8
 */
class Solution2Test {

  @Test
  void solution() {
//    4	{1,2,9,3,10,8,4,5,6,7}
//    5	{1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}
//    6	{1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}
    assertArrayEquals(new int[]{1,2,9,3,10,8,4,5,6,7}, new Solution2().solution(4));
    assertArrayEquals(new int[]{1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}, new Solution2().solution(5));
    assertArrayEquals(new int[]{1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}, new Solution2().solution(6));

    assertArrayEquals(new int[]{1,2,9,3,10,8,4,5,6,7}, new Solution2().solution(4));
    assertArrayEquals(new int[]{1,2,12,3,13,11,4,14,15,10,5,6,7,8,9}, new Solution2().solution(5));
    assertArrayEquals(new int[]{1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11}, new Solution2().solution(6));
  }
}