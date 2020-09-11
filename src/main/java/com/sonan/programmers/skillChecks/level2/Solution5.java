package com.sonan.programmers.skillChecks.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

/**
 * 문제 설명
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 * 입출력 예
 * nums	result
 * [1,2,3,4]	1
 * [1,2,7,6,4]	4
 * 입출력 예 설명
 * 입출력 예 #1
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 *
 * 입출력 예 #2
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 * [1,4,6]을 이용해서 11을 만들 수 있습니다.
 * [2,4,7]을 이용해서 13을 만들 수 있습니다.
 * [4,6,7]을 이용해서 17을 만들 수 있습니다.
 *
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-17
 * @since: 1.8
 */
public class Solution5 {
  public int solution(int[] nums) {
    HashSet<Entry> sosu = new HashSet();
    boolean[] isNoSoSu = new boolean[3000];
    for (int i = 2; i < 3000; i++) {
      for (int j = 2*i; j < 3000; j = j + i) {
        isNoSoSu[j] = true;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 0; k < nums.length; k++) {
          if (i == j || j == k || k == i) {
            continue;
          }

          if (!isNoSoSu[nums[i] + nums[j] + nums[k]]) {
            ArrayList<Integer> inner = new ArrayList();
            inner.add(nums[i]);
            inner.add(nums[j]);
            inner.add(nums[k]);
            Collections.sort(inner);
            sosu.add(new Entry(inner.get(0), inner.get(1), inner.get(2)));
          }
        }
      }
    }
    return sosu.size();
  }

  class Entry {
    private int member1;
    private int member2;
    private int member3;

    public Entry(int member1, int member2, int member3) {
      this.member1 = member1;
      this.member2 = member2;
      this.member3 = member3;
    }

    public int getMember1() {
      return member1;
    }

    public void setMember1(int member1) {
      this.member1 = member1;
    }

    public int getMember2() {
      return member2;
    }

    public void setMember2(int member2) {
      this.member2 = member2;
    }

    public int getMember3() {
      return member3;
    }

    public void setMember3(int member3) {
      this.member3 = member3;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Entry entry = (Entry) o;
      return member1 == entry.member1 &&
          member2 == entry.member2 &&
          member3 == entry.member3;
    }

    @Override
    public int hashCode() {
      return Objects.hash(member1, member2, member3);
    }
  }

}
