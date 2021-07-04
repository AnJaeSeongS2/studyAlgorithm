package com.sonan.programmers.naverwebtoon;

import java.util.*;

/**
 * 문제 설명
 * 문서 편집기에는 찾아 바꾸기라는 기능이 있습니다. 찾아 바꾸기를 이용하여 파일에서 바꿀 문자열을 찾은 뒤, 그 문자열이 발견되면 그 문자열을 제거하는 과정을 진행합니다. 찾아 바꾸기는 한 번에 한 개의 문자열만 제거할 수 있습니다. 따라서 제거할 문자열이 여러 번 나타나거나, 문자열을 제거한 결과가 또 다시 바꿀 문자열과 같아지는 경우 한번 더 찾아 바꾸기를 해야 합니다.
 *
 * 예를 들어, aabcbcd 문자열에서 abc 라는 문자열을 제거하고 싶을 때,찾아 바꾸기를 1번 실행하면 abcd가 됩니다.이 때, abc가 1번 더 생기게 되므로, 한번 더 찾아 바꾸기를 실행하여 d로 바꿀 수 있습니다. 더 이상 abc 문자열이 존재하지 않으므로 총 2번의 찾아 바꾸기 과정을 통해 문자열을 모두 바꿀 수 있습니다.
 *
 * 검색하고자 하는 문장 s에서 문자열 t를 찾아 제거할 때, 총 몇 번의 찾아 바꾸기를 진행해야 문장 s에서 t가 더이상 존재하지 않는지 계산하는 함수를 완성하세요.
 *
 * 제한사항
 * 문자열 s : 길이는 1,000,000 이하의 자연수이며, 소문자로만 이루어져 있습니다.
 * 문자열 t : 길이는 10 이하의 자연수이며, 소문자로만 이루어져 있습니다. (단 문자열 t의 문자들은 중복되지 않습니다.)
 * 입출력 예
 * s	t	result
 * "aabcbcd"	"abc"	2
 * "aaaaabbbbb"	"ab"	5
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제의 예시와 같습니다.
 *
 * 입출력 예 #2
 *
 * "ab"를 제거하면 "aaaabbbb"가 남게 되고, 또 "ab"를 제거할 수 있게 됩니다. 같은 방식으로 총 5번을 진행하면 S 문자열에 "ab"가 더이상 존재하지 않게 됩니다.
 *
 *
 * 아이디어:
 * mapping 1,2,3,4 : a,b,c,c 이런 식으로
 *
 * 1,2,3,4를 순차적으로 대기 로 둔다.
 * 대기에 있는 녀석과 맞지않은 순서로 오는 경우 대기열을 삭제한다.
 * 시작 순서의 열이오는 경우 대기열을 하나 더 생성한다.
 * 대기열 그림은 아래와 같다.
 *
 *
 * 3
 * 2    2
 * 1 1  1   <- 우선순위 높음. 3이 들어왔을때
 *
 * 3    3
 * 2    2
 * 1 1  1 이 됨.
 *
 * 이때 2에 해당하는 b가 들어오면 123 하나가 삭제되고, 2가 1에 추가되어
 *
 * 3
 * 2  2  가 됨.
 * 1  1
 *
 * 대기열 자체는 Stack<Integer>로 관리하고, pop, push 를 이용하며 대기열 초기화를 무한반복.
 * complete로써 판명되면 resultCount++
 *
 *
 * Created by Jaeseong on 2021/07/04
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Sol3 {
    public int solution(String s, String t) {
        Map<Integer, Character> indexCharMap = new HashMap();
        Map<Character, Set<Integer>> charIndexMap = new HashMap();
        int completeSize = t.length();
        int resultCompleteCount = 0;
        Stack<Integer> candidateStack = new Stack<>();

        char[] tArr = t.toCharArray();
        for (char a = 'a'; a <= 'z'; a++) {
            charIndexMap.put(a, new HashSet());
        }


        for (int i = 0; i < tArr.length; i++) {
            indexCharMap.put(i, tArr[i]);
            charIndexMap.get(tArr[i]).add(i);
        }

        int i = 0;
        for (char c : s.toCharArray()) {
            boolean isSearchedOnStack = false;
            while (!candidateStack.isEmpty()) {
                Integer candidateIndex = candidateStack.peek() + 1;
                if (charIndexMap.get(c).contains(candidateIndex)) {
                    isSearchedOnStack = true;
                    candidateStack.pop();
                    candidateStack.push(candidateIndex);
                    break;
                } else {
                    if (charIndexMap.get(c).contains(0)) {
                        isSearchedOnStack = true;
                        candidateStack.push(0);
                        break;
                    }
                    candidateStack.pop();
                }
            }
            if (!isSearchedOnStack) {
                if (charIndexMap.get(c).contains(0)) {
                    candidateStack.push(0);
                }
            }

            if (!candidateStack.isEmpty() && candidateStack.peek() +1== completeSize) {
                // complete case:
                resultCompleteCount++;
                candidateStack.pop();
            }
            i++; // for debug
        }
        return resultCompleteCount;
    }
}
