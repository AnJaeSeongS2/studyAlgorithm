package com.sonan.programmers.kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 문제 설명
 * 카카오 프렌즈 컬러링북
 * 출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)
 *
 * 그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.
 *
 * alt text
 *
 * 위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.
 *
 * 입력 형식
 * 입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.
 *
 * 1 <= m, n <= 100
 * picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
 * picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
 * 출력 형식
 * 리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.
 *
 * 예제 입출력
 * m	n	picture	answer
 * 6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
 * 예제에 대한 설명
 * 예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.
 *
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-17
 * @since: 1.8
 */
public class ColoringBook {

  public int[] solution(int m, int n, int[][] picture) {

    int[][] splitedArea = new int[m][];
    for (int i = 0 ; i < m; i++) {
      splitedArea[i] = new int[n];
    }

    SplitedCount count = new SplitedCount(0);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (splitedArea[i][j] != 0) {
          continue;
        } else {
          if (picture[i][j] != 0) {
            checkCurrent(count, i, j, m, n, picture, splitedArea);
          }
        }
      }
    }

    HashMap<Integer, Integer> maxSize = new HashMap();
    for (int i = 1; i < count.getCount(); i++) {
      for (int j = 0; j < m; j++) {
        for (int k = 0; k < n; k++) {
          if (splitedArea[j][k] == i) {
            if (maxSize.containsKey(Integer.valueOf(i))) {
              maxSize.put(i, maxSize.get(Integer.valueOf(i)) + 1);
            } else {
              maxSize.put(i, 1);
            }
          }
        }
      }
    }

    ArrayList<Integer> maxSize2 = new ArrayList();
    for (Integer value: maxSize.values()) {
      maxSize2.add(value);
    }
    Collections.sort(maxSize2, Comparator.reverseOrder());

    int numberOfArea = count.getCount();
    int maxSizeOfOneArea = maxSize2.size() == 0 ? 0 : maxSize2.get(0);

    int[] answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }

  private void checkCurrent(SplitedCount count, int i, int j, int m, int n, int[][] picture, int[][] splitedArea) {
    if (picture[i][j] == 0) {
      return;
    }
    if (splitedArea[i][j] != 0) {
      return;
    }


    // 현재 가져오기
    int curColor = picture[i][j];
    if (j -1 >=0 && curColor == picture[i][j-1] && splitedArea[i][j-1] != 0) {
      splitedArea[i][j] = splitedArea[i][j-1];
    } else if (i -1 >= 0 && curColor == picture[i-1][j] && splitedArea[i-1][j] != 0) {
      splitedArea[i][j] = splitedArea[i-1][j];
    } else if (j + 1 < n && curColor == picture[i][j+1] && splitedArea[i][j+1] != 0) {
      splitedArea[i][j] = splitedArea[i][j+1];
    } else if (i + 1 < m && curColor == picture[i+1][j] && splitedArea[i+1][j] != 0) {
      splitedArea[i][j] = splitedArea[i+1][j];
    } else {
      count.setCount(count.getCount() + 1);
      splitedArea[i][j] = count.getCount();
    }

    // 외부로 가져가기
    if (j -1 >=0 && curColor == picture[i][j-1]) {
      checkCurrent(count, i, j-1, m, n, picture, splitedArea);
    }
    if (i -1 >= 0 && curColor == picture[i-1][j]) {
      checkCurrent(count, i-1, j, m, n, picture, splitedArea);
    }
    if (j + 1 < n && curColor == picture[i][j+1]) {
      checkCurrent(count, i, j+1, m, n, picture, splitedArea);
    }
    if (i + 1 < m && curColor == picture[i+1][j]) {
      checkCurrent(count, i+1, j, m, n, picture, splitedArea);
    }
  }

  class SplitedCount {
    private Integer count;

    public Integer getCount() {
      return count;
    }

    public void setCount(Integer count) {
      this.count = count;
    }

    public SplitedCount(Integer count) {
      this.count = count;
    }
  }
}
