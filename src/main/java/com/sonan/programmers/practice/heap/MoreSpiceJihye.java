package com.sonan.programmers.practice.heap;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-16
 * @since: 1.8
 */
public class MoreSpiceJihye {
  public int solution(int[] scoville, int K) {

    int answer = 0;


    PriorityQueue<Long> pQueue = new PriorityQueue<Long>(new Comparator<Long>() {
      public int compare(Long w1, Long w2) {
        return w1.compareTo(w2); //descendant order
      }
    });


    for(int item : scoville) {
      pQueue.add((long) item);
    }

    while(pQueue.peek()<K && pQueue.size()>1) {
      Long a = pQueue.poll();
      Long b = pQueue.poll();

      pQueue.add(a+(b*2));

      answer++;

    }



    if(pQueue.size()<2 && pQueue.peek()<K)
      answer = -1;

    return answer;
  }
}
