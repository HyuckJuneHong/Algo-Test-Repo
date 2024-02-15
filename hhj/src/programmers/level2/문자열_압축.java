package src.programmers.level2;

public class 문자열_압축 {

    static int answer;

    public int solution(String s) {
        answer = s.length();

        for (int i = 1; i < s.length() / 2 + 1; i++) {
            compress(s, i);
        }

        return answer;
    }

    private void compress(String s, int n) {
        StringBuilder sb = new StringBuilder();
        String start = s.substring(0, n);
        String end;
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
        end = s.substring(index);

        if (!end.isBlank()) {
            sb.append(end);
        }

        answer = Math.min(answer, sb.toString().length());
    }
}
