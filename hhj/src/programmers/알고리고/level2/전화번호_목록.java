package src.programmers.알고리고.level2;

import java.util.*;
import java.util.stream.*;

public class 전화번호_목록 {
    public boolean solution(String[] phoneBook) {
        Set<String> phones = Arrays.stream(phoneBook)
                .collect(Collectors.toSet());

        for (int i = 0; i < phoneBook.length; i++) {
            String cp = phoneBook[i];

            for (int j = 0; j < cp.length(); j++) {

                if (phones.contains(cp.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }
}
