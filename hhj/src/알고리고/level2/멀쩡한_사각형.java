package src.알고리고.level2;

public class 멀쩡한_사각형 {
    public long solution(int w, int h) {
        long y = 0;

        for (long x = 1; x < w; x++) {
            y += (long) (h * x / w);
        }

        return y * 2;
    }
}
