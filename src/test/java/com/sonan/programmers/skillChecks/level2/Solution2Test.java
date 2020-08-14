package com.sonan.programmers.skillChecks.level2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-14
 * @since: 1.8
 */
class Solution2Test {

  @Test
  void solution() {
    assertEquals(2, new Solution2().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    assertEquals(4, new Solution2().solution(new int[]{1, 2, 2, 2, 10, 12}, 13));
  }
}