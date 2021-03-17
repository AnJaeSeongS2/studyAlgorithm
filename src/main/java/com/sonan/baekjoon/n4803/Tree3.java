package com.sonan.baekjoon.n4803;

import java.io.IOException;
import java.util.*;

/**
 * DONE
 *
 * Created by Jaeseong on 2021/03/13
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Tree3 {
    private static Map<Integer, Set<Integer>> vertex;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        //input
        Scanner sc = new Scanner(System.in);
        int count = 1;

        while(true) {
            int n = sc.nextInt();
            init(n);
            int m = sc.nextInt();
            if (m == 0 && n == 0) {
                return;
            }
            while (--m >= 0) {
                int srcVertex = sc.nextInt();
                int targetVertex = sc.nextInt();

                vertex.get(srcVertex).add(targetVertex);
                vertex.get(targetVertex).add(srcVertex);
            }

            int treeSize = 0;
            Queue<Integer> nextQueue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    nextQueue.add(i);
                    int visitedVertexSize = 0;
                    int edgeCount = 0;
                    while (!nextQueue.isEmpty()) {
                        Integer curVertex = nextQueue.poll();
                        visitedVertexSize++;
                        visited[curVertex] = true;
                        edgeCount += vertex.get(curVertex).size();
                        for (int nextVertex : vertex.get(curVertex)) {
                            if (!visited[nextVertex]) {
                                nextQueue.add(nextVertex);
                            }
                        }
                    }
                    if (edgeCount/2 + 1 == visitedVertexSize) {
                        treeSize++;
                    }
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

    private static void init(int n) {
        vertex = new HashMap<>();
        for (Integer i = 0; i <= n; i++) {
            vertex.put(i, new HashSet<Integer>());
        }
        visited = new boolean[n + 1];
    }
}
