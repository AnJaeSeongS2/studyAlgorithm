package com.sonan.programmers.practice.stack_queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-13
 * @since: 1.8
 */
class StockTest {

  @Test
  void solution() {
    assertArrayEquals(new int[]{4,3,1,1,0}, new Stock().solution(new int[]{1,2,3,2,3}));
  }
}