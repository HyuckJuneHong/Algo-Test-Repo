package src;

public class Solution {
	public static void main(String[] args) {
		String a = "ab";
		System.out.println(a + a);
	}

	public static class O1 {
		int x;
		int y;

		@Override
		public String toString() {
			return "O1{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
}
