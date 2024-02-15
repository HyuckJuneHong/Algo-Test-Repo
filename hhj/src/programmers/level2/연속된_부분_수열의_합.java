package src.programmers.level2;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int sum = 0, size = sequence.length;
        int lt = 0, rt = 0;
        int left = 0, right = size - 1;

        while (lt < size) {
            while (sum < k && rt < size) {
                sum += sequence[rt++];
            }

            if (sum == k && rt - lt - 1 < right - left) {
                left = lt;
                right = rt - 1;
            }

            sum -= sequence[lt++];
        }

        return new int[]{left, right};
    }
}
