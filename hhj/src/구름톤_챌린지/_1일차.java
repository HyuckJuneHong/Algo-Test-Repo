package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1일차 {
    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");
        final int W = Integer.parseInt(input[0]);
        final int R = Integer.parseInt(input[1]);
        final int result = measure(W, R);

        System.out.println(result);
    }

    private static int measure(int W, int R) {
        return (int) (W * (1 + R / 30.0));
    }
}
