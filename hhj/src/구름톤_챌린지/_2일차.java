package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N개의 기능 개발 추가로 필요
 * - 각 기능에 1~N번까지 번호 할당
 * - i번째 기능을 개발하는 데의 Ci 분의 시간이 걸림
 * <p>
 * 플레이어가 철야 작업에 들어감
 * - 철야 시작 : T시 M분
 * - 플레이어는 1번 기능부터 순서대로 개발 진행
 * - 한 기능 개발 끝날 시 바로 다음 기능 개발 시작
 * <p>
 * 플레이어가 모든 기능 개발 끝난 시각 구하기
 */
public class _2일차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] time = br.readLine().split(" ");
        int T = Integer.parseInt(time[0]);
        int M = Integer.parseInt(time[1]);
        int[] C = new int[N];

        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = finishProject(N, T, M, C);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static int[] finishProject(int N, int T, int M, int[] C) {
        int totalM = 0;
        int[] time;

        for (int i = 0; i < N; i++) {
            totalM += C[i];
        }

        time = new int[]{totalM / 60, totalM % 60};
        T = (M + time[1]) >= 60 ? (T + time[0] + 1) % 24 : (T + time[0]) % 24;
        M = (M + time[1]) % 60;

        return new int[]{T, M};
    }
}
