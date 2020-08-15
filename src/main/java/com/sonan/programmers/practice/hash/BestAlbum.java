package com.sonan.programmers.practice.hash;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 이슈: HashMap 내 key로 새로 추가한 것의 compare 이슈.
 *
 *
 * level3
 * 베스트앨범
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 *
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다
 * @Calculated_Big_O: nlogn
 * @github: http://github.com/AnJaeseongS2
 * @createdBy: jindam91@naver.com
 * @created: 2020-08-14
 * @since: 1.8
 */
public class BestAlbum {
  public int[] solution(String[] genres, int[] plays) {
    // name,                sum
    Map<CustomString, SimpleEntry<Integer, TreeMap>> map = new HashMap();
    ArrayList<Integer> result = new ArrayList();
    for (int i = 0; i < genres.length; i++) {
      SimpleEntry<Integer, TreeMap> t = map.get(new CustomString(genres[i], 0));
      if (map.containsKey(new CustomString(genres[i], 0))) {
        SimpleEntry<Integer, TreeMap> entry = map.remove(new CustomString(genres[i], 0));
        SimpleEntry<Integer, TreeMap> convertedEntry = new SimpleEntry(entry.getKey() + plays[i], entry.getValue());
        convertedEntry.getValue().put(plays[i], i);
        if (convertedEntry.getValue().size() == 3) {
          convertedEntry.getValue().pollFirstEntry();
        }
        map.put(new CustomString(genres[i], entry.getKey() + plays[i]), convertedEntry);
      } else {
        // count , index
        TreeMap<Integer, Integer> inputCount = new TreeMap<Integer, Integer>((o1, o2) -> o1.compareTo(o2) <= 0 ? -1 : o1.compareTo(o2));
        inputCount.put(plays[i], i);
        map.put(new CustomString(genres[i], plays[i]), new SimpleEntry<Integer, TreeMap>(plays[i], inputCount));
      }
    }

    // HashMap key sort
    List<CustomString> keyList = new ArrayList();
    for (Map.Entry<CustomString, SimpleEntry<Integer, TreeMap>> entry: map.entrySet()) {
      keyList.add(entry.getKey());
    }
    Collections.sort(keyList, Collections.reverseOrder());
    for (CustomString key: keyList) {
      Map<Integer, Integer> max2CountAndIndex = map.get(key).getValue();
      while (!max2CountAndIndex.isEmpty()) {
        result.add(((TreeMap<Integer, Integer>) max2CountAndIndex).pollLastEntry().getValue());
      }
    }
    int[] realResult = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      realResult[i] = result.get(i);
    }
    return realResult;
  }

  class CustomString implements Comparable {
    private String string;
    private Integer max;
    public CustomString(String string, Integer max) {
      this.string = string;
      this.max = max;
    }

    public String getString() {
      return string;
    }

    public void setString(String string) {
      this.string = string;
    }

    public Integer getMax() {
      return max;
    }

    public void setMax(Integer max) {
      this.max = max;
    }

    @Override
    public int hashCode() {
      return this.string.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      return this.string.equals(((CustomString)obj).getString());
    }

    // -1, 1만 제공.
    @Override
    public int compareTo(Object o) {
      if (this.string.equals(((CustomString)o).getString())) {
        return 0;
      }
      return this.max < ((CustomString)o).getMax() ? -1 : 1;
    }
  }
}
