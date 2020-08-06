package com.sonan.programmers.skillChecks.level1;

import java.util.LinkedList;
import java.util.List;

/**
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 *
 *
 * 1,2,3,4,5 ->
 * 1 3 4 5 짝수 반복 홀수 2 고정
 * 33 11 22 44 55 ->
 *
 * int count1 ++
 * int count2
 * int count3
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-08-06
 * @since: 1.8
 */
public class Solution2 {

  private int[] memberPeek1 = {1,2,3,4,5};
  private int[] memberPeek2 = {1,3,4,5};
  private int[] memberPeek3 = {3,3,1,1,2,2,4,4,5,5};
  public int[] solution(int[] answers) {
    int[] count = new int[3];
    List<Integer> answer = new LinkedList<>();

    for (int i = 0; i < answers.length; i++) {
      if (isCorrectMember1(i, answers[i]))
        count[0]++;
      if (isCorrectMember2(i, answers[i]))
        count[1]++;
      if (isCorrectMember3(i, answers[i]))
        count[2]++;
    }
    int max = Math.max(count[0], count[1]);
    max = Math.max(max, count[2]);

    for (int i = 0 ;i < 3; i++) {
      if (max == count[i]) {
        answer.add(i + 1);
      }
    }

    int[] result = new int[answer.size()];
    int index = 0;
    for (Integer member : answer) {
      result[index] = member;
      index++;
    }
    return result;
  }

  private boolean isCorrectMember1(int index, int answer) {
    return memberPeek1[index % 5] == answer;
  }

  private boolean isCorrectMember2(int index, int answer) {
    return index % 2 == 0 ? (answer == 2) : (memberPeek2[(index / 2) % 4] == answer);
  }

  private boolean isCorrectMember3(int index, int answer) {
    return memberPeek3[index % 10] == answer;
  }
}
