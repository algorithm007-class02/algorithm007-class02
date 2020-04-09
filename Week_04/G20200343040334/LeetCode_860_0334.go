package G20200343040334

func lemonadeChange(bills []int) bool {
	five, ten := 0, 0
	for _, bill := range bills {
		if bill == 5 {
			five++
		} else if bill == 10 {
			if five >= 1 {
				five--
				ten++
			} else {
				return false
			}
		} else if bill == 10 {
			if five >= 3 {
				five -= 3
			} else if ten >= 1 && five >= 1 {
				ten--
				five--
			} else {
				return false
			}
		}
	}
	return true
}
