package src.프로그래머스.PCCP.모의고사_2회;

public class No1_실습용_로봇 {

	private static final String[] DIRECTION = {"UP", "RIGHT", "DOWN", "LEFT"};

	public int[] solution(String command) {
		Robot answer = new Robot(0, 0, 0);

		for (char c : command.toCharArray()) {
			answer.move(c);
		}

		return answer.location();
	}

	private class Robot {
		private int x;
		private int y;
		private int direction;

		public Robot(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		@Override
		public String toString() {
			return x + "," + y + "," + DIRECTION[direction];
		}

		public int[] location() {
			return new int[] {x, y};
		}

		public void move(char command) {
			if (command == 'R') {
				this.direction = (this.direction + 1) % 4;
				return;
			}

			if (command == 'L') {
				this.direction = this.direction == 0 ? 3 : (this.direction - 1);
				return;
			}

			if (command == 'G') {
				move(1);
				return;
			}

			move(-1);
		}

		private void move(int value) {
			if (this.direction == 0) {
				this.y += value;
				return;
			}

			if (this.direction == 1) {
				this.x += value;
				return;
			}

			if (this.direction == 2) {
				this.y -= value;
				return;
			}

			this.x -= value;
		}
	}
}
