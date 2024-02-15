package src.programmers.level2;

class 타겟_넘버_이근우 {

    /*
        문제 풀이 흐름
        1. 완전탐색이 가능한지 검증 -> O(2^20) 으로 가능
        2. numbers 배열 앞에 연산기호를 삽입한다는 생각으로, 연산기호를 붙이고 기존의 누적 연산값과 합침
        3. numbers 의 모든 원소를 순회하면, 최종 누적 연산값이 target 이면 경우의 수 증가, 아니면 종료

        시간 복잡도
        O(2^20)
    */
    private static final String[] OPERATOR = {"+", "-"};

    private int result;

    public int solution(int[] numbers, int target) {
        calculate(0, numbers, 0, target);
        return result;
    }

    public void calculate(int depth, int[] numbers, int number, int target) {
        if (depth == numbers.length) {
            if (target == number) {
                result++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            int sub = calculate(OPERATOR[i], numbers, depth, number);
            calculate(depth + 1, numbers, sub, target);
        }
    }

    public int calculate(String operator, int[] numbers, int depth, int number) {
        if (operator.equals(OPERATOR[0])) {
            return number + numbers[depth];
        }

        if (operator.equals(OPERATOR[1])) {
            return number - numbers[depth];
        }

        return 0;
    }
}
