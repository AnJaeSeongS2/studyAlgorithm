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
public class Flags {
    public int solution(int[] A) {
        Set<Integer> peaks = genPeaks(A);
        if (peaks.size() <= 1) {
            return peaks.size();
        }

        int[] nextPeakDists = genPeakDists(peaks);
        int curFlagCount = (0 + peaks.size())/2;
        int prevCurFlagCount = -1;

        // O(N logN)
        int lastPeak = peaks.size() - 1;
        int firstPeak = 0;
        while (curFlagCount != prevCurFlagCount) {
            if (canSetFlag(curFlagCount, nextPeakDists)) {
                prevCurFlagCount = curFlagCount;
                firstPeak = curFlagCount;
                if (curFlagCount != lastPeak) {
                    curFlagCount = (curFlagCount + lastPeak + 1) /2;
                }
            } else {
                prevCurFlagCount = curFlagCount;
                lastPeak = curFlagCount;
                curFlagCount = (curFlagCount + firstPeak) /2;
            }
        }

        return curFlagCount;
    }


    /**
     * O (N)
     * @param src
     * @return
     */
    public Set<Integer> genPeaks(int[] src) {
        Set<Integer> peaks = new HashSet();

        int prevHeight = 999_999_999;
        for (int i = 0; i < src.length - 1; i++) {
            if (src[i] > prevHeight && src[i + 1] < src[i]) {
                // peak case
                peaks.add(i);
            }
            prevHeight = src[i];
        }
        return peaks;
    }


    /**
     * O(N)
     * @param peaks
     * @return
     */
    public int[] genPeakDists(Set<Integer> peaks) {
        if (peaks.size() == 0) {
            return new int[]{};
        }

        int[] nextPeakDists = new int[peaks.size()-1];
        int prevIndex = -1;
        int i = 0;
        for (Integer peakIndex : peaks) {
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
