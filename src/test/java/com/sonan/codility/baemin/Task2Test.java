package com.sonan.codility.baemin;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Task2Test {

    @Test
    void solution() {
        assertEquals("music 1011b\n" +
                "images 0b\n" +
                "movies 10200b\n" +
                "other 105b", new Task2().solution("my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b"));
        assertEquals("music 1022b\n" +
                "images 0b\n" +
                "movies 10200b\n" +
                "other 105b", new Task2().solution("asdfASDF09^&'@{}[],$=!-#()%.+~_...mp3 11b\n" + "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b"));
    }

    @Test
    void genDefaultInitializedTypeMap() {
    }

    @Test
    void genResultStr() {

    }

    @Test
    void parseOneLine() {
        assertEquals(new AbstractMap.SimpleEntry<FILE_TYPE, Integer>(FILE_TYPE.music, 11), new Task2().parseOneLine("my.song.mp3 11b"));
    }
}
