package com.sonan.baekjoon.n4803;

import java.io.IOException;
import java.util.*;

/**
 * Created by Jaeseong on 2021/03/13
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Tree2 {

    // 0 : 입력안된 상황, root , n>=1: parent가 해당 vertex
    // rootVertex: 0
    private static int[] parentVertex = new int[501];
    private static Map<Integer, Set<Integer>> childVertex = new HashMap();
    private static boolean[] isCycle = new boolean[501];
    public static void main(String[] args) throws IOException {
        //input
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while(true) {
            init();
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (m == 0 && n == 0) {
                return;
            }
            while (--m >= 0) {
                Integer srcVertex = sc.nextInt();
                Integer targetVertex = sc.nextInt();

                Integer srcRoot = getRootVertex(srcVertex);
                Integer targetRoot = getRootVertex(targetVertex);

                if (srcRoot == targetRoot) {
                    changeToCycle(srcRoot);
                    connect(srcVertex, targetVertex);
                } else {
                    if (isCycle[srcRoot] && !isCycle[targetRoot]) {
                        changeToCycle(targetRoot);
                        connect(srcVertex, targetVertex);
                    } else if (!isCycle[srcRoot] && isCycle[targetRoot]) {
                        changeToCycle(srcRoot);
                        connect(targetVertex, srcVertex);
                    } else {
                        connect(srcVertex, targetVertex);
                    }
                }
            }
            Integer treeSize = 0;
            for (int i = 1; i <= n; i++) {
                if (parentVertex[i] == 0) {
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

    private static void init() {
        isCycle = new boolean[501];
        parentVertex = new int[501];
        childVertex = new HashMap();
        childVertex.put(0, new HashSet());
        Set<Integer> childVertexSet = childVertex.get(0);
        for (Integer i = 1; i <= 500; i++) {
            childVertexSet.add(i);
        }
    }

    /**
     * @param vertex
     * @return
     */
    private static int getRootVertex(int vertex) {
        if (parentVertex[vertex] == 0) {
            return vertex;
        } else {
            return getRootVertex(parentVertex[vertex]);
        }
    }

    /**
     * @param vertex1 parent취급되는 vertex
     * @param vertex2 이어짐 당할 vertex
     */
    private static void connect(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex2 <= 0) {
            return;
        }

        int prevParentVertex2 = parentVertex[vertex2];
        if (childVertex.get(vertex1) == null) {
            childVertex.put(vertex1, new HashSet<>());
        }
        childVertex.get(vertex1).add(vertex2);
        if (childVertex.get(prevParentVertex2) != null) {
            childVertex.get(prevParentVertex2).remove(vertex2);
        }
        parentVertex[vertex2] = vertex1;

        connect(vertex2, prevParentVertex2);
    }

    private static boolean isSameRootVertex(int vertex1, int vertex2) {
        int rootVertex1 = getRootVertex(vertex1);
        int rootVertex2 = getRootVertex(vertex2);
        if (rootVertex1 > 0 && rootVertex2 > 0 && rootVertex1 == rootVertex2) {
            return true;
        }
        return false;
    }

    private static void changeToCycle(int rootVertex) {
        if (rootVertex <= 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootVertex);
        while (!queue.isEmpty()) {
            Integer curVertex = queue.poll();
            isCycle[curVertex] = true;

            Set<Integer> childVertexSet = childVertex.get(curVertex);
            if (childVertexSet != null) {
                for (Integer childVertex : childVertexSet) {
                    queue.add(childVertex);
                }
            }
        }
    }
}
