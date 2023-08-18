package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 합 계산기 : 여러 개의 계산식을 입력 받은 뒤, 각 계산 결과를 모두 합해 출력하는 기능
 * <p>
 * 조건
 * - <정수> <연산기호> <정수> 형태
 * - <연산기호> : +, -, *, /
 * - 나눗셈 결과의 나머지는 버린다.
 * - 계산식 갯수 : 1~100
 * - 정수 : 1~1000
 * <p>
 * 입력
 * - T : 계산식 갯수
 * - formulas : 계산식
 */
public class _3일차 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] formulas = new String[T];
        int answer;

        for (int i = 0; i < T; i++) {
            formulas[i] = br.readLine();
        }

        answer = process(T, formulas);
        System.out.println(answer);
    }

    private static int process(int T, String[] formulas) {
        int result = 0;

        for (int i = 0; i < T; i++) {
            String[] formula = formulas[i].split(" ");
            result += calculate(formula);
        }

        return result;
    }

    private static int calculate(String[] formula) {
        int firstNumber = Integer.parseInt(formula[0]);
        int secondNumber = Integer.parseInt(formula[2]);

        if (formula[1].equals("+")) {
            return firstNumber + secondNumber;
        }

        if (formula[1].equals("-")) {
            return firstNumber - secondNumber;
        }

        if (formula[1].equals("*")) {
            return firstNumber * secondNumber;
        }

        return firstNumber / secondNumber;
    }
}
