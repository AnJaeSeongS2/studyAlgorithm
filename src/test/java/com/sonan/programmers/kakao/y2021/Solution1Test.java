package com.sonan.programmers.kakao.y2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2020/09/12
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Solution1Test {

    @Test
    void solution() {
        //"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
//        "z-+.^."	"z--"
//        예3	"=.="	"aaa"
//        예4	"123_.def"	"123_.def"
//        예5	"abcdefghijklmn.p"	"abcdefghijklmn"
        assertEquals("bat.y.abcdefghi", new Solution1().solution("...!@BaT#*..y.abcdefghijklm"));
        assertEquals("z--", new Solution1().solution("z-+.^."));
        assertEquals("aaa", new Solution1().solution("=.="));
        assertEquals("123_.def", new Solution1().solution("123_.def"));
        assertEquals("abcdefghijklmn", new Solution1().solution("abcdefghijklmn.p"));
    }
}