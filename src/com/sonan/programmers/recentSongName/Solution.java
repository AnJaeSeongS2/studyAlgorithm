package com.sonan.programmers.recentSongName;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: Jaeseong An
 * Created Date: 2020-08-10
 */
public class Solution {
    private static final String NONE = "`(None)`";

    public String solution(String m, String[] musicinfos) {
        String convertedM = convertIcon(m);

        // music 길이로 정렬
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // 길이로 정렬된 상태.
        Map<Long, List<AbstractMap.SimpleEntry<String, String>>> orderedMusicInfos = new TreeMap<>(Collections.reverseOrder());
        try {
            for (String music : musicinfos) {
                String[] elem = music.split(",");
                Long minute = (timeFormat.parse(elem[1]).getTime() - timeFormat.parse(elem[0]).getTime()) / 60000L;
                char[] convertedMusicPad = convertIcon(elem[3]).toCharArray();
                char[] passedMusic = new char[minute.intValue()];
                for (int i = 0; i < passedMusic.length; i++) {
                    passedMusic[i] = convertedMusicPad[i % convertedMusicPad.length];
                }

                if (orderedMusicInfos.containsKey(minute)) {
                    orderedMusicInfos.get(minute).add(new AbstractMap.SimpleEntry<>(elem[2], passedMusic.toString()));
                } else {
                    List<AbstractMap.SimpleEntry<String, String>> newInstance = new LinkedList<>();
                    newInstance.add(new AbstractMap.SimpleEntry<>(elem[2], passedMusic.toString()));
                    orderedMusicInfos.put(minute, newInstance);
                }
            }
            // 정렬 완료.

            for (Map.Entry<Long, List<AbstractMap.SimpleEntry<String, String>>> entry: orderedMusicInfos.entrySet()) {
                ListIterator<AbstractMap.SimpleEntry<String, String>> iter = entry.getValue().listIterator();
                while (iter.hasNext()) {
                    AbstractMap.SimpleEntry<String, String> nameAndPassedMusic = iter.next();
                    if (nameAndPassedMusic.getValue().indexOf(convertedM) > -1) {
                        return nameAndPassedMusic.getKey();
                    }
                }
            }
            return NONE;
        } catch (Exception e) {
            return NONE;
        }
    }

    private static String convertIcon(String m) {
        return m.replaceAll("C#", "H").replaceAll("D#", "I").replaceAll("F#", "J").replaceAll("G#", "K").replaceAll("A#", "L");
    }
}
