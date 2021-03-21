package com.sonan.codility;

import java.util.LinkedList;
import java.util.List;

/**
 * https://app.codility.com/c/run/training2G6J42-4UX/
 *
 * Created by Jaeseong on 2021/03/20
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Peaks {
    public int solution(int[] A) {
        List<Integer> peaks = new LinkedList<>();
        if (A.length <= 1) {
            return 0;
        }

        for (int i = 1; i < A.length -1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        int groupCountSaved = 0;
        for (int groupCount = 1; groupCount <= peaks.size(); groupCount++) {
            if (A.length%groupCount != 0) {
                continue;
            }
            int groupSize = A.length/groupCount;
            if (canGrouping(groupSize, groupCount, peaks)) {
                groupCountSaved = groupCount;
            } else {
                break;
            }

        }
        return groupCountSaved;
    }
    /**
     * need A.length == groupSize* groupCount
     * @param groupSize
     * @param groupCount
     * @return
     */
    public static boolean canGrouping(int groupSize, int groupCount, List<Integer> peaks) {
        int nextPeakIndex = 0;
        for (int groupIndex = 0; groupIndex < groupCount; groupIndex++) {
            if (nextPeakIndex >= peaks.size()) {
                // currentGroup have no peak;
                return false;
            }
            int first = groupIndex*groupSize;
            int last = (groupIndex+1)*groupSize - 1;
            int nextPeakIndexSaved = nextPeakIndex;
            while (first <= peaks.get(nextPeakIndex) && last >= peaks.get(nextPeakIndex)) {
                nextPeakIndex++;
                if (nextPeakIndex >= peaks.size()) {
                    // last
                    break;
                }
            }
            if (nextPeakIndexSaved == nextPeakIndex) {
                // no have peak on this group
                return false;
            }
        }
        return true;
    }
}
