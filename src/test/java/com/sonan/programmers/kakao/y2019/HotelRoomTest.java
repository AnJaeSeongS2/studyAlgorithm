package com.sonan.programmers.kakao.y2019;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/18
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class HotelRoomTest {

    @Test
    void solution() {
        assertArrayEquals(new long[]{1,3,4,2,5,6}, new HotelRoom().solution(10, new long[]{1,3,4,1,3,1}));
    }
}
