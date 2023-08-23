package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제 설명
 * - 통증 시스템; 통증 수치가 높으면 승리 어려움
 * - 아이템을 사용해 0으로 유지하기
 * - 통증 수치 감소 아이템; 각 아이템 원하는 만큼 획득 가능
 * - bandage : 1
 * - medicine : 7
 * - painkiller : 14
 * - 현재 N의 통증 수치 가짐
 * - 0으로 줄이기 위한 아이템 최소 갯수; 단 0보다 작아지는 아이템 사용 불가
 * <p>
 * 입력
 * - N : 통증 수치 (1~10^9)
 */
public class _8주차 {
    static final int[] ITEM = {14, 7, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = getMinCount(N);

        System.out.print(answer);
    }

    private static int getMinCount(int N) {
        int count = 0;
        int index = 0;

        while (N > 0) {
            int next = ITEM[index];

            if (N < next) {
                index = (index + 1) % 3;
                continue;
            }

            N -= next;
            count++;
        }

        return count;
    }
}
