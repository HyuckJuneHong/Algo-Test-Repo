package src.프로그래머스_코딩_테스트_문제_풀이_전략._6장;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수식_최대화 {

    static final String[][] PRIORITY = {
            {"*", "+", "-"},
            {"*", "-", "+"},
            {"-", "*", "+"},
            {"-", "+", "*"},
            {"+", "*", "-"},
            {"+", "-", "*"},
    };

    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "*-+", true);
        List<String> formula = new ArrayList<>();
        long answer = 0;

        while (st.hasMoreTokens()) {
            formula.add(st.nextToken());
        }

        for (int i = 0; i < PRIORITY.length; i++) {
            List<String> copyFormula = new ArrayList<>(formula);

            for (int j = 0; j < PRIORITY[0].length; j++) {
                for (int k = 0; k < copyFormula.size(); k++) {
                    if (copyFormula.get(k).equals(PRIORITY[i][j])) {
                        long num1 = Long.parseLong(copyFormula.get(k - 1));
                        String op = copyFormula.get(k);
                        long num2 = Long.parseLong(copyFormula.get(k + 1));
                        copyFormula.remove(k);
                        copyFormula.remove(k);
                        copyFormula.set(k - 1, calculate(num1, op, num2));
                        k--;
                    }
                }
            }

            long result = Math.abs(Long.parseLong(copyFormula.get(0)));

            if (result > answer) {
                answer = result;
            }
        }

        return answer;
    }

    private String calculate(long num1, String op, long num2) {
        if (op.equals("+")) {
            return String.valueOf(num1 + num2);
        }

        if (op.equals("-")) {
            return String.valueOf(num1 - num2);
        }

        return String.valueOf(num1 * num2);
    }
}
