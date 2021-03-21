package com.sonan.codility;

import java.util.*;

/**
 * https://app.codility.com/c/run/trainingX3KU5Z-RNF/
 *
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public class CountSemiprimes {
    //cache
    private static Map<Integer, Boolean> isSemiPrime = new HashMap<>();
    private static Set<Integer> isNoPrime = new HashSet<>();
    private static Integer sqrtN = 0;
    private static Integer N = 0;
    private synchronized void init(int initN){
        N = initN;
        sqrtN = (Integer)(int)Math.sqrt(N);
        isSemiPrime = new HashMap<>();
        isNoPrime = new HashSet<>();
        isNoPrime.add(0);
        isNoPrime.add(1);
        for (Integer i = 2; i <= sqrtN; i++) {
            for (Integer j = (Integer)(int)Math.pow(i, 2); j <= N; j += i) {
                isNoPrime.add(j);
            }
        }

        isSemiPrime.put(0, false);
        isSemiPrime.put(1, false);
        isSemiPrime.put(2, false);
        isSemiPrime.put(3, false);
        for (Integer x = 2; x <= sqrtN; x++) {
            if (!isPrime(x)) {
                continue;
            }
            for (Integer y = 2; x*y <= N; y++) {
                if (!isPrime(y)) {
                    continue;
                }
                Integer curValueToCheck = x*y;
                if (isSemiPrime.containsKey(curValueToCheck)) {
                    continue;
                }
                Boolean canDivideByOtherValue = false;
                for (int otherValue = 2; otherValue <= sqrtN; otherValue++) {
                    if (otherValue == x || otherValue == y) {
                        continue;
                    }
                    if (curValueToCheck%otherValue != 0) {
                        canDivideByOtherValue = true;
                        break;
                    }
                }

                isSemiPrime.put(curValueToCheck, canDivideByOtherValue);
            }
        }
    }

    public int[] solution(int N, int[] P, int[] Q) {
        init(N);
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int countSemiPrime = 0;
            for (int j = P[i]; j <= Q[i]; j++) {
                if (isSemiPrime(j)) {
                    countSemiPrime++;
                }
            }
            result[i] = countSemiPrime;
        }
        return result;
    }

    public boolean isSemiPrime(Integer value) {
        if (value > N) {
            throw new RuntimeException("please init N");
        }
        if (isSemiPrime.containsKey(value)) {
            return isSemiPrime.get(value);
        }
        return false;
    }

    public boolean isPrime(Integer value) {
        if (value > N) {
            throw new RuntimeException("please init N");
        }
        return !isNoPrime.contains(value);
    }
}
