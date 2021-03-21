package com.sonan.codility.baemin;

import java.util.Arrays;

/**
 * bug fix.
 *
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
class Task4 {
    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k])
                i++;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}

// original
//public class Task4 {
//    int solution(int[] A, int[] B) {
//        int n = A.length;
//        int m = B.length;;
//        Arrays.sort(A);
//        Arrays.sort(B);
//        int i = 0;
//        for (int k = 0; k < n; k++) {
//            if (i < m - 1 && B[i] < A[k])
//                i += 1;
//            if (A[k] == B[i])
//                return A[k];
//        }
//        return -1;
//    }
//}
