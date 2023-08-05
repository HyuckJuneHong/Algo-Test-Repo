package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class 문자열_압축 {
    static int answer;

    public int solution(String s) {
        answer = s.length();

        for (int i = 1; i < s.length(); i++) {
            compress(s, i);
        }

        return answer;
    }

    private void compress(String s, int n) {
        StringBuilder sb = new StringBuilder();
        String start = s.substring(0, n);
        String copy;
        int count = 0;
        int index = 0;

        while (index + n <= s.length()) {
            String current = s.substring(index, index + n);
            index += n;

            if (start.equals(current)) {
                count++;
                continue;
            }

            if (count != 1) {
                sb.append(count);
            }

            sb.append(start);
            start = current;
            count = 1;
        }

        if (count != 1) {
            sb.append(count);
        }

        sb.append(start);
        copy = s.substring(index);

        if (!copy.isBlank()) {
            sb.append(copy);
        }

        answer = Math.min(answer, sb.toString().length());
    }
}
