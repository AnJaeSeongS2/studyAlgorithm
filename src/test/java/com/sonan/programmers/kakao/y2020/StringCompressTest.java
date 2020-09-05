package com.sonan.programmers.kakao.y2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2020/09/05
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class StringCompressTest {

    @Test
    void solution() {
        System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(0^1);
        System.out.println(0^0);
        assertEquals(17, new StringCompress().solution("xababcdcdababcdcd"));
        assertEquals(7, new StringCompress().solution("aabbaccc"));
        assertEquals(9, new StringCompress().solution("ababcdcdababcdcd"));
        assertEquals(8, new StringCompress().solution("abcabcdede"));
        assertEquals(14, new StringCompress().solution("abcabcabcabcdededededede"));
    }
}