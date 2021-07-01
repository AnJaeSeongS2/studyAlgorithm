package com.sonan.programmers.naverwebtoon.tutorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2021-07-01
 * @since: 1.8
 */
class SolutionTest {

  @Test
  void solution() {
    assertArrayEquals(new int[]{1, 10}, new Solution().solution(new int[][]{{1, 4}, {3, 4}, {3, 10}}));
    assertArrayEquals(new int[]{2, 1}, new Solution().solution(new int[][]{{1, 1}, {2, 2}, {1, 2}}));
  }
}