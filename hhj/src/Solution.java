package src;

public class Solution {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abc");
		String a = sb.substring(1, sb.length() - 1);
		System.out.println(a);

		if (a.isBlank()) {
			System.out.println("Blank");
		}
	}

	public static class A implements Comparable<A> {
		int a;
		int b;

		public A(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(A o) {
			return 0;
		}

		@Override
		public String toString() {
			return "A{" +
				"a=" + a +
				", b=" + b +
				'}';
		}
	}
}
