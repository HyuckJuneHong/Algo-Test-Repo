package src.programmers.level2;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;

        for (int i = 0; i < number.length() - k; i++) {
            char max = 0;

            for (int j = idx; j <= i + k; j++) {
                char cur = number.charAt(j);

                if (max < cur) {
                    max = cur;
                    idx = j + 1;
                }
            }

            answer.append(max);
        }

        return answer.toString();
    }
}
