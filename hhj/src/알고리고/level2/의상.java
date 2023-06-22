package src.알고리고.level2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    /**
     * clothes의 각 행은 의상 이름, 의상 종류로 이루어짐
     *
     * @param clothes : 스파이가 가진 의상들
     * @return : 서로 다른 조합수
     */
    public static int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;

        for (int clothe : clothesMap.values()) {
            answer *= clothe + 1;
        }

        return answer - 1;
    }
}