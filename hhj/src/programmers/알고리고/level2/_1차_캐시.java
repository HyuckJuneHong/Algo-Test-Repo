package src.programmers.알고리고.level2;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1차_캐시 {
    static int answer = 0;
    static Deque<String> cache = new ArrayDeque<>();

    public static int solution(int cacheSize,
                               String[] cities) {
        if (cacheSize == 0) {
            return cacheSizeZero(cities);
        }

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.isEmpty()) {
                cacheMiss(city);
                continue;
            }

            if (cache.contains(city)) {
                cacheHit(city);
                continue;
            }

            if (cache.size() == cacheSize) {
                cache.poll();
                cacheMiss(city);
                continue;
            }

            cacheMiss(city);
        }

        return answer;
    }

    private static void cacheMiss(String city) {
        answer += 5;
        cache.offer(city);
    }

    private static void cacheHit(String city) {
        cache.remove(city);
        cache.offer(city);
        answer += 1;
    }

    private static int cacheSizeZero(String[] cities) {
        return answer = cities.length * 5;
    }
}
