package com.sonan.programmers.kakao.y2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2020/09/12
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Solution2Test {
//    orders	course	result
//{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}	{2,3,4}	{"AC", "ACDE", "BCFG", "CDE"}
//        {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}	{2,3,5}	{"ACD", "AD", "ADE", "CD", "XYZ"}
//        {"XYZ", "XWY", "WXA"}	{2,3,4}	{"WX", "XY"}
    @Test
    void solution() {
        assertArrayEquals(new String[]{"AC", "ACDE", "BCFG", "CDE"}, new Solution2().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]	{2,3,4}	));
        assertArrayEquals(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"}, new Solution2().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]	{2,3,5}	));
        assertArrayEquals(new String[]{"WX", "XY"}, new Solution2().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]	{2,3,4}));
    }
}