package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제설명
 * - N개의 10진수 정수 주어짐
 * - 10진수 정수를 2진수로 나타냈을 때, 2진수에 포함된 1의 개수를 기준으로 내림차순 정렬
 * - 1의 개수가 같으면 원래 10진수를 기준으로 내림차순 정렬
 * - K번째 위치한 수 어떤 수가 될지 구하기
 * <p>
 * 입력
 * - N : 정수 갯수(1 ~ 500_000)
 * - K : 찾으려는 정수 위치 (1 ~ N)
 * - a : N개의 정수 배열
 * <p>
 * 출력
 * - K 번째 위치한 수의 10진수 정수값
 * <p>
 * 문제 풀이
 * 1. a를 2진수 1갯수 기준으로 정렬하는 메서드 만들기
 * 2. 1의 갯수 같으면 10진수로 정렬하도록 하기
 * 3. k번째 위치한 값 찾기
 */
public class _5일차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int K = Integer.parseInt(input1[1]);
        List<Integer> answer = sortCountOnes(input2);

        System.out.println(answer.get(K - 1));
    }

    private static List<Integer> sortCountOnes(String[] input) {
        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.sort((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            }

            int countOne1 = Integer.bitCount(o1);
            int countOne2 = Integer.bitCount(o2);

            if (countOne1 == countOne2) {
                return o2 - o1;
            }

            return countOne2 - countOne1;
        });

        return numbers;
    }
}
