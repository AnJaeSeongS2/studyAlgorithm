package com.sonan.swExpertAcademy.level6.problem1252;

import java.util.Scanner;

public class AnotherSolution {
    static int S, N, metalArea[][];
    static int coverArea[][];
    static int num;
    private static void findCoverWeakMetalCaseAndFill(int caseNm) {
        int totCoverMetalAreaCnt = caseNm * caseNm;
        int totCheckMinCoverMetalAreaCnt = caseNm == 3 ? 5 : ( caseNm == 2 ? 2 : 1);
        if(caseNm>1) {
            for (int k = totCoverMetalAreaCnt; k >= totCheckMinCoverMetalAreaCnt; k--) {
                for (int i = 1; i <= S; i++) {
                    for (int j = 1; j <= S; j++) {
                        int cnt = checkWeakMetalCnt(i, j, caseNm);
                        if (cnt == k) {
                            coverArea[num][0] = i;
                            coverArea[num][1] = j;
                            coverArea[num++][2] = caseNm;
                            fillArea(i, j, caseNm);
                        }
                    }
                }
            }
        }else {
            for (int i = 1; i <= S; i++) {
                for (int j = 1; j <= S; j++) {
                    if (metalArea[i][j] == 1) {
                        coverArea[num][0] = i;
                        coverArea[num][1] = j;
                        coverArea[num++][2] = 1;
                    }
                }
            }
        }
    }
    private static void coverWeakMetalArea() {
        findCoverWeakMetalCaseAndFill(3);
        findCoverWeakMetalCaseAndFill(2);
        findCoverWeakMetalCaseAndFill(1);
    }

    private static int checkWeakMetalCnt(int x, int y, int len) {
        int cnt = 0;
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (i <= S && j <= S) {
                    if (metalArea[i][j] == 1) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static void fillArea(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (i <= S && j <= S) {
                    metalArea[i][j] = 0;
                }
            }
        }
    }

    private static void printResult(int testNm){
        System.out.print("#" + testNm + " "+ num+" ");
        for(int i = 0; i< num; i++){
            System.out.print(coverArea[i][0] + " " +coverArea[i][1] +" "+ coverArea[i][2]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int testNm = 1; testNm <= testcase; testNm++) {
            S = sc.nextInt();
            N = sc.nextInt();
            metalArea = new int[S+1][S+1];
            coverArea = new int[S * S][3];
            for (int i = 1; i <= N; i++) {
                int tempY = sc.nextInt();
                int tempX = sc.nextInt();
                metalArea[tempY][tempX] = 1;
            }
            num = 0;
            coverWeakMetalArea();
            printResult(testNm);
        }
        sc.close();
    }
}