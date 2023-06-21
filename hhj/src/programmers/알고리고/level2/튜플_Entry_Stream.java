package src.programmers.알고리고.level2;

import java.util.*;
import java.util.stream.*;

public class 튜플_Entry_Stream {

    /**
     * 튜플 성질
     * - 중복 원소 가능
     * - 순서가 다르면 다른 튜플
     * - 원소 개수 유한
     * 원소 개수가 n인 중복 원소가 없는 튜플 제공
     *
     * @param s : 특정 튜플을 표현하는 집합이 담긴 문자열
     * @return : s가 표현하는 튜플을 배열로 반환
     */
    public static int[] solution(String s) {
        s = s.replaceAll("[}{]", "");
        StringTokenizer st = new StringTokenizer(s, ",");
        Map<Integer, Integer> map = new HashMap<>();

        while (st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        return entries.stream()
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
