package src.프로그래머스.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제
 * - 주어진 +, -, * 연산자에 우선순위를 줘서 가장 큰 금액 찾기 (절대값)
 * <p>
 * 제한사항
 * - expression : 3~100
 * <p>
 * 풀이
 * 1. 연산자 우선순위를 미리 만들어보자.
 * 1. 연산자를 포함해 분리하자.
 * 2. 분리한 필드를 리스트에 담자.
 * 3. 정해진 우선순위에 따라 해당 식을 계산한 값으로 교체하자. (복사본 리스트가 있어야할 것 같음)
 * 4. 그리고 우선순위에 따라 계산한 값을 비교하자.
 */
public class 수식최대화 {

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
