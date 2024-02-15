package src.프로그래머스.level2;

import java.util.HashSet;
import java.util.Set;

class 전화번호_목록_이근우 {
    /*
        문제 풀이 흐름
        1. 완전탐색 체크 -> O(20_000_000_000_000) -> 안됨
        2. 일일이 순회하지 않고, 한번에 있는지 없는지 확인 -> 해쉬 활용 -> O(20_000_000) 가능
        3. 접두사이기 때문에 자신보다 길이가 큰 수는 접두사가 될 수 없음 -> 정렬
        4. 각각의 전화번호를 선택해서 접두사를 만들고, set에 포함되어 있는지 확인 -> 있으면 false, 다 돌았는데 없으면 true

        시간 복잡도
        O(1_000_000 * log 1_000_000) + O(20 * 1_000_000) = O(20 * 1_000_000)
    */
    public boolean solution(String[] phone_book) {
        Set<String> prefixes = new HashSet<>();
        prefixes.add(phone_book[0]);

        for (int i = 1; i < phone_book.length; i++) {
            String phone = phone_book[i];

            for (int j = 1; j <= phone.length(); j++) {

                if (prefixes.contains(phone.substring(0, j))) {
                    return false;
                }
            }
            prefixes.add(phone);
        }
        return true;
    }
}
