package com.sonan.swExpertAcademy.level4.problem8659;

import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        long[] base = new long[91];
        base[0] = 1;
        base[1] = 2;
        for (int j = 2; j < 91; j++) {
            base[j] = base[j-1] + base[j-2];
        }

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int k = sc.nextInt();
            sb.append('#').append(t+1).append(' ').append(base[k]).append(' ').append(base[k-1]);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}