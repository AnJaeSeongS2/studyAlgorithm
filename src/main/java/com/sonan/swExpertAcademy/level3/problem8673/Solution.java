package com.sonan.swExpertAcademy.level3.problem8673;

import java.util.Scanner;

class Solution {

    public static int diff = 0;
    public static int[] a_array;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0 ; t < T ; t++) {
            int K_pow_from_2 = (int) Math.pow(2, sc.nextInt());
            a_array = new int[K_pow_from_2];
            for (int i = 0 ; i < K_pow_from_2 ; i++) {
                a_array[i] = sc.nextInt();
            }
            max(0, a_array.length -1 );
            sb.append("#").append(t+1).append(' ').append(diff);
            System.out.println(sb.toString());
            sb.setLength(0);
            diff = 0;
        }
    }

    public static int max(int start, int end) {
        if (start + 1 == end)  {
            if (a_array[start] > a_array[end]) {
                diff += (a_array[start] - a_array[end]);
                return a_array[start];
            }
            diff += (a_array[end] - a_array[start]);
            return a_array[end];
        }

        int left_max = max(start, (start + end)/2);
        int right_max = max((start + end)/2 + 1, end);
        if (left_max > right_max) {
            diff += (left_max - right_max);
            return left_max;
        }
        diff += (right_max - left_max);
        return right_max;
    }
}
