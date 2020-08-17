package com.sonan.programmers.skillChecks.level2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-17
 * @since: 1.8
 */
class Solution5Test {

  @Test
  void solution() {
    assertEquals(1, new Solution5().solution(new int[]{1,2,3,4}));
    assertEquals(4, new Solution5().solution(new int[]{1,2,7,6,4}));
  }
}