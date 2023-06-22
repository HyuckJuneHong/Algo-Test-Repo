package src.programmers.알고리고.level2;

public class 타겟_넘버 {
    static int answer = 0;

    public static int solution(int[] numbers,
                               int target){
        dfs(numbers, target, 0, 0);
        return answer;
    }

    private static void dfs(int[] numbers,
                            int target,
                            int sum,
                            int depth){

        if(depth == numbers.length){

            if(sum == target){
                answer++;
            }

            return;
        }

        dfs(numbers, target, sum+numbers[depth], depth+1);
        dfs(numbers, target, sum-numbers[depth], depth+1);
    }
}
