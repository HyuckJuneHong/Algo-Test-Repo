package src.programmers.level2;

import java.util.HashMap;
import java.util.Map;

class 할인행사 {
    /**
     * 일정 금액 지불 시 10일 동안 회원 자격 부여
     * 회원 대상으로 매일 1가지 제품 할인 행사
     * 할인 제품 하루 한개 구매 가능.
     * <p>
     * 정현이가 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우 회원가입 진행
     *
     * @param want     : 원하는 제품 배열
     * @param number   : 원하는 제품 수량 배열
     * @param discount : 마트 할인 제품 배열
     * @return : 원하는 제품을 모두 할인받을 수 있는 회원 등록 날짜의 총 일수
     */
    public static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> discountProduct = new HashMap<>();
        Map<String, Integer> wantProduct = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            wantProduct.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            discountProduct.put(discount[i], discountProduct.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 10; i < discount.length; i++) {
            if (isDiscount(discountProduct, wantProduct)) {
                answer++;
            }

            discountProduct.put(discount[i - 10], discountProduct.getOrDefault(discount[i - 10], 0) - 1);

            if (discountProduct.get(discount[i - 10]) == 0) {
                discountProduct.remove(discount[i - 10]);
            }

            discountProduct.put(discount[i], discountProduct.getOrDefault(discount[i], 0) + 1);
        }

        if (isDiscount(discountProduct, wantProduct)) {
            answer++;
        }

        return answer;
    }

    public static boolean isDiscount(Map<String, Integer> discountProduct, Map<String, Integer> wantProduct) {

        for (String product : wantProduct.keySet()) {

            if (!discountProduct.containsKey(product)) {
                return false;
            }

            if (!discountProduct.get(product).equals(wantProduct.get(product))) {
                return false;
            }
        }

        return true;
    }
}
