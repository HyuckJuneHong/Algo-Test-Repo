package src.인프런.DP;

public class 계단오르기 {

	static int input = 7;
	static int output = 21;

	static int[] dy = new int[input + 1];

	public static void main(String[] args) {

		dy[1] = 1;
		dy[2] = 2;

		for (int i = 3; i <= input; i++) {
			dy[i] = dy[i - 2] + dy[i - 1];
		}

		System.out.println(dy[input]);
	}
}
