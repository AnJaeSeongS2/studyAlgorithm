package com.sonan.codility.baemin;

import java.util.StringJoiner;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Task1 {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public String solution(int U, int L, int[] C) {
        int[][] result = new int[2][C.length];

        int countOfTwoValue = getCountOfTwoValue(C);
        int countOneValueOnUpper = U - countOfTwoValue;
        int countOneValueOnLower = L - countOfTwoValue;
        if (countOneValueOnLower < 0 || countOneValueOnUpper < 0) {
            return IMPOSSIBLE;
        }

        int lastIndexOfOneValueOnUpper = 0;
        // upper
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 2) {
                result[0][i]++;
            } else if (C[i] == 1 && countOneValueOnUpper > 0) {
                result[0][i]++;
                countOneValueOnUpper--;
                lastIndexOfOneValueOnUpper = i;
            }
        }

        // lower
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 2) {
                result[1][i]++;
            } else if (C[i] == 1 && i > lastIndexOfOneValueOnUpper) {
                if (countOneValueOnLower <= 0) {
                    return IMPOSSIBLE;
                }
                result[1][i]++;
                countOneValueOnLower--;
            }
        }

        if (countOneValueOnUpper > 0 || countOneValueOnLower > 0) {
            return IMPOSSIBLE;
        }
        return genResultStr(result);
    }

    private int getCountOfTwoValue(int[] C) {
        int count = 0;
        for (int memberOfC: C) {
            if (memberOfC == 2) {
                count++;
            }
        }
        return count;
    }

    private String genResultStr(int[][] result) {
        StringJoiner resultSJ = new StringJoiner(",");
        for (int i = 0; i < result.length; i++) {
            StringBuilder rowSB = new StringBuilder();
            for (int memberResult : result[i]) {
                rowSB.append(memberResult);
            }
            resultSJ.add(rowSB.toString());
        }
        return resultSJ.toString();
    }
}
