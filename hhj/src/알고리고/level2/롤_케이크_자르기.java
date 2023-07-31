package src.알고리고.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤_케이크_자르기 {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        int size = topping.length;
        int answer = 0;

        for (int i = 0; i < size; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < size; i++) {
            int current = topping[i];
            set.add(current);
            map.put(current, map.get(current) - 1);

            if (map.get(current) == 0) {
                map.remove(current);
            }

            if (set.size() == map.size()) {
                answer++;
            }
        }

        return answer;
    }
}
