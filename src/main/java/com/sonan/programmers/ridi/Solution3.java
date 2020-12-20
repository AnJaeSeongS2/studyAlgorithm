package com.sonan.programmers.ridi;

/**
 * 문제 설명
 * 중고차 딜러는 중고차를 사고 팔아 이익을 내려고 합니다. 중고차는 매일매일 가격이 변합니다. 중고차를 사거나 팔려고 할 때는 그 날의 중고차 가격으로만 거래할 수 있습니다. 또, 중고차는 주어진 기간동안 단 한 번만 구매 후 판매할 수 있습니다.
 * n일 동안의 중고차 가격이 들어있는 배열(prices)이 입력으로 주어질 때 얻을 수 있는 최대 이익을 return 하도록 solution 함수를 완성해 주세요. 배열의 i번째 요소는 i번째 날의 중고차 가격을 나타냅니다. 예를 들어 5일간 중고차의 가격이 [3, 2, 4, 8, 7] 인 경우 2원에 중고차를 구매하여 이틀 후 8원에 팔면 6의 이익이 발생하고, 이때 최대 이익을 얻을 수 있습니다. 단, 이익이 발생하지 않을 때는 중고차를 구매하지 않을 수도 있으며, 이때는 0을 return 합니다.
 *
 * 제한사항
 * 중고차 가격이 들어있는 배열(prices)의 크기 : 100,000 이하인 자연수
 * 중고차 가격 : 1,000,000 이하인 자연수
 * 입출력 예
 * prices	answer
 * [3, 2, 4, 8, 7]	6
 * [3, 4, 1, 5, 4]	4
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제의 예시와 같습니다.
 *
 * 입출력 예 #2
 * 3번째 날에 1원에 구매한 뒤, 다음 날 5원으로 팔면 4의 이익이 발생하는데, 이때 최대 이익을 얻을 수 있습니다.
 *
 * @Calculated_Big_O: N
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-12-20
 * @since: 1.8
 */
public class Solution3 {
  public int solution(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int maxBenefit = 0;

    int max = prices[0];
    int min = prices[0];
    int prev = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (min > prices[i]) {
        // max reset to 0
        min = prices[i];
        max = prices[i];
      } else {
        if (max < prices[i]) {
          max = prices[i];
        }

        // 올랐을 때 maxBenefit 계산
        if (prev < prices[i]) {
          if (max - min > maxBenefit) {
            maxBenefit = (max - min);
          }
        }
      }
      prev = prices[i];
    }
    return maxBenefit;
  }
}
