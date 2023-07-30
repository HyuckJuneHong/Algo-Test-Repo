package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        return new StringBuilder(Long.toString(n))
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
