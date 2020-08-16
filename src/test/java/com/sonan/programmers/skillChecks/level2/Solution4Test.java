package com.sonan.programmers.skillChecks.level2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-16
 * @since: 1.8
 */
class Solution4Test {

  @Test
  void solution() {
    assertEquals(14, new Solution4().solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    assertEquals(15, new Solution4().solution(6,6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
  }
}