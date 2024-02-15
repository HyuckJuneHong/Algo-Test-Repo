package src.문제_풀이_전략._11_도전_카카오_2022_블라인드_테스트;

/*
n: 양의 정수 (1~1_000_000)
k: 변환할 진수 (3~10)
return: n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 조건에 맞는 소수의 개수

1. Integer.toString(n, k)로 변환한다.
2. 조건에 맞는 숫자를 모두 찾는다.
*/

public class Lv2_k진수에서_소수_개수_구하기 {

	public int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		String converted = Integer.toString(n, k);
		int answer = 0;

		for (char c : converted.toCharArray()) {
			if (c != '0') {
				sb.append(c);
				continue;
			}

			if (isPrime(sb.toString())) {
				answer++;
			}

			sb.setLength(0);
		}

		if (isPrime(sb.toString())) {
			answer++;
		}

		return answer;
	}

	public boolean isPrime(String value) {
		if (value.isEmpty()) {
			return false;
		}

		long number = Long.parseLong(value);
		long mid = (int)Math.sqrt(number);

		if (number <= 2) {
			return number == 2;
		}

		for (long i = 2; i <= mid; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
