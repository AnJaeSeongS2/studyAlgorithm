package com.sonan.swExpertAcademy.level5.problem4112;

import java.util.Scanner;

class Solution {
    public static int[] line = new int[200];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // left child : + index
        // right child : + index + 1

        for (int i = 1; i < 200; i++) {
            line[i] = line[i-1] + i;
        }

        for (int i = 0 ; i < T ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int a_line = getLine(a);
            int b_line = getLine(b);

            int depth = Math.abs(a_line - b_line);

            if (a_line < b_line) {
                for (int j = 0 ; j < depth ; j++) {
                    // left child move.
                    a += (a_line + j);
                }
                if (a < b) {
                    int rightWidth = b - a;
                    System.out.println(sb.append("#").append(i+1).append(" ").append(Math.max(depth, rightWidth)).toString());
                } else {
                    int leftWidth = a - b;
                    System.out.println(sb.append("#").append(i+1).append(" ").append(depth+ leftWidth).toString());
                }
            } else {
                for (int j = 0 ; j < depth ; j++) {
                    // left child move.
                    b += (b_line + j);
                }
                if (a < b) {
                    int leftWidth = b - a;
                    System.out.println(sb.append("#").append(i+1).append(" ").append(depth + leftWidth).toString());
                } else {
                    int rightWidth = a - b;
                    System.out.println(sb.append("#").append(i+1).append(" ").append(Math.max(depth, rightWidth)).toString());
                }
            }
            sb.setLength(0);

        }

    }

    private static int getLine(int input) {
        for (int i = 1 ; i < 200 ; i++) {
            if (line[i-1] < input && input <= line[i]) {
                return i;
            }
        }
        return 1;
    }
}