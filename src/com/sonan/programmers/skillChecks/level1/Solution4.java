package com.sonan.programmers.skillChecks.level1;

import java.util.Arrays;

/**
 * Created by Jaeseong on 2020/08/08
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Solution4 {
    public String solution(String s) {
        int[] charCount = new int[128];
        char[] chars = s.toCharArray();
        for (char entry: chars) {
            charCount[entry]++;
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = charCount.length - 1; i > -1; i--) {
            char[] input = new char[charCount[i]];
            Arrays.fill(input, (char)i);
            resultBuilder.append(input);
        }
        return resultBuilder.toString();
    }
}