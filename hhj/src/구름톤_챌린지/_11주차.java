package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 문제
 - 통증 수치 0으로 유지
 - 통증 감소 아이템 2 종류
 - A : Ap 만큼 감소
 - B : Bp 만큼 감소
 - 원하는 만큼 획득 가능
 - 플레이어는 현재 N의 통증 수치 가짐
 - 0으로 줄이기 위한 최소 개수

 입력
 - N : 통증 수치 (2~10^6)
 - A, B : 아이템 (2~13)

 풀이
 1) 만약 둘 중 큰 값으로 나누어 떨어지면 끝
 */
public class _11주차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] item = br.readLine().split(" ");
		int A = Integer.parseInt(item[0]);
		int B = Integer.parseInt(item[1]);
		int answer = regain(N, A, B);
		System.out.println(answer);
	}

	private static int regain(int N, int A, int B) {
		int[] item = change(A, B);
		A = item[0];
		B = item[1];
		int count = N / A;
		int hp = N % A;

		if (hp == 0) {
			return count;
		}

		if (hp % B == 0) {
			return count + (hp / B);
		}

		while (hp % B != 0) {
			hp += A;
			count--;

			if (count < 0) {
				return -1;
			}
		}

		return count + (hp / B);
	}

	private static int[] change(int A, int B) {
		if (A >= B) {
			return new int[] {A, B};
		}

		return new int[] {B, A};
	}
}
