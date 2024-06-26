package src;

public class Solution {
	public static void main(String[] args) {
		A b = new B();

		b.paint();
		b.draw();
	}

	private static class A {
		public void paint() {
			System.out.println("A");
			draw();
		}

		public void draw() {
			System.out.println("B");
			draw();
		}
	}

	private static class B extends A {

		@Override
		public void paint() {
			super.draw();
			System.out.println("C");
			this.draw();
		}

		@Override
		public void draw() {
			System.out.println("D");
		}
	}
}
