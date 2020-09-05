package com.sonan.programmers.kakao.y2020;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2020/09/05
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class LyricFinderTest {

    @Test
    void solution() {
        // ["frodo", "front", "frost", "frozen", "frame", "kakao"]	["fro??", "????o", "fr???", "fro???", "pro?"]	[3, 2, 4, 1, 0]
        assertArrayEquals(new int[]{3, 2, 4, 1, 0}, new LyricFinder().solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}));
    }
}