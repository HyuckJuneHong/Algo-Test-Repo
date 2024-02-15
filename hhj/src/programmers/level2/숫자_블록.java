package src.programmers.level2;

public class 숫자_블록 {

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                answer[(int) (i - begin)] = 0;
                continue;
            }

            answer[(int) (i - begin)] = getMaxDiv(i);
        }

        return answer;
    }

    public int getMaxDiv(long n) {
        double mid = Math.sqrt(n);
        int result = 1;

        for (long i = 2; i <= mid; i++) {
            if (n % i == 0) {
                if (n / i <= 10_000_000) {
                    return (int) (n / i);
                }

                result = (int) i;
            }
        }

        return result;
    }
}
