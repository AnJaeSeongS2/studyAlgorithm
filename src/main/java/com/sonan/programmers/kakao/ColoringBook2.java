package com.sonan.programmers.kakao;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-20
 * @since: 1.8
 */
public class ColoringBook2 {

  static private boolean[][] visited;
  static private int[] dx = {-1, 0, 1, 0};
  static private int[] dy = {0, -1, 0, 1};

  public int[] solution(int m, int n, int[][] picture) {
    visited = new boolean[m][n];
    int[] result = new int[2];

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if (!visited[i][j] && picture[i][j] != 0) {
          result[0]++;
          result[1] = Math.max(result[1], bfsCheckCurrent(i, j, m, n, picture[i][j], picture));
        }
      }
    }
    return result;
  }

  // output: depth
  public int bfsCheckCurrent(int x, int y, int m, int n, int currentColor, int[][] picture) {
    Queue<int[]> queue = new LinkedList<>();
    int[] node = {x, y};
    visited[x][y] = true;
    queue.add(node);
    int depth = 0;
    while(!queue.isEmpty()) {
      int[] curNode = queue.poll();
      depth++;
      for(int i = 0; i < 4; i++) {
        int nx = curNode[0] + dx[i];
        int ny = curNode[1] + dy[i];

        if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && currentColor == picture[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new int[]{nx, ny});
        }
      }
    }
    return depth;
  }
}
