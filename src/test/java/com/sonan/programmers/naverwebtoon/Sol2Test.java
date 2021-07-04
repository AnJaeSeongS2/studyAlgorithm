package com.sonan.programmers.naverwebtoon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/07/04
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Sol2Test {

    @Test
    void solution() {
        assertArrayEquals(new String[]{"abc","xy","asdf","asdf","xy","abc"}, new Sol2().solution("abcxyasdfasdfxyabc"));
        assertArrayEquals(new String[]{"abc","xy","qwerty","xy","abc"}, new Sol2().solution("abcxyqwertyxyabc"));
        assertArrayEquals(new String[]{"abc","abc","abc","abc"}, new Sol2().solution("abcabcabcabc"));
        assertArrayEquals(new String[]{"l","l","t","t","a","a","t","t","l","l"}, new Sol2().solution("llttaattll"));
        assertArrayEquals(new String[]{"z","z","z","z","z","z"}, new Sol2().solution("zzzzzz"));
        assertArrayEquals(new String[]{"abcdef"}, new Sol2().solution("abcdef"));
    }
}