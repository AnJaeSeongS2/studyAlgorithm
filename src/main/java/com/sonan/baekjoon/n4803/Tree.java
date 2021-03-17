package com.sonan.baekjoon.n4803;

import java.io.IOException;
import java.util.*;

/**
 * 문제
 * 그래프는 정점과 간선으로 이루어져 있다. 두 정점 사이에 경로가 있다면, 두 정점은 연결되어 있다고 한다. 연결 요소는 모든 정점이 서로 연결되어 있는 정점의 부분집합이다. 그래프는 하나 또는 그 이상의 연결 요소로 이루어져 있다.
 *
 * 트리는 사이클이 없는 연결 요소이다. 트리에는 여러 성질이 있다. 예를 들어, 트리는 정점이 n개, 간선이 n-1개 있다. 또, 임의의 두 정점에 대해서 경로가 유일하다.
 *
 * 그래프가 주어졌을 때, 트리의 개수를 세는 프로그램을 작성하시오.
 *
 * 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 n ≤ 500과 m ≤ n(n-1)/2을 만족하는 정점의 개수 n과 간선의 개수 m이 주어진다. 다음 m개의 줄에는 간선을 나타내는 두 개의 정수가 주어진다. 같은 간선은 여러 번 주어지지 않는다. 정점은 1번부터 n번까지 번호가 매겨져 있다. 입력의 마지막 줄에는 0이 두 개 주어진다.
 *
 * 출력
 * 입력으로 주어진 그래프에 트리가 없다면 "No trees."를, 한 개라면 "There is one tree."를, T개(T > 1)라면 "A forest of T trees."를 테스트 케이스 번호와 함께 출력한다.
 * Created by Jaeseong on 2021/03/13
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Tree {
    private static Map<Integer, Map> rootMap = new HashMap<>();
    private static boolean[] isCycle = new boolean[501];

    // 0 : 입력안된 상황, -1: root , n>=1: parent가 해당 vertex
    private static int[] parentVertex = new int[501];
    public static void main(String[] args) throws IOException {
        //input
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while(true) {
            rootMap = new HashMap<>();
            isCycle = new boolean[501];
            parentVertex = new int[501];
            Integer n = sc.nextInt();
            int m = sc.nextInt();
            if (m == 0 && n == 0) {
                return;
            }
            while(--m >=0) {
                Integer srcVertex = sc.nextInt();
                Integer targetVertex = sc.nextInt();
                List<Map.Entry<Integer, Map>> selectedSrcVertexList = getSelectedMapEntryIfExists(rootMap, srcVertex);
                if (selectedSrcVertexList.size() == 0) {
                    List<Map.Entry<Integer, Map>> selectedTargetVertexList = getSelectedMapEntryIfExists(rootMap, targetVertex);
                    if (selectedTargetVertexList.size() == 0) {
                        // put new.
                        Map<Integer, Map> targetVertexMap = new HashMap<>();
                        targetVertexMap.put(targetVertex, new HashMap());
                        rootMap.put(srcVertex, targetVertexMap);
                    } else {
                        // selected target
                        // put new on Leaf Node.
                        selectedTargetVertexList.get(0).getValue().put(srcVertex, new HashMap());
                        if (isCycle[selectedTargetVertexList.get(0).getKey()]) {
                            isCycle[srcVertex] = true;
                        }
                    }
                } else {
                    List<Map.Entry<Integer, Map>> selectedTargetVertexList = getSelectedMapEntryIfExists(rootMap, targetVertex);
                    if (selectedTargetVertexList.size() == 0) {
                        // selected only src
                        // put new on Leaf Node.
                        selectedSrcVertexList.get(0).getValue().put(targetVertex, new HashMap());
                        if (isCycle[selectedSrcVertexList.get(0).getKey()]) {
                            isCycle[targetVertex] = true;
                        }
                    } else {
                        // selected on src and target
                        // start vertex.checking time.
                        if (selectedSrcVertexList.get(selectedSrcVertexList.size()-1).getKey()
                            .equals(selectedTargetVertexList.get(selectedTargetVertexList.size()-1).getKey())
                        ) {
                            // same case -> all change 'false' to 'true.'
                            Integer startVertex = selectedSrcVertexList.get(selectedSrcVertexList.size()-1).getKey();
                            isCycle[startVertex] = true;
                            changeIsCycleTrue(rootMap.get(startVertex));
                        } else {
                            // not same case ->
                            // 1. ture 감염 가능성 여부 체크
                            // 2. re밸런싱..
                            Integer remainKeyOnRootMap = selectedSrcVertexList.get(selectedSrcVertexList.size()-1).getKey();
                            Integer removeKeyOnRootMap = selectedTargetVertexList.get(selectedTargetVertexList.size()-1).getKey();
                            if (isCycle[remainKeyOnRootMap] || isCycle[removeKeyOnRootMap]) {
                                // True 감염시킨다.
                                isCycle[remainKeyOnRootMap] = true;
                                isCycle[removeKeyOnRootMap] = true;
                                changeIsCycleTrue(rootMap.get(remainKeyOnRootMap));
                                changeIsCycleTrue(rootMap.get(removeKeyOnRootMap));
                            }

                            Map<Integer, Map> curParentMap = selectedSrcVertexList.get(0).getValue();
                            Integer prevKey = selectedSrcVertexList.get(0).getKey();
                            for (int i = 0; i < selectedTargetVertexList.size(); i++) {
                                curParentMap.put(selectedTargetVertexList.get(i).getKey(), selectedTargetVertexList.get(i).getValue());
                                curParentMap = selectedTargetVertexList.get(i).getValue();
                                curParentMap.remove(prevKey);
                                prevKey = selectedTargetVertexList.get(i).getKey();
                            }
                            rootMap.remove(removeKeyOnRootMap);
                        }
                    }
                }
            }
            int treeSize = 0;
            for (Integer startKey: rootMap.keySet()) {
                if (!isCycle[startKey]) {
                    treeSize++;
                }
            }
            for (Integer i = 1; i <= n; i++) {
                if (getSelectedMapEntryIfExists(rootMap, i).size() == 0) {
                    treeSize++;
                }
            }
            if (treeSize >= 2) {
                System.out.printf("Case %d: A forest of %d trees.\n", count, treeSize);
            } else if (treeSize == 1) {
                System.out.printf("Case %d: There is one tree.\n", count);
            } else if (treeSize == 0) {
                System.out.printf("Case %d: No trees.\n", count);
            }
            count++;
        }
    }

    private static List<Map.Entry<Integer, Map>> getSelectedMapEntryIfExists(Map<Integer, Map> map, Integer vertex) {
        for (Map.Entry<Integer, Map> entry: map.entrySet()) {
            if (entry.getKey().equals(vertex)) {
                return new ArrayList<Map.Entry<Integer, Map>>() {{ add(entry); }};
            } else {
                List<Map.Entry<Integer, Map>> childMapEntryList = getSelectedMapEntryIfExists(entry.getValue(), vertex);
                if (childMapEntryList.size() != 0) {
                    childMapEntryList.add(entry);
                    return childMapEntryList;
                }
            }
        }
        return new ArrayList();
    }

    private static void changeIsCycleTrue(Map<Integer, Map> map) {
        for (Map.Entry<Integer, Map> entry: map.entrySet()) {
            isCycle[entry.getKey()] = true;
            changeIsCycleTrue(entry.getValue());
        }
    }
}
