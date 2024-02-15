package src.프로그래머스.level2;

public class 숫자_카드_나누기 {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = getGCD(gcdA, arrayA[i]);
            gcdB = getGCD(gcdB, arrayB[i]);
        }

        answer = isDivision(gcdB, arrayA) ? answer : gcdB;
        answer = isDivision(gcdA, arrayB) ? answer : Math.max(answer, gcdA);

        return answer;
    }

    public boolean isDivision(int gcd, int[] array) {
        for (int a : array) {
            if (a % gcd == 0) {
                return true;
            }
        }

        return false;
    }

    public int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
