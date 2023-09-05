package src.구름톤_챌린지;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _15주차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[] P = new int[N];
		int[] C = new int[N];

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			P[i] = Integer.parseInt(input[0]);
			C[i] = Integer.parseInt(input[1]);
		}

		long answer = getMaxFullness(N, K, P, C);
		System.out.print(answer);
	}

	private static long getMaxFullness(int N, int K, int[] P, int[] C) {
		PriorityQueue<Fruit> pq = new PriorityQueue<>();
		long fullness = 0;

		for (int i = 0; i < N; i++) {
			pq.add(new Fruit(P[i], C[i]));
		}

		for (int i = 0; i < N; i++) {
			Fruit current = pq.poll();

			if (K >= current.p) {
				K -= current.p;
				fullness += current.c;
				continue;
			}

			while (K != 0) {
				K--;
				fullness += current.piece;
			}

			break;
		}

		return fullness;
	}

	public static class Fruit implements Comparable<Fruit> {
		int p;
		int c;
		int piece;

		public Fruit(int p, int c) {
			this.p = p;
			this.c = c;
			this.piece = c / p;
		}

		@Override
		public int compareTo(Fruit o) {
			if (this.piece == o.piece) {
				return o.c - this.c;
			}

			return o.piece - this.piece;
		}

		@Override
		public String toString() {
			return "Fruit{p : " + p
				+ " c : " + c
				+ " Piece : " + piece
				+ "}\n";
		}
	}
}
