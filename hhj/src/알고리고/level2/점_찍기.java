package src.알고리고.level2;

public class 점_찍기 {

    public long solution(int k, int d) {
        long answer = 0;
        long lk = (long) k;
        long ld = (long) d;

        for (long a = 0; a <= ld; a += lk) {
            long max = (long) Math.sqrt(ld * ld - a * a);
            answer += max / lk + 1;
        }

        return answer;
    }

//     public long solution(int k, int d) {
//         long answer = 0;
//         long lk = (long) k;
//         long ld = (long) d;

//         for (long a = 0; a <= ld; a += lk) {
//             for (long b = a; b <= ld; b += lk) {
//                 if (isDistance(a, b, ld)) {
//                     answer = a == b ? answer + 1 : answer + 2;
//                 }
//             }
//         }

//         return answer;
//     }

//     public boolean isDistance(long a, long b, long d) {
//         return d * d >= a * a + b * b;
//     }
}
