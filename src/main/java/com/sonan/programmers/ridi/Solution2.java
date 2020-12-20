package com.sonan.programmers.ridi;

/**
 * 문제 설명
 * a2 + b2 = c2 을 만족하게 하는 세 개의 자연수 a, b, c를 피타고라스의 수 또는 피타고라스의 세 쌍(Pythagorean triple)이라고 합니다. 세 개의 자연수 a, b, c( a<=b<=c<=500,000) 중 b 값이 매개변수로 주어 질 때, c값을 return 하도록 solution 함수를 작성하세요.
 *
 * 제한사항
 * 만족하는 c 값이 없다면 -1을 return 해주세요.
 * 만족하는 c 값이 여러 개라면 그 중 제일 작은 수를 return해주세요.
 * 입출력 예
 * b	result
 * 4	5
 * 12	13
 * 5	-1
 * 입출력 예 설명
 * 입출력 예 #1
 * a = 3, b = 4, c = 5가 피타고라스의 수가 됩니다.
 * 입출력 예 #2
 * a = 5, b = 12, c = 13 가 피타고라스의 수가 됩니다.
 * 입출력 예 #3
 * b가 5이면 피타고라스의 수를 만족하는 a, c는 존재하지 않습니다.
 *
 * @Calculated_Big_O: N
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-12-20
 * @since: 1.8
 */
public class Solution2 {
  public int solution(int b) {
    long longB = (long)b;

    long minCPlusA = longB + 1l;
    long maxCPlusA = longB + 500_000l;

    long cPlusA = 0;
    for (cPlusA = minCPlusA; cPlusA <= maxCPlusA; cPlusA++) {
      // 분모 / 분자
      long bottom = 2l * cPlusA;
      long top = cPlusA * cPlusA - longB * longB;
      long a = top / bottom;
      if (a > b) {
        return -1;
      }
      if (top >= bottom && top % bottom == 0) {
        return Long.valueOf(cPlusA - a).intValue();
      }
    }
    return -1;
  }
}
