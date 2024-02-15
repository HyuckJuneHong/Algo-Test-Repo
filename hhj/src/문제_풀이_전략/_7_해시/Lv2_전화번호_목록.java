package src.문제_풀이_전략._7_해시;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 phone_book : 전화번호부에 적힌 전화번호를 담은 배열 (len=1~1_000_000, value_len=1~20, 중복 X)
 return : 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false, 없으면 true

 1. 전화번호를 담은 해시셋 생성
 2. 배열에서 전화번호를 하나씩 꺼내 자기 자신을 제외한 모든 경우가 포함되는 지 검사
 3. 있다면 false 없으면 continue 후 모두 검사 시 true
 */
public class Lv2_전화번호_목록 {

	public boolean solution(String[] phone_book) {
		Set<String> phones = Arrays
			.stream(phone_book)
			.collect(Collectors.toSet());

		for (String phone : phone_book) {
			for (int i = 1; i < phone.length(); i++) {
				String temp = phone.substring(0, i);

				if (phones.contains(temp)) {
					return false;
				}
			}
		}

		return true;
	}
}
