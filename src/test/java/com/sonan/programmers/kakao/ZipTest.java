package com.sonan.programmers.kakao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-15
 * @since: 1.8
 */
class ZipTest {

  @Test
  void solution() {
    assertArrayEquals(new int[]{11, 1, 27, 15}, new Zip().solution("KAKAO"));
    assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, new Zip().solution("TOBEORNOTTOBEORTOBEORNOT"));
    assertArrayEquals(new int[]{1, 2, 27, 29, 28, 31, 30}, new Zip().solution("ABABABABABABABAB"));
  }
}