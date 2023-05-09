package src.programmers.level3;

public class _1_정수삼각형 {
    public int solution(int[][] triangle) {

        int row = triangle.length;

        for(int i=row-1; i>0; i--){

            int column = triangle[i].length;

            for(int j=0, k=0; j<column-1; j++, k++){
                triangle[i-1][k] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }

        return triangle[0][0];
    }
}
