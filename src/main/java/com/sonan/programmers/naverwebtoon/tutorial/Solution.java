package com.sonan.programmers.naverwebtoon.tutorial;

import java.math.BigInteger;

/**
 * 문제 설명
 * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
 *
 * 제한사항
 * v는 세 점의 좌표가 들어있는 2차원 배열입니다.
 * v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
 * 좌표값은 1 이상 10억 이하의 자연수입니다.
 * 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
 * 입출력 예
 * v	result
 * [[1, 4], [3, 4], [3, 10]]	[1, 10]
 * [[1, 1], [2, 2], [1, 2]]	[2, 1]
 *
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 세 점이 [1, 4], [3, 4], [3, 10] 위치에 있을 때, [1, 10]에 점이 위치하면 직사각형이 됩니다.
 *
 * 입출력 예 #2
 * 세 점이 [1, 1], [2, 2], [1, 2] 위치에 있을 때, [2, 1]에 점이 위치하면 직사각형이 됩니다.
 *
 *
 *   *
 *        *
 * *
 *      *
 * ********************
 * 직사경의 특징: 마지막 점을 놓을 위치는 가장 긴 변 쪽으로 확장해야한다.
 *
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2021-07-01
 * @since: 1.8
 */
public class Solution {
  public int[] solution(int[][] v) {
    int[] ans;
    BigInteger[] diffVertex = {
        BigInteger.valueOf(v[0][0] - v[1][0]).pow(2).add(BigInteger.valueOf(v[0][1] - v[1][1]).pow(2)),
        BigInteger.valueOf(v[0][0] - v[2][0]).pow(2).add(BigInteger.valueOf(v[0][1] - v[2][1]).pow(2)),
        BigInteger.valueOf(v[1][0] - v[2][0]).pow(2).add(BigInteger.valueOf(v[1][1] - v[2][1]).pow(2))
    };
    // 0변 : 0~1점 사이
    // 1변 : 0~2점 사이
    // 2변 : 1~2점 사이

    if (diffVertex[0].compareTo(diffVertex[1]) >= 0 && diffVertex[0].compareTo(diffVertex[2]) >= 0) {
      // 0 변이 가장 김
      // 2점에서 이동
      ans = new int[]{v[0][0] + v[1][0] - v[2][0], v[0][1] + v[1][1] - v[2][1]};
    } else if (diffVertex[1].compareTo(diffVertex[0]) >= 0 && diffVertex[1].compareTo(diffVertex[2]) >= 0) {
      // 1 변이 가장 김
      // 1점에서 이동
      ans = new int[]{v[0][0] + v[2][0] - v[1][0], v[0][1] + v[2][1] - v[1][1]};
    } else {
      // 2 변이 가장 김
      ans = new int[]{v[1][0] + v[2][0] - v[0][0], v[1][1] + v[2][1] - v[0][1]};
    }
    return ans;
  }
}
