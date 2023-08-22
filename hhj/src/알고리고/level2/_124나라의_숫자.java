package src.알고리고.level2;

public class _124나라의_숫자 {
    static final String[] NUMBER = {"4", "1", "2"};

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n != 0) {
            int index = n % 3;
            answer.append(NUMBER[index]);
            n = index == 0 ? n / 3 - 1 : n / 3;
        }

        return answer.reverse().toString();
    }
}
