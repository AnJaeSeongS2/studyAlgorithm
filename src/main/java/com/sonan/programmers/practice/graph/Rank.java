package com.sonan.programmers.practice.graph;

import java.util.*;

/**
 * 문제 설명
 * n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.
 *
 * 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 선수의 수는 1명 이상 100명 이하입니다.
 * 경기 결과는 1개 이상 4,500개 이하입니다.
 * results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
 * 모든 경기 결과에는 모순이 없습니다.
 * 입출력 예
 * n	results	return
 * 5	[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]	2
 * 입출력 예 설명
 * 2번 선수는 [1, 3, 4] 선수에게 패배했고 5번 선수에게 승리했기 때문에 4위입니다.
 * 5번 선수는 4위인 2번 선수에게 패배했기 때문에 5위입니다.
 *
 * @idea:
 * 1. make Only greater/less than mapping
 * 2. is exists on All greater/less than mapping for dp?
 * 2.1 make all greater/less than mapping for dp.
 *
 * Created by Jaeseong on 2021/07/02
 * Git Hub : https://github.com/AnJaeSeongS2
 *
 * @thread-unsafe
 */
public class Rank {
    // key에 대해 모든 것을 알아냄.
    private static Map<Integer, Set<Integer>> greaterThanAll;
    private static Map<Integer, Set<Integer>> lessThanAll;

    // key에 대해 딱 비교군만 알아냄.
    private static Map<Integer, Set<Integer>> greaterThanOnly;
    private static Map<Integer, Set<Integer>> lessThanOnly;

    public int solution(int n, int[][] results) {
        //clear
        Integer[][] resultsConverted = convertAsInteger(results);
        greaterThanAll = new HashMap();
        lessThanAll = new HashMap();
        greaterThanOnly = new HashMap();
        lessThanOnly = new HashMap();
        initOnlyMappings(resultsConverted);

        int countKnowRank = 0;
        for (int i = 1; i <= n; i++) {
            if (getAllMembersGreaterThan(i).size() + getAllMembersLessThan(i).size() == n-1) {
                countKnowRank++;
            }
        }
        return countKnowRank;
    }

    private Integer[][] convertAsInteger(int[][] results) {
        Integer[][] resultsConverted = new Integer[results.length][];
        for (int i = 0; i < results.length; i++) {
            resultsConverted[i] = new Integer[results[i].length];
            for (int j = 0; j < results[i].length; j++) {
                resultsConverted[i][j] = Integer.valueOf(results[i][j]);
            }
        }
        return resultsConverted;
    }

    private void initOnlyMappings(Integer[][] results) {
        for (Integer[] result : results) {
            initOnlyGreaterThanMapping(result);
            initOnlyLessThanMapping(result);
        }
    }

    private void initOnlyGreaterThanMapping(Integer[] entry) {
        if (!greaterThanOnly.containsKey(entry[0])) {
            greaterThanOnly.put(entry[0], new HashSet());
        }
        greaterThanOnly.get(entry[0]).add(entry[1]);
    }

    private void initOnlyLessThanMapping(Integer[] entry) {
        if (!lessThanOnly.containsKey(entry[1])) {
            lessThanOnly.put(entry[1], new HashSet());
        }
        lessThanOnly.get(entry[1]).add(entry[0]);
    }

    private Set<Integer> getAllMembersGreaterThan(Integer key) {
        if (greaterThanAll.containsKey(key)) {
            return greaterThanAll.get(key);
        }

        Set<Integer> newValue = new HashSet();
        if (greaterThanOnly.containsKey(key)) {
            greaterThanOnly.get(key).forEach(onlyKey -> {
                if (!newValue.contains(onlyKey)) {
                    newValue.addAll(getAllMembersGreaterThan(onlyKey));
                }
            });
            newValue.addAll(greaterThanOnly.get(key));
        }
        greaterThanAll.put(key, newValue);
        return newValue;
    }


    private Set<Integer> getAllMembersLessThan(Integer key) {
        if (lessThanAll.containsKey(key)) {
            return lessThanAll.get(key);
        }

        Set<Integer> newValue = new HashSet();
        if (lessThanOnly.containsKey(key)) {
            lessThanOnly.get(key).forEach(onlyKey -> {
                if (!newValue.contains(onlyKey)) {
                    newValue.addAll(getAllMembersLessThan(onlyKey));
                }
            });
            newValue.addAll(lessThanOnly.get(key));
        }
        lessThanAll.put(key, newValue);
        return newValue;
    }
}
