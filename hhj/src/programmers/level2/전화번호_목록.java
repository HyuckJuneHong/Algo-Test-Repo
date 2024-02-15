package src.programmers.level2;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class 전화번호_목록 {
    public boolean solution(String[] phoneBook) {
        Set<String> phones = Arrays.stream(phoneBook)
                .collect(Collectors.toSet());

        for (String phone : phones)
            for (int i = 1; i < phone.length(); i++)
                if (phones.contains(phone.substring(0, i)))
                    return false;

        return true;
    }
}
