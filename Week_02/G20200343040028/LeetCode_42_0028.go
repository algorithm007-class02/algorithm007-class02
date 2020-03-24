package G20200343040028

import (
	"math"
)

func trap(height []int) int {
	ans, l, r, maxLeft, maxRight := 0, 0, len(height)-1, 0, 0
	for ; l < r; {
		if height[l] < height[r] {
			if maxLeft < height[l] {
				maxLeft = height[l]
			} else {
				ans += maxLeft - height[l]
			}
			l++
		} else {
			if maxRight < height[r] {
				maxRight = height[r]
			} else {
				ans += maxRight - height[r]
			}
			r--
		}
	}
	return ans
}
func trap3(height []int) int {
	size := len(height)
	ans, l, r, maxLeft, maxRight := 0, 0, size-1, 0, 0
	if size < 3 {
		return ans
	}
	for ; l < r; {
		maxLeft = max(maxLeft, height[l])
		if maxLeft > height[l] {
			ans += maxLeft - height[l]
		}
		maxRight = max(maxRight, height[r])
		if maxRight > height[r] {
			ans += maxRight - height[r]
		}
		if height[l] < height[r] {
			l++
		} else {
			r--
		}
	}
	return ans
}
func trap2(height []int) int {
	ans := 0
	size := len(height)
	if size < 3 {
		return ans
	}
	maxLeft := make([]int, size, size)
	maxRight := make([]int, size, size)
	maxLeft[0] = height[0]
	for i := 1; i < size; i++ {
		maxLeft[i] = max(height[i], maxLeft[i-1])
	}
	maxRight[size-1] = height[size-1]
	for i := size - 2; i >= 0; i-- {
		maxRight[i] = max(height[i], maxRight[i+1])
	}
	for i := 1; i < size-1; i++ {
		ans += min(maxLeft[i], maxRight[i]) - height[i]
	}
	return ans
}

func max(x, y int) int {
	return int(math.Max(float64(x), float64(y)))
}
func min(x, y int) int {
	return int(math.Min(float64(x), float64(y)))
}
func trap1(height []int) int {
	//fmt.Printf("height:%v\n", height)
	ans := 0
	size := len(height)
	for i := 1; i < size-1; i++ {
		//fmt.Printf("i:%v\t", i)
		//fmt.Printf("height[j]:%v\t", height[i])
		maxLeft, maxRight := 0, 0
		for j := i; j >= 0; j-- { //Search the left part for max bar size
			maxLeft = int(math.Max(float64(maxLeft), float64(height[j])))
		}
		//fmt.Printf("maxLeft:%v\t", maxLeft)
		for j := i; j < size; j++ { //Search the right part for max bar size
			maxRight = int(math.Max(float64(maxRight), float64(height[j])))
		}
		//fmt.Printf("maxRight:%v\t", maxRight)
		a := int(math.Min(float64(maxLeft), float64(maxRight))) - height[i]
		//fmt.Printf("a:%v\n", a)
		ans += a
	}
	return ans
}
