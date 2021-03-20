package com.sonan.codility;

/**
 * N
 *
 * https://app.codility.com/c/run/training5QHFQE-RU7/
 */
class MaxDoubleSliceSum {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int N = A.length;

        if (N == 3) {
            return 0;
        }

        int[] headSum = new int[N];
        for (int x = 1; x <= N-3; x++) {
            headSum[x] = Math.max(0, headSum[x-1] + A[x]);
        }

        int[] tailSum = new int[N];
        for (int z = N - 2; z >= 2; z--) {
            tailSum[z] = Math.max(0, tailSum[z+1] + A[z]);
        }


        int max = 0;
        for (int y = 1; y <= N-2; y++) {
            max = Math.max(max, headSum[y-1] + tailSum[y+1]);
        }

        return max;
    }
}
