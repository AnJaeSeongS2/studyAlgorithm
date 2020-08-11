package com.sonan.programmers.practice.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-12
 * @since: 1.8
 */
class HIndexTest {

  @Test
  void solution() {
    assertEquals(3, new HIndex().solution(new int[]{3,0,6,1,5}));
  }
}