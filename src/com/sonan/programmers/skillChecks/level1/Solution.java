package com.sonan.programmers.skillChecks.level1;

import java.util.Scanner;

/**
 * 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
 * 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
 * 제한 조건
 * n과 m은 각각 1000 이하인 자연수입니다.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-08-06
 * @since: 1.8
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    StringBuffer sb = new StringBuffer();
    for (int j = 0; j < a; j++) {
      sb.append('*');
    }
    for (int i = 0; i < b - 1; i++) {
      System.out.println(sb.toString());
    }
    System.out.print(sb.toString());
  }
}