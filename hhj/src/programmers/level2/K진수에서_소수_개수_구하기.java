package src.programmers.level2;

import java.util.StringTokenizer;

public class K진수에서_소수_개수_구하기 {
    public static int solution(int n, int k) {
        int answer = 0;
        String np = toNPrime(n, k);
        StringTokenizer st = new StringTokenizer(np, "0");

        while (st.hasMoreTokens()) {
            answer += isPrime(Long.parseLong(st.nextToken()));
        }

        return answer;
    }

    private static int isPrime(Long np) {
        long mid = (long) Math.sqrt(np);

        if(np < 2){
            return 0;
        }

        for (long i = 2; i <= mid; i++) {
            if (np % i == 0){
                return 0;
            }
        }

        return 1;
    }

    private static String toNPrime(int n, int k) {
        if (n == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(110011, 10));
        System.out.println(solution(437674, 3));
    }
}
