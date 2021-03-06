package com.sonan.codility;

/**
 * https://app.codility.com/c/run/training2G6J42-4UX/
 *
 * Detected time complexity:
 * O(N * log(log(N)))
 *
 * *** 10만 size의 진행시 list나 int[]로 진행시 0.2 초 정도 걸리는 large random이 있다.
 * 이 케이스에는 0.2초가 걸린다. NLogN만에 timeout(1초)이상 걸리지 않는다.(중요
 * ON^2면 무조건 타임아웃이다. N이 10만이면.
 * 절대, stream api쓰지 말자. NLogN이더라도 timeout걸린다.
 * boxing unboxing은 속도에 큰 영향 없다.
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Peaks2 {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] peaks = new int[A.length];

        int peakCount = 0;
        for (int i = 1; i < A.length - 1 ; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                peaks[peakCount] = i;
                peakCount++;
            }
        }
        if (peakCount == 0) {
            return 0;
        }

        for (int groupCount = peakCount; groupCount >= 2; groupCount--) {
            if (A.length % groupCount == 0) {
                int elemCountOnGroup = A.length / groupCount;

                int groupCountHasPeak = 0;
                for (int indexOnPeak = 0; indexOnPeak < peakCount; indexOnPeak++) {
                    int indexOnA = peaks[indexOnPeak];
                    int first = groupCountHasPeak*elemCountOnGroup;
                    int end = (groupCountHasPeak+1)*elemCountOnGroup;
                    if (first <= indexOnA && end > indexOnA) {
                        groupCountHasPeak++;
                    }
                }
                if (groupCountHasPeak == groupCount) {
                    return groupCount;
                }
            }
        }
        return 1;
    }
}
