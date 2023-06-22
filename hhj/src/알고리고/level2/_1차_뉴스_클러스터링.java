package src.알고리고.level2;

import java.util.*;

/**
 * - 자카드 유사도 방법
 * - 집합 간의 유사도를 검사하는 방법 중 하나
 * - 두 집합 A, B 사이의 자카드 유사도 : J(A, B) = 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값
 * - Ex) A={1, 2, 3} / B={2, 3, 4} -> 2/4 = 0.5
 * - Ex) 두 집합 모두 공집합일 경우 = 1
 * - Ex) A={1, 1, 1} / B={1, 1, 1, 1, 1} -> 3/5
 * - Ex) A={1,1,2,2,3} / B={1,2,2,4,5} -> 3/7
 * - 입력 조건
 * - 두 문자열 : str1, str2
 * - 길이 : 2~1000
 * - 문자열은 두 글자씩 끊어서 다중집합 원소로 생성
 * - 공백, 숫자, 특수문자가 들어있다면 삭제.
 * - 대소문자 구분 X
 * - 출력 조건
 * - 65536를 곱한 후 소수점 아래를 버리고 정수만 출력
 */
class _1차_뉴스_클러스터링 {

    static List<String> strs1 = new ArrayList<>();
    static List<String> strs2 = new ArrayList<>();

    public static int solution(String str1,
                               String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        strs1 = addList(str1);
        strs2 = addList(str2);
        double intersection = func();
        double union = strs1.size() + strs2.size();

        return union == 0 && intersection == 0 ? 65536 : (int) (intersection / union * 65536);
    }

    private static List<String> addList(String str) {
        List<String> strs = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.charAt(i) + "" + str.charAt(i + 1);

            if (s.matches("[a-z]+")) {
                strs.add(s);
            }
        }

        return strs;
    }

    private static double func() {
        double intersection = 0;

        for (String s : strs1) {
            if (strs2.contains(s)) {
                intersection++;
                strs2.remove(s);
            }
        }

        return intersection;
    }
}

