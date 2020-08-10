package com.sonan.programmers.skillChecks.level2;

import java.util.AbstractMap;
import java.util.Arrays;

/**
 * Created by Jaeseong on 2020/08/08
 * Git Hub : https://github.com/AnJaeSeongS2
 *
 * 문제 설명
 * 조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
 * ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
 *
 * 조이스틱을 각 방향으로 움직이면 아래와 같습니다.
 *
 * ▲ - 다음 알파벳
 * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
 * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
 * ▶ - 커서를 오른쪽으로 이동
 * 예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
 *
 * - 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
 * - 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
 * - 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
 * 따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
 * 만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 *
 * 제한 사항
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 * 입출력 예
 * name	return
 * JEROEN	56
 * JAN	23
 * 출처
 *
 * // 65 ~ 90
 */
public class Solution {
    public int solution(String name) {
        char[] nameChars = name.toCharArray();
        return getCount(0, nameChars, 0);
    }

    private int getCount(int cursor, char[] name, int currentCount) {
        if (isResult(name)) {
            return currentCount;
        }

        char[] curName = Arrays.copyOf(name, name.length);
        if (curName[cursor] == 'A') {

            // move right or left

            // length, nextCursor
            AbstractMap.SimpleEntry<Integer, Integer> rightMove = rightLength(cursor, curName);
            AbstractMap.SimpleEntry<Integer, Integer> leftMove = leftLength(cursor, curName);
            return Math.min(getCount(rightMove.getValue(), curName, currentCount + rightMove.getKey()), getCount(leftMove.getValue(), curName, currentCount + leftMove.getKey()));
        } else {
            // move to up or down

            int nextCount = currentCount + Math.min(curName[cursor] - 65, 91 - curName[cursor]);
            curName[cursor] = 'A';
            return getCount(cursor, curName, nextCount);
        }
    }

    private boolean isResult(char[] name) {
        for (int i = 0; i < name.length; i++) {
            if (name[i] != 'A') {
                return false;
            }
        }
        return true;
    }

    // return length, nextCursor
    private AbstractMap.SimpleEntry<Integer, Integer> rightLength(int cursor, char[] name) {
        int currentCursor = cursor;
        int length = 0;
        while (name[currentCursor] == 'A') {
            currentCursor = (currentCursor + name.length + 1) % name.length;
            length++;
        }
        return new AbstractMap.SimpleEntry(length, currentCursor);
    }

    // return length, nextCursor
    private AbstractMap.SimpleEntry<Integer, Integer> leftLength(int cursor, char[] name) {
        int currentCursor = cursor;
        int length = 0;
        while (name[currentCursor] == 'A') {
            currentCursor = (currentCursor + name.length - 1) % name.length;
            length++;
        }
        return new AbstractMap.SimpleEntry(length, currentCursor);
    }
}
