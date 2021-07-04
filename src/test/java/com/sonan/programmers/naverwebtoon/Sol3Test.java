package com.sonan.programmers.naverwebtoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/07/04
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Sol3Test {

    @Test
    void solution() {
        assertEquals(5, new Sol3().solution("aaaaabbbbb", "ab"));
        assertEquals(2, new Sol3().solution("aabcbcd", "abc"));
        assertEquals(3, new Sol3().solution("abcdababcdabcdefghijefghijabcdefghijaaaa", "abcdefghij"));
        assertEquals(5, new Sol3().solution("aaabcdbabcdcdabcdbcd", "abcd"));
        assertEquals(3, new Sol3().solution("aaabcdbabcdcdabcdbcd", "abc"));
    }
}