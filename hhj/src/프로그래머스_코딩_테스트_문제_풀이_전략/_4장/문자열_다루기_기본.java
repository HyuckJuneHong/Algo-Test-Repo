package src.프로그래머스_코딩_테스트_문제_풀이_전략._4장;

import java.util.regex.Pattern;

public class 문자열_다루기_기본 {
    static final Pattern IS_NUMBERS = Pattern.compile("^[0-9]{4}|[0-9]{6}$");

    public boolean solution(String s) {
        return IS_NUMBERS.matcher(s).matches();
    }
}
