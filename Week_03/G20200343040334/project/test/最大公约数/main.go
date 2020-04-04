package main

import "fmt"

func main() {
	
	fmt.Println(hasGroupsSizeX([]int{2,2,3,3}))
}

func hasGroupsSizeX(nums []int) bool {
	gcd := func(a,b int) int{
		for a!=b{
			if a >b{
				a -=b
			}else{
				b-=a
			}
		}
		return a
	}

	countmap := make(map[int]int, len(nums))
	for _,v := range nums{
		countmap[v] ++
	}
	g := -1
	for _,v := range countmap{
		if g == -1{
			g = v
		}else {
			g = gcd(v, g)
		}
	}
	return g>=2
}
