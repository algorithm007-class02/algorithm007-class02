package homework

func lemonadeChange(bills []int) bool {
	five := 0
	ten := 0
	for _, v := range bills{
		switch v {
		case 5:
			five++
			break
		case 10:
			ten++
			five--
			break
		case 20:
			if ten != 0{
				ten--
				five--
			}else{
				five -=3
			}
		}

		if five <0{
			return false
		}
	}

	return true
}
