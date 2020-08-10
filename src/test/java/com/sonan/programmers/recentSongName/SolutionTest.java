package com.sonan.programmers.recentSongName;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-11
 * @since: 1.8
 */
class SolutionTest {
  @DisplayName("get Expect name : HELLO")
  @Test
  void solution() {
    Solution sol = new Solution();
    assertEquals("HELLO", sol.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
  }

  @DisplayName("test exception throw")
  @Test
  void testThrowException() {
    String str = null;
    Throwable cause = assertThrows(Exception.class, () -> {
      String.valueOf(null);
    });
    assertEquals(true, cause instanceof Exception);
  }
}