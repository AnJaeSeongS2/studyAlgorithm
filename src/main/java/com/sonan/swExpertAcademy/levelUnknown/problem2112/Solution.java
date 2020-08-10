package com.sonan.swExpertAcademy.levelUnknown.problem2112;

import java.util.Scanner;

class Solution {
    public static int D;
    public static int W;
    public static int K;
    public static int currentMin;
    public static int [][] base;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0 ; t < T ; t++) {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            currentMin = Integer.MAX_VALUE;
            base = new int[D][W];
            for (int i = 0 ; i < D ; i++) {
                for (int j = 0 ; j < W ; j++) {
                    base[i][j] = sc.nextInt();
                }
            }
            Boolean[] K_map = new Boolean[D];

            int min = min_change_count(K_map, 0);
            sb.append("#").append(t+1).append(' ').append(min);
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }

    public static int min_change_count(Boolean[] K_map, int searching_index) {
        if (count_not_null_K_map(K_map) >= currentMin) {
            return currentMin;
        }
        if (is_ok_base(K_map)) {
            int min = count_not_null_K_map(K_map);
            if (min < currentMin) {
                currentMin = min;
            }
            return min;
        }

        if (searching_index == K_map.length) {
            return currentMin;
        }

        Boolean[] null_K_map = K_map.clone();
        Boolean[] true_K_map = K_map.clone();
        Boolean[] false_K_map = K_map.clone();

        null_K_map[searching_index] = null;
        true_K_map[searching_index] = true;
        false_K_map[searching_index] = false;

        return Math.min(Math.min(min_change_count(null_K_map, searching_index + 1), min_change_count(true_K_map, searching_index + 1)), min_change_count(false_K_map, searching_index + 1));
    }

    public static boolean is_ok_base(Boolean[] K_map) {
        for (int i = 0 ; i < W ; i++) {
            int count_same = 0;
            int prev_base = 0;
            for (int j = 0 ; j < D ; j++) {
                if (j == 0) {
                    if (K_map[j] == null) {
                        prev_base = base[j][i];
                    } else {
                        prev_base = K_map[j] ? 1 : 0;
                    }
                }

                if (K_map[j] == null) {
                    if (prev_base == base[j][i]) {
                        count_same++;
                    } else {
                        count_same = 1;
                    }
                    prev_base = base[j][i];
                } else {
                    if (prev_base ==  (K_map[j] ? 1 : 0)) {
                        count_same++;
                    } else {
                        count_same = 1;
                    }
                    prev_base = K_map[j] ? 1 : 0;
                }

                if (count_same >= K) {
                    break;
                }
            }
            if (count_same < K) {
                return false;
            }
        }
        return true;
    }

    public static int count_not_null_K_map(Boolean[] K_map) {
        int i = 0;
        for ( int j = 0 ; j < K_map.length; j++) {
            if (K_map[j] != null) {
                i++;
            }
        }
        return i;
    }
}