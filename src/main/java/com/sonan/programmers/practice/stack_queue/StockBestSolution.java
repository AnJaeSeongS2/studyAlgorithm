package com.sonan.programmers.practice.stack_queue;

import java.util.Stack;

/**
 * @Calculated_Big_O: N
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-14
 * @since: 1.8
 */
public class StockBestSolution {

  public int[] solution(int[] prices) {
    Stack<Integer[]> stack = new Stack<>();
    int[] ret = new int[prices.length];

    for (int i = prices.length - 2; i >= 0; i--) {
      int day = 0;

      while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
        day += stack.pop()[1];
      }

      ret[i] = stack.push(new Integer[]{prices[i], day + 1})[1];
    }

    return ret;
  }
}
