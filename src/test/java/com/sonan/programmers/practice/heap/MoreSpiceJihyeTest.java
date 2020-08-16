package com.sonan.programmers.practice.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-16
 * @since: 1.8
 */
class MoreSpiceJihyeTest {

  @Test
  void solution() {

    assertEquals(2, new MoreSpiceJihye().solution(new int[]{1,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3,1,1,1,2,3}, 7));
    assertEquals(2, new MoreSpiceJihye().solution(new int[]{9, 3, 1, 2, 12, 10}, 7));
    assertEquals(2, new MoreSpiceJihye().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    assertEquals(4, new MoreSpiceJihye().solution(new int[]{1, 2, 2, 2, 10, 12}, 13));
  }
}