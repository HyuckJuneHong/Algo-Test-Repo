package src.프로그래머스.level2;

import java.util.*;

public class 튜플_Entry {

    public static int[] solution(String s) {
        s = s.replaceAll("[}{]", "");
        StringTokenizer st = new StringTokenizer(s, ",");
        Map<Integer, Integer> map = new HashMap<>();

        while (st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Map.Entry.comparingByValue(Comparator.reverseOrder()));

        return entries.stream()
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
