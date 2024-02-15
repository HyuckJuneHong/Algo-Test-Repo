package src.programmers.level2;

public class 주식가격 {
    /**
     *
     */
    public static int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                answer[i] += 1;

                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }
}
