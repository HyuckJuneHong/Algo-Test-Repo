package src.알고리고.level2;

public class _3차_n진수_게임 {
    public static void main(String[] args) {
        solution(2, 4, 2, 1);
    }

    public static String solution(int n,
                                  int t,
                                  int m,
                                  int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder totalBaseNumber = new StringBuilder();

        int size = t * m;
        int index = 0;

        while (totalBaseNumber.toString().length() < size) {
            totalBaseNumber.append(toNBase(index++, n));
        }

        String totalNumber = totalBaseNumber.toString();

        for (int i = 0; i < t; i++) {
            answer.append(totalNumber.charAt(i * m + p - 1));
        }

        return answer.toString();
    }

    private static String toNBase(int number,
                                  int n) {
        if (number == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            int remain = number % n;
            number /= n;

            if (remain < 10) {
                sb.append(remain);
                continue;
            }

            sb.append((char) ('A' + remain - 10));
        }

        return sb.reverse()
                .toString();
    }
}
