package com.sonan.programmers.practice.dp;

import java.util.*;

/**
 * 메모이제이션 상향식인 듯.
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 * N으로 표현
 * 문제 설명
 * 아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
 *
 * 12 = 5 + 5 + (5 / 5) + (5 / 5)
 * 12 = 55 / 5 + 5 / 5
 * 12 = (55 + 5) / 5
 *
 * 5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
 * 이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
 *
 * 제한사항
 * N은 1 이상 9 이하입니다.
 * number는 1 이상 32,000 이하입니다.
 * 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
 * 최솟값이 8보다 크면 -1을 return 합니다.
 * 입출력 예
 * N	number	return
 * 5	12	4
 * 2	11	3
 * 입출력 예 설명
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * 11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.
 *
 * 출처
 *
 * ※ 공지 - 2020년 9월 3일 테스트케이스가 추가되었습니다.
 *
 * Created by Jaeseong on 2021/03/08
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class ExpressionWithN {
    private int[] numberToResult;
    private Map<Integer, Set<Integer>> resultToNumberSet;
    public int solution(int N, int number) {
        init();
        for (int i = 1, result = N; i <= 8; i++) {
            append(i, result);
            result = result * 10 + N;
        }

        for (int i = 1; i <= 8; i++) {
            if (numberToResult[number + 100_000_000] != 0) {
                return numberToResult[number + 100_000_000];
            }
            for (int j = 1; j < i; j++) {
                int result1 = j;
                int result2 = i - j;
                resultToNumberSet.get(result1).forEach(innerNumber1 -> {
                    resultToNumberSet.get(result2).forEach(innerNumber2 -> {
                        append(result1 + result2, innerNumber1 + innerNumber2);
                        append(result1 + result2, innerNumber1 - innerNumber2);
                        append(result1 + result2, innerNumber1 * innerNumber2);
                        if (innerNumber2 != 0) {
                            append(result1 + result2, innerNumber1 / innerNumber2);
                        } else {
                            append(result1 + result2, 0);
                        }
                    });
                });
            }
        }
        return numberToResult[number + 100_000_000] == 0 ? -1 : numberToResult[number + 100_000_000];
    }
    private void init() {
        if (numberToResult == null) {
            numberToResult = new int[200_000_000];
        } else {
            for (int i = 0; i < 200_000_000; i++) {
                numberToResult[i] = 0;
            }
        }
        resultToNumberSet = new HashMap<>();
    }
    private void append(int result, int num) {
        if (numberToResult[num + 100_000_000] == 0) {
            numberToResult[num + 100_000_000] = result;
            Set<Integer> numSet = resultToNumberSet.get(result);
            if (numSet == null) {
                numSet = new HashSet();
                resultToNumberSet.put(result, numSet);
            }
            numSet.add(num);
        }
    }
}
