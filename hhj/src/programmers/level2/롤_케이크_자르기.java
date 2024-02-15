package src.programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤_케이크_자르기 {
    public int solution(int[] topping) {
        Map<Integer, Integer> map = init(topping);
        int answer = 0;

        answer += slideWindow(topping, map);

        return answer;
    }

    private HashMap<Integer, Integer> init(int[] topping) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        return map;
    }

    private int slideWindow(int[] topping, Map<Integer, Integer> map) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int t : topping) {
            set.add(t);
            map.put(t, map.get(t) - 1);

            if (map.get(t) == 0) {
                map.remove(t);
            }

            if (set.size() == map.size()) {
                count++;
            }
        }

        return count;
    }
}
