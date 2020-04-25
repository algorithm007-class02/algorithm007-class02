package week_04;

public class lc_860_lemonadeChange {

	public boolean lemonadeChange(int[] bills) {
		if (bills == null || bills.length == 0)
			return true;

		int five = 0, ten = 0;

		for (int bill : bills) {
			if (bill == 5) {
				five++;
			} else if (bill == 10) {
				if (five == 0)
					return false;
				five--;
				ten++;
			} else {
				if (five > 0 && ten > 0) {
					five--;
					ten--;
				} else if (five >= 3) {
					five -= 3;
				} else {
					return false;
				}
			}
		}

		return true;

	}

}
