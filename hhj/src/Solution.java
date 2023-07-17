package src;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    /**
     * 1_000_000 * 2
     *
     * @param phoneBook
     * @return
     */
    public static boolean solution(String[] phoneBook) {
        Set<String> phones = Arrays.stream(phoneBook).collect(Collectors.toSet());

        for (String phone : phones) {

            for (int i = 1; i < phone.length(); i++) {
                String temp = phone.substring(0, i);

                if (phones.contains(temp)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] str = new String[]{
                "119", "97674223", "1195524421"
        };
        solution(str);
    }
}
