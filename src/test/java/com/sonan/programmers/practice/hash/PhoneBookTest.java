package com.sonan.programmers.practice.hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-11
 * @since: 1.8
 */
class PhoneBookTest {
  @DisplayName("phone book test")
  @Test
  void solution() {
    assertEquals(false, new PhoneBook().solution(new String[]{"12","123","1235","567","88"}));
    assertEquals(true, new PhoneBook().solution(new String[]{"124","123"}));
    assertEquals(false, new PhoneBook().solution(new String[]{"119", "97674223", "1195524421"}));
    assertEquals(true, new PhoneBook().solution(new String[]{"123","456","789"}));
    assertEquals(false, new PhoneBook().solution(new String[]{"12","12"}));
    assertEquals(false, new PhoneBook().solution(new String[]{"1","1"}));
    assertEquals(false, new PhoneBook().solution(new String[]{"123","12"}));
    assertEquals(false, new PhoneBook().solution(new String[]{"12","123"}));
  }
}