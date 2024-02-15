package src.문제_풀이_전략._6_이진탐색;

/**
 n : 입국 심사 기다리는 사람 수 (1 ~ 1_000_000_000)
 times : 각 심사관이 한 명을 심사하는데 걸리는 시간 (len=1~100_000, time=1~1_000_000_000)
 return : 모든 사람이 심사를 받는데 걸리는 최소 시간

 1. 특정 시간이 주어졌을 때, 특정 시간동안 최대 심사 횟수를 구한다.
 2. 이진 탐색을 활용해 최대 심사 횟수가 입국 심사 사람 수보다 크면 Down, 같거나 작으면 Up을 반복한다.
 */
public class Lv3_입국심사 {

	class Solution {

		public long solution(int n, int[] times) {
			long start = 0;
			long end = 1_000_000_000_000_000_000L;

			return binarySearch(n, times, start, end);
		}

		private long binarySearch(int n, int[] times, long start, long end) {
			while (start < end) {
				long mid = (start + end) / 2;
				boolean result = isValid(n, times, mid);

				if (result) {
					end = mid;
					continue;
				}

				start = mid + 1;
			}

			return start;
		}

		private boolean isValid(int n, int[] times, long checkTime) {
			long max = 0;

			for (int time : times) {
				max += checkTime / time;
			}

			return max >= n;
		}
	}
}
