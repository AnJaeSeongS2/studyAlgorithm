package com.sonan.programmers.monthlyTest.month9;

/**
 * 문제 설명
 * 정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * examples.png
 * 역방향 달팽이
 *
 * 제한사항
 * n은 1 이상 1,000 이하입니다.
 * 입출력 예
 * n	result
 * 4	[1,2,9,3,10,8,4,5,6,7]
 * 5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
 * 6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제 예시와 같습니다.
 * 입출력 예 #2
 *
 * 문제 예시와 같습니다.
 * 입출력 예 #3
 *
 * 문제 예시와 같습니다.
 *
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-09-10
 * @since: 1.8
 */
public class Solution2 {

  public int[] solution(int n) {
    int[][] model = new int[n][n];
    int finalValue = 0;
    for (int i = 1; i <= n; i++) {
      finalValue += i;
    }

    int curX = 0;
    int curY = 0;
    model[0][0] = 1; // first value;

    int curDirection = 0; // 0: leftdown, 1: right, 2: leftup

    for (int i = 2; i <= finalValue; i++) {
      if (curDirection == 0) {
        if (curX +1 == n || model[curX+1][curY] != 0) {
          i--;
          curDirection = (curDirection+1)%3;
          continue;
        }
        curX = curX +1;
      } else if (curDirection == 1) {
        if (curY +1 == n || model[curX][curY+1] != 0) {
          i--;
          curDirection = (curDirection+1)%3;
          continue;
        }
        curY = curY +1;
      } else {
        if (model[curX-1][curY-1] != 0) {
          i--;
          curDirection = (curDirection+1)%3;
          continue;
        }
        curX = curX - 1;
        curY = curY - 1;
      }
      model[curX][curY] = i;
    }

    // out of arrayindex -> (direction + 1)%3
    // next value != 0 -> (direction +1) %3




    // result init.
    int[] answer = new int[finalValue];
    int curIndex = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (model[i][j] != 0) {
          answer[curIndex] = model[i][j];
          curIndex++;
        }
      }
    }

    return answer;
  }
}
