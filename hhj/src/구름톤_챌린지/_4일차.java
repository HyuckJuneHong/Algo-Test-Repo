package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 문제설명)
 * - 구름 햄버거는 N개 재료 순서대로 쌓아 만듬
 * - 맛은 사용된 모든 재료 맛의 정도를 더한 값
 * - 완벽한 햄버거는 맛의 정도가 가장 높은 재료를 기준 위와 아래로 갈수록 같거나 감소해야 함.
 * <p>
 * 입력)
 * - N : 구름 햄버거 재료 갯수 (1~1000)
 * - kn : 문자열로 공백을 두고 재료의 맛 (1 <= ki <= 10^6)
 * <p>
 * 출력)
 * - N개의 재료를 순서대로 쌓아 만든 햄버거의 i번째 쌓은 재료의 맛 정도가 Ki라고 할때 플레이어가 만든 햄버거 맛을 반환
 */
public class _4일차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String k = br.readLine();
        int answer = compareHamburger(N, k);

        System.out.println(answer);
    }

    private static int compareHamburger(int N, String k) {
        int[] taste = Arrays.stream(k.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxIdx = 0;

        for (int i = 1; i < N; i++) {
            if (taste[i] > taste[maxIdx]) {
                maxIdx = i;
            }
        }

        for (int i = 1; i < maxIdx; i++) {
            if (taste[i] < taste[i - 1]) {
                return 0;
            }
        }

        for (int i = maxIdx + 1; i < N; i++) {
            if (taste[i] > taste[i - 1]) {
                return 0;
            }
        }

        return Arrays.stream(taste).sum();
    }
}
