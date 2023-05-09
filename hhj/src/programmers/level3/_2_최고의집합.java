package src.programmers.level3;

import java.util.Arrays;

public class _2_최고의집합 {
    public static int[] solution(int n,
                                 int s) {
        if(n > s){
            return new int[]{-1};
        }

        int[] answer = new int[n];

        Arrays.fill(answer, s/n);

        int remain = s%n;

        for(int i=0; i<remain; i++){
            answer[n-i-1] += 1;
        }

        return answer;
    }
}
