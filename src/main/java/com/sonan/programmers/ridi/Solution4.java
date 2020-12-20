package com.sonan.programmers.ridi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 문제 설명
 * 임의의 숫자가 적힌 N개의 카드가 있습니다. 이 카드들을 이용하여 증가 구간을 가장 많이 만드는 것이 목적입니다. 증가 구간이란 카드를 배치했을 때 k-1번째 카드보다 k번째 카드가 더 큰 경우를 말하고, 1개의 증가구간으로 개수를 셉니다. 만약, 카드 목록 P = [3,2,1,4,5] 로 주어질때 [1,2,3,4,5] 로 배치하게되면, 증가구간은 2개(1->4, 4->5)에서 4개(1->2,2->3,3->4,4->5)로 늘어나게 됩니다. 카드 목록 P가 주어질 때, 적당히 배치를 한 뒤, 증가구간의 최댓값을 반환하는 함수를 완성해 주세요.
 *
 * 제한사항
 * 카드의 개수 N : 100,000 이하의 자연수
 * 카드의 숫자 크기 : 1,000,000 이하의 자연수
 * 입출력 예
 * P	answer
 * [3,2,1,4,5]	4
 * [20,10,10,20]	2
 * [103,101,103,103,101,102,100,100,101,104]	7
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제의 예시와 같습니다.
 *
 * 입출력 예 #2
 * [10,20,10,20] 로 배치하게되면 증가구간은 10->20,10->20로 최대 2개가 됩니다.
 *
 * 입출력 예 #3
 * [101,103,100,101,102,103,100,101,103,104] 로 배치하게되면 증가구간은 101->103, 100->101, 101->102, 102->103, 100->101, 101->103, 103->104로 최대 7개가 됩니다.
 *
 * @Calculated_Big_O: NLogN
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-12-20
 * @since: 1.8
 */
public class Solution4 {
  public int solution(int[] p) {
    // card number / count
    Map<Integer, Integer> cardCounts = new HashMap<>();
    Set<Integer> cardKeys = new TreeSet<>();

    for (int entry: p) {
      Integer cardKey = Integer.valueOf(entry);
      cardKeys.add(cardKey);

      Integer count = cardCounts.get(cardKey);
      if (count == null) {
        cardCounts.put(cardKey, 1);
      } else {
        cardCounts.put(cardKey, ++count);
      }
    }

    Integer prevCount = -1;
    Integer answer = 0;
    for (Integer cardKey: cardKeys) {
      if (prevCount == -1) {
        prevCount = cardCounts.get(cardKey);
      } else {
        answer += Math.min(cardCounts.get(cardKey), prevCount);
        prevCount = Math.max(cardCounts.get(cardKey), prevCount);
      }
    }
    return answer;
  }
}