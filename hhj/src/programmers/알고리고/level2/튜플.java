package src.programmers.알고리고.level2;

import java.util.*;
import java.util.stream.*;

public class 튜플 {

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
        s = s.substring(2, s.length() - 2);

        List<String> tuples = Arrays
                .stream(s.split("},\\{"))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        Set<Integer> answer = new LinkedHashSet<>();

        for (String tuple : tuples) {
            StringTokenizer st = new StringTokenizer(tuple, ",");

            while (st.hasMoreTokens()) {
                answer.add(Integer.parseInt(st.nextToken()));
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}