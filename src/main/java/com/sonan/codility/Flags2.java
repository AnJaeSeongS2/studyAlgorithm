package com.sonan.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/c/run/training3TJE54-XJG/
 *
 * O(N logN)
 * Created by Jaeseong on 2021/03/20
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class Flags2 {
    public int solution(int[] A) {
        int[] peaks = genPeaks(A);
        if (peaks.length <= 1) {
            return peaks.length;
        }

        // O
        int[] peakDists = genPeakDists(peaks);
        int lastPeak = peaks.length - 1;
        int firstPeak = 0;

        // max limit
        int maxPeakCount = (int) Math.sqrt((peaks[lastPeak] - peaks[firstPeak] + 1));
        for (int i = maxPeakCount; i >= 1; i--) {
            if (canSetFlag(i, peakDists)) {
                return i;
            }
        }
        return 0;
    }


    /**
     * O (N)
     * @param src
     * @return
     */
    public int[] genPeaks(int[] src) {
        Set<Integer> peaks = new HashSet();

        int prevHeight = -1;
        for (int i = 0; i < src.length - 1; i++) {
            if (src[i] > prevHeight && src[i + 1] < src[i]) {
                // peak case
                peaks.add(i);
            }
            prevHeight = src[i];
        }

        if (src.length >= 2) {
            // final check
            if (src[src.length - 1] > src[src.length - 2]) {
                peaks.add(src.length - 1);
            }
        }
        return peaks.stream().mapToInt(value -> (int)value).toArray();
    }


    /**
     * O(N)
     * @param peaks
     * @return
     */
    public int[] genPeakDists(int[] peaks) {
        if (peaks.length == 0) {
            return new int[]{};
        }

        int[] nextPeakDists = new int[peaks.length-1];
        int prevIndex = -1;
        int i = 0;
        for (int peakIndex : peaks) {
            if (prevIndex != -1) {
                nextPeakDists[i++] = peakIndex - prevIndex;
                prevIndex = peakIndex;
            } else {
                prevIndex = peakIndex;
            }
        }
        return nextPeakDists;
    }

    /**
     * O(N)
     * @param flagCount
     * @return
     */
    public boolean canSetFlag(int flagCount, int[] nextPeakDists) {
        int distSaved = 0;
        int peakCount = 0;
        if (nextPeakDists.length > 0) {
            peakCount = 1;
        }
        for (int nextDist : nextPeakDists) {
            distSaved += nextDist;
            if (distSaved >= flagCount) {
                peakCount++;
                distSaved = 0;
            }
            if (flagCount == peakCount) {
                return true;
            }
        }

        if (flagCount == peakCount) {
            return true;
        }
        return false;
    }
}
