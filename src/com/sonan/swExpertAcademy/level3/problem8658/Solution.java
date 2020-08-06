package com.sonan.swExpertAcademy.level3.problem8658;

import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < T ; i++) {
            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0 ; j < 10 ; j++) {
                int cur = sc.nextInt();
                int sum = 0;
                while (cur / 10 != 0) {
                    sum += cur % 10;
                    cur = cur / 10;
                }
                sum += cur % 10;
                cur = cur / 10;

                if (sum < min) {
                    min = sum;
                }
                if (sum > max) {
                    max = sum;
                }
            }
            sb.append("#").append(i+1).append(" ").append(max).append(" ").append(min);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
