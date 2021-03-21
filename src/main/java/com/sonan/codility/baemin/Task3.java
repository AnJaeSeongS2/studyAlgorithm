package com.sonan.codility.baemin;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Jaeseong on 2021/03/21
 * Git Hub : https://github.com/AnJaeSeongS2
 */

// O(NLogN) , N: 10만
public class Task3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> postive = new HashSet();
        Set<Integer> negative = new HashSet();
        // for get last (sorted)
        TreeSet<Integer> setTwo = new TreeSet();

        for (int member: A) {
            if (member >= 0) {
                postive.add(member);
                if (negative.contains(member)) {
                    setTwo.add(member);
                }
            } else {
                int postiveMember = -member;
                negative.add(postiveMember);
                if (postive.contains(postiveMember)) {
                    setTwo.add(postiveMember);
                }
            }
        }

        if (setTwo.size() == 0) {
            return 0;
        }
        return setTwo.last();
    }
}
