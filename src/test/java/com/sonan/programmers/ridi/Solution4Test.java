package com.sonan.programmers.ridi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-12-20
 * @since: 1.8
 */
class Solution4Test {

  @Test
  void solution() {
    assertEquals(2, new Solution4().solution(new int[]{20,10,10,20}));
    assertEquals(7, new Solution4().solution(new int[]{103,101,103,103,101,102,100,100,101,104}));
  }
}