package week_03;

import java.util.ArrayList;
import java.util.List;

public class lc_22_generateParenthesis {

	public List<String> generateParenthesis(int n) {

		List<String> ret = new ArrayList<String>();
		recur(0, 0, n, "", ret);

		return ret;
	}

	private void recur(int left, int rigth, int n, String s, List<String> result) {
		if (left == n && rigth == n) {
			result.add(s);
			return;
		}
		
		if (left < n) recur(left +1, rigth, n, s + "(", result);

		if (rigth < left) recur(left, rigth + 1, n, s + ")", result);
	}

	public static void main(String[] args) {
		lc_22_generateParenthesis sol = new lc_22_generateParenthesis();
		System.out.println(sol.generateParenthesis(3));
	}
}
