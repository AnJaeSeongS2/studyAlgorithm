package com.sonan.baekjoon.n16953;

import java.util.Scanner;

/**
 * DONE
 * https://www.acmicpc.net/problem/16953
 *
 * 문제
 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
 *
 * 2를 곱한다.
 * 1을 수의 가장 오른쪽에 추가한다.
 * A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
 *
 * 입력
 * 첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
 *
 * 출력
 * A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
 *
 * Created by Jaeseong on 2021/03/18
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        while (true) {
            int a = 0;
            int b = 0;
            if (sc.hasNext()) {
                a = sc.nextInt();
            }
            if (sc.hasNext()) {
                b = sc.nextInt();
            }
            int count = 1;

            while (true) {
                if (a == b) {
                    System.out.println(count);
                    break;
                } else if (a > b) {
                    // 연산 가능성이 없다.
                    System.out.println(-1);
                    break;
                }

                if ((1 & b) == 1) {
                    // 1 케이스. *10 + 1 가능성 있음.
                    count++;
                    int prevB = b;
                    b = (b-1)/10;
                    if (prevB != b*10 + 1) {
                        // *10 +1 이 아닌 케이스
                        System.out.println(-1);
                        break;
                    }
                } else {
                    // 0 인 케이스. *2 가능성 있음.
                    count++;
                    b = b >> 1;
                }
            }
        }
    }
}
