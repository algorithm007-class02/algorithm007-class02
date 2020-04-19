package main

import "fmt"

/**
	canlist = ["apple", "pear", "bakery"] // can be a, e
	cantlist = ["egg", "pork"] // cannot e,g,p,o,r,k
 */
func main() {
	canlist := []string{"apple", "pear", "bakery"}
	cantlist := []string{"egg", "pork"}

	canMap := make(map[int32]int)
	for index, v := range canlist{
		for _, char := range v {
			if index == 0 || (index >0 && canMap[char] == index-1) {
				canMap[char] = index
			}
		}
	}
	for _, v := range cantlist{
		for _, char := range v {
			if _,ok := canMap[char]; ok{
				canMap[char] = 0
			}
		}
	}
	for k, v := range canMap{
		if v == 2{
			fmt.Println(k)
		}
	}
}



