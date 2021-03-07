package com.sonan.programmers.kakao.y2021;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * [본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.]
 *
 * 밤늦게 귀가할 때 안전을 위해 항상 택시를 이용하던 무지는 최근 야근이 잦아져 택시를 더 많이 이용하게 되어 택시비를 아낄 수 있는 방법을 고민하고 있습니다. 무지는 자신이 택시를 이용할 때 동료인 어피치 역시 자신과 비슷한 방향으로 가는 택시를 종종 이용하는 것을 알게 되었습니다. 무지는 어피치와 귀가 방향이 비슷하여 택시 합승을 적절히 이용하면 택시요금을 얼마나 아낄 수 있을 지 계산해 보고 어피치에게 합승을 제안해 보려고 합니다.
 *
 * 2021_kakao_taxi_01.png
 *
 * 위 예시 그림은 택시가 이동 가능한 반경에 있는 6개 지점 사이의 이동 가능한 택시노선과 예상요금을 보여주고 있습니다.
 * 그림에서 A와 B 두 사람은 출발지점인 4번 지점에서 출발해서 택시를 타고 귀가하려고 합니다. A의 집은 6번 지점에 있으며 B의 집은 2번 지점에 있고 두 사람이 모두 귀가하는 데 소요되는 예상 최저 택시요금이 얼마인 지 계산하려고 합니다.
 *
 * 그림의 원은 지점을 나타내며 원 안의 숫자는 지점 번호를 나타냅니다.
 * 지점이 n개일 때, 지점 번호는 1부터 n까지 사용됩니다.
 * 지점 간에 택시가 이동할 수 있는 경로를 간선이라 하며, 간선에 표시된 숫자는 두 지점 사이의 예상 택시요금을 나타냅니다.
 * 간선은 편의 상 직선으로 표시되어 있습니다.
 * 위 그림 예시에서, 4번 지점에서 1번 지점으로(4→1) 가거나, 1번 지점에서 4번 지점으로(1→4) 갈 때 예상 택시요금은 10원으로 동일하며 이동 방향에 따라 달라지지 않습니다.
 * 예상되는 최저 택시요금은 다음과 같이 계산됩니다.
 * 4→1→5 : A, B가 합승하여 택시를 이용합니다. 예상 택시요금은 10 + 24 = 34원 입니다.
 * 5→6 : A가 혼자 택시를 이용합니다. 예상 택시요금은 2원 입니다.
 * 5→3→2 : B가 혼자 택시를 이용합니다. 예상 택시요금은 24 + 22 = 46원 입니다.
 * A, B 모두 귀가 완료까지 예상되는 최저 택시요금은 34 + 2 + 46 = 82원 입니다.
 *
 * Created by Jaeseong on 2020/09/12
 * Git Hub : https://github.com/AnJaeSeongS2
 *
 * n	s	a	b	fares	result
 * 6	4	6	2	[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]	82
 * 7	3	4	1	[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]	14
 * 6	4	5	6	[[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]	18
 */
public class Solution4 {
//    class Graph {
//        public List<Integer> adj;
//        Graph() {
//            adj = new LinkedList<>();
//        }
//    }
    // (( index1 mixed index2 ), cost)
    private Map<Integer, Integer> costs = new HashMap();

    // index, adj
    private Map<Integer, List<Integer>> graph = new HashMap();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList());
        }

        for (int i = 0; i < fares.length; i++) {
            costs.put(fares[i][0]*1000 + fares[i][1], fares[i][2]);
            costs.put(fares[i][1]*1000 + fares[i][0], fares[i][2]);
            graph.get(fares[i][0]).add(fares[i][1]);
            graph.get(fares[i][1]).add(fares[i][0]);
        }

        // initialized.
        boolean[] visitedA = new boolean[n];
        boolean[] visitedB = new boolean[n];
        visitedA[s] = true;
        visitedB[s] = true;
        int curIndexA = s;
        int curIndexB = s;
        int min = 1000000000;



        int answer = 0;
        return answer;
    }
}
