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
class Solution6Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{11, 1, 27, 15}, new Solution6().solution("KAKAO"));
    assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, new Solution6().solution("TOBEORNOTTOBEORTOBEORNOT"));
  }
}