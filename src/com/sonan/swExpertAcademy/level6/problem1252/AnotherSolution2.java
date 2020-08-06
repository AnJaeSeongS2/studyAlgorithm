package com.sonan.swExpertAcademy.level6.problem1252;

import java.util.Scanner;

//copyed. for study from 'siotman'

public class AnotherSolution2 {
    // GLOBAL DEF.
    public static Scanner sc = new Scanner(System.in);

    public static int tno;
    public static int S, N, ansCnt;
    public static int[][] map, answer;

    public static int[] cost = {0, 2, 4, 7};
    public static int[] cover = {0, 1, 4, 9};

    // PROCESS
    private static void process() {
        int gridSize;

        gridSize = 3;
        do {
            for (int expectedDamage = cover[gridSize]; expectedDamage > cover[gridSize - 1]; expectedDamage--) {
                for (int r = 0; r < S - gridSize + 1; r++) {
                    for (int c = 0; c < S - gridSize + 1; c++) {
                        int damaged = countDamage(r, c, gridSize);

                        if (expectedDamage == damaged) {
                            coverMap(r, c, gridSize);
                            addResult(r, c, gridSize);
                        }
                    }
                }
            }
        } while (--gridSize > 0);
    }

    private static void addResult(int r, int c, int gridSize) {
        answer[ansCnt][0] = r + 1;
        answer[ansCnt][1] = c + 1;
        answer[ansCnt][2] = gridSize;
        ansCnt += 1;
    }

    private static void coverMap(int r, int c, int gridSize) {
        for (int rv = 0; rv < gridSize; rv++) {
            for (int cv = 0; cv < gridSize; cv++) {
                map[r + rv][c + cv] = 0;
            }
        }
    }

    private static int countDamage(int r, int c, int gridSize) {
        int cnt = 0;
        for (int rv = 0; rv < gridSize; rv++) {
            for (int cv = 0; cv < gridSize; cv++) {
                cnt += map[r + rv][c + cv];
            }
        }
        return cnt;
    }


    // INPUT
    private static void initInput() {
        S = sc.nextInt(); N = sc.nextInt();

        map = new int[S][S];
        for (int i = 0; i < N; i++) {
            map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        }
        ansCnt = 0;
        answer = new int[10000][3];
    }


    // PRINT
    private static void printResult() {
        System.out.printf("#%d %d ", tno, ansCnt);

        for (int ans = 0; ans < ansCnt; ans++) {
            System.out.printf("%d %d %d ", answer[ans][0], answer[ans][1], answer[ans][2]);
        }
        System.out.println();
    }

    // RUN TEST_CASE
    public static void test() {
        int T = sc.nextInt();
        for (tno = 1; tno <= T; tno++) {
            initInput();
            process();
            printResult();
        }

        if(sc != null) sc.close();
    }

        
    public static void main(String[] args) {
        test();
    }
}
