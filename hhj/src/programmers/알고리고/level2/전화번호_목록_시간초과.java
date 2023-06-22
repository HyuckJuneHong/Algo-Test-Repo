package src.programmers.알고리고.level2;

import java.util.*;
import java.util.stream.*;

public class 전화번호_목록_시간초과 {
    public static boolean solution(String[] phoneBook) {
        List<String> phones = Arrays.stream(phoneBook)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        for (int i = 0; i < phones.size() - 1; i++) {
            String cp = phones.get(i);
            for (int j = i + 1; j < phones.size(); j++) {
                String np = phones.get(j);
                if (cp.equals(np.substring(0, cp.length()))) {
                    return false;
                }
            }
        }

        return true;
    }
}
