package src.programmers.level2;

public class _2개_이하로_다른_비트 {
    public long[] solution(long[] numbers) {
        int size = numbers.length;
        long[] answer = new long[size];

        for (int i = 0; i < size; i++) {
            long current = numbers[i];

            if (current % 2 == 0) {
                answer[i] = current + 1;
                continue;
            }

            answer[i] = func(current);
        }

        return answer;
    }

    private Long func(long current) {
        String bit = Long.toBinaryString(current);
        int index = bit.lastIndexOf("0");

        if (index == -1) {
            bit = "10" + bit.substring(1);
        } else {
            bit = bit.substring(0, index) + "10" + bit.substring(index + 2);
        }

        return Long.parseLong(bit, 2);
    }
}
