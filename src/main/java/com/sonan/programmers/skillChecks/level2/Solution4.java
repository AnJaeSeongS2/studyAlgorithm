package com.sonan.programmers.skillChecks.level2;

import java.util.HashSet;
import java.util.Objects;

/**
 * [1차] 프렌즈4블록
 *
 * 문제 설명
 * 프렌즈4블록
 * 블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 프렌즈4블록.
 * 같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.
 *
 * board map
 * 만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다. 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.
 *
 * board map
 *
 * 블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.
 *
 * board map
 *
 * 만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.
 * board map
 *
 * 위 초기 배치를 문자로 표시하면 아래와 같다.
 *
 * TTTANT
 * RRFACC
 * RRRFCC
 * TRRRAA
 * TTMMMF
 * TMMTTJ
 * 각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다
 *
 * 입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.
 *
 * 입력 형식
 * 입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
 * 2 ≦ n, m ≦ 30
 * board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.
 * 출력 형식
 * 입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.
 *
 * 입출력 예제
 * m	n	board	answer
 * 4	5	[CCBDE, AAADE, AAABF, CCBBF]	14
 * 6	6	[TTTANT, RRFACC, RRRFCC, TRRRAA, TTMMMF, TMMTTJ]	15
 * 예제에 대한 설명
 * 입출력 예제 1의 경우, 첫 번째에는 A 블록 6개가 지워지고, 두 번째에는 B 블록 4개와 C 블록 4개가 지워져, 모두 14개의 블록이 지워진다.
 * 입출력 예제 2는 본문 설명에 있는 그림을 옮긴 것이다. 11개와 4개의 블록이 차례로 지워지며, 모두 15개의 블록이 지워진다.
 *
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-16
 * @since: 1.8
 */
public class Solution4 {
  private static final char REMOVED = 'n';
  private static char[][] removeTarget;
  public int solution(int m, int n, String[] board) {
    int removeCount = 0;

    HashSet<Entry> removeTarget = new HashSet();

    // init char[][]
    char[][] convertedBoard = new char[m][];
    for (int i = 0; i < convertedBoard.length ; i++) {
      convertedBoard[i] = board[i].toCharArray();
    }


    while (true) {
      printConsole(convertedBoard);
      for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
          if (isRemovableCurrent(i, j, convertedBoard)) {
            removeTarget.add(new Entry(i, j));
            removeTarget.add(new Entry(i, j + 1));
            removeTarget.add(new Entry(i + 1, j));
            removeTarget.add(new Entry(i + 1, j + 1));
          }
        }
      }
      if (removeTarget.size() == 0) {
        return removeCount;
      }
      removeCount += removeTarget.size();
      reinit(convertedBoard, removeTarget, m, n);
      removeTarget = new HashSet();
    }
  }

  private boolean isRemovableCurrent(int i, int j, char[][] board) {
    char base = board[i][j];
    return base != REMOVED && base == board[i][j+1] && base == board[i+1][j] && base == board[i+1][j+1];
  }

  private void reinit(char[][] beforeBoard, HashSet<Entry> removeTarget, int m, int n) {
    for (Entry entry: removeTarget) {
      beforeBoard[entry.getM()][entry.getN()] = REMOVED;
    }
    for (int j = 0 ; j < n ; j++) {
      int removedCountOnColumn = 0;
      for (int i = m-1; i >= 0; i--) {
        if (beforeBoard[i][j] == REMOVED) {
          removedCountOnColumn++;
        } else {
          beforeBoard[i + removedCountOnColumn][j] = beforeBoard[i][j];
        }
      }
      for (int i = 0; i < removedCountOnColumn ; i++) {
        beforeBoard[i][j] = REMOVED;
      }
    }
  }

  private void printConsole(char[][] board) {
    System.out.println("printConsole Board");
    for (int i = 0; i < board.length; i++) {
      System.out.println(board[i]);
    }

  }

  class Entry {
    private int m;
    private int n;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Entry entry = (Entry) o;
      return m == entry.m &&
          n == entry.n;
    }

    @Override
    public int hashCode() {
      return Objects.hash(m, n);
    }

    public int getM() {
      return m;
    }

    public void setM(int m) {
      this.m = m;
    }

    public int getN() {
      return n;
    }

    public void setN(int n) {
      this.n = n;
    }

    public Entry(int m, int n) {
      this.m = m;
      this.n = n;
    }
  }
}

