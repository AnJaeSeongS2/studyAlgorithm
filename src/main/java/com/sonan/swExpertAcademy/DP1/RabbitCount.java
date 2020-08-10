package com.sonan.swExpertAcademy.DP1;

import java.util.Scanner;


// 피보나치였네.
public class RabbitCount {
    // N 주 까지 계산
    private static long [][] count = new long[3][];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        count[0] = new long[N];
        count[1] = new long[N];
        count[2] = new long[N];

        count[0][0] = 2;

        System.out.println(sb.append("#").append(0).append(" : ").append(count[0][0] + count[1][0] + count[2][0]).toString());
        sb.setLength(0);
        for (int i = 1 ; i < N ; i++) {
            count[0][i] = count[1][i-1] + count[2][i-1];
            count[1][i] = count[0][i-1];
            count[2][i] = count[1][i-1] + count[2][i-1];
            System.out.println(sb.append("#").append(i).append(" : ").append(count[0][i] + count[1][i] + count[2][i]).toString());
            sb.setLength(0);
        }

    }
}
