package week_03;

import java.util.HashSet;
import java.util.PriorityQueue;

public class lc_49_nthUglyNumber {

	public int nthUglyNumber_01(int n) {
		int a = 0, b = 0, c = 0;

		int[] dp = new int[n];
		dp[0] = 1;

		for (int i = 1; i < n; i++) {
			int n2 = dp[a] * 2;
			int n3 = dp[b] * 3;
			int n5 = dp[c] * 5;

			dp[i] = Math.min(Math.min(n2, n3), n5);

			if (dp[i] == n2)
				a++;
			if (dp[i] == n3)
				b++;
			if (dp[i] == n5)
				c++;
		}

		return dp[n - 1];
	}

	public int nthUglyNumber_02(int n) {

		if (n == 1)
			return n;

		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add(1L);

		for (int i = 1; i < n; i++) {
			long t = q.poll();

			while (!q.isEmpty() && q.peek() == t) {
				t = q.poll();
			}

			q.add(t * 2);
			q.add(t * 3);
			q.add(t * 5);

		}

		return q.poll().intValue();

	}

	public int nthUglyNumber_03(int n) {

		if (n == 1)
			return n;

		HashSet<Long> set = new HashSet<>();
		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add(1L);
		set.add(1L);

		int[] result = new int[n];
		int[] factory = new int[] { 2, 3, 5 };

		for (int i = 0; i < n; i++) {
			long cu = q.poll();
			result[i] = (int) cu;

			for (int f : factory) {
				long nu = cu * f;
				if (!set.contains(nu)) {
					set.add(nu);
					q.add(nu);
				}
			}
		}

		return result[n - 1];
	}
}
