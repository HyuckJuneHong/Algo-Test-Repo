package src.알고리고.문제_풀이_전략._6_이진탐색;

public class Lv3_입국심사 {

	public long solution(int n, int[] times) {
		long start = 0;
		long end = 1_000_000_000_000_000_000L;

		return binarySearch(n, times, start, end);
	}

	private long binarySearch(int n, int[] times, long start, long end) {
		while (start < end) {
			long mid = (start + end) / 2;

			if (isValid(n, times, mid)) {
				end = mid;
				continue;
			}

			start = mid + 1;
		}

		return start;
	}

	private boolean isValid(int n, int[] times, long checkTime) {
		long totalTime = 0;

		for (int time : times) {
			totalTime += checkTime / time;
		}

		return totalTime >= n;
	}
}
