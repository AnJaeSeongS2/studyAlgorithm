package com.sonan.programmers.ridi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-12-20
 * @since: 1.8
 */
class Solution3Test {

  @Test
  void solution() {
    assertEquals(6, new Solution3().solution(new int[]{3,2,4,8,7}));
    assertEquals(4, new Solution3().solution(new int[]{3,4,1,5,4}));
  }
}