package src.알고리고.level2;

public class 호텔_대실 {

    static final int H = 24;
    static final int M = 60;
    static final int A = 10;

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] day = new int[H * M + A];

        for (String[] book : book_time) {
            int start = getTime(book[0]);
            int end = getTime(book[1]) + A;
            day[start] += 1;
            day[end] -= 1;
        }

        for (int i = 1; i < day.length; i++) {
            day[i] += day[i - 1];

            if (answer < day[i]) {
                answer = day[i];
            }
        }

        return answer;
    }

    public int getTime(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]) * M;
        int m = Integer.parseInt(t[1]);

        return h + m;
    }
}
