package com.sonan.programmers.practice.hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @Calculated_Big_O:
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-15
 * @since: 1.8
 */
class BestAlbumTest {

  @Test
  void solution() {
    assertArrayEquals(new int[]{4,1,3,0}, new BestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    assertArrayEquals(new int[]{4,1,0,2}, new BestAlbum().solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 500, 500, 2500}));
  }
}