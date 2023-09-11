package src.알고리고.level2;

import java.util.ArrayList;
import java.util.List;

public class 호텔_대실 {

	static int TIME = 24 * 60 + 10;
	static int H = 60;
	static int M = 10;

	public int solution(
		String[][] book_time    // 예약 시간 [시작, 종료] ["HH:MM", "HH:MM"] 형태로 담김 (1~1_000)
	) {
		List<Time> list = new ArrayList<>();
		int[] room = new int[TIME];
		String[] start;
		String[] end;
		int answer = 0;

		for (int i = 0; i < book_time.length; i++) {
			start = book_time[i][0].split(":");
			end = book_time[i][1].split(":");
			list.add(new Time(start, end));
		}

		for (Time t : list) {
			room[t.sh * H + t.sm] += 1;
			room[t.eh * H + t.em + M] -= 1;
		}

		for (int i = 1; i < TIME; i++) {
			room[i] += room[i - 1];
			answer = Math.max(answer, room[i]);
		}

		return answer;
	}

	public static class Time {
		int sh;
		int sm;
		int eh;
		int em;

		public Time(String[] start, String[] end) {
			this.sh = Integer.parseInt(start[0]);
			this.sm = Integer.parseInt(start[1]);
			this.eh = Integer.parseInt(end[0]);
			this.em = Integer.parseInt(end[1]);
		}
	}
}
