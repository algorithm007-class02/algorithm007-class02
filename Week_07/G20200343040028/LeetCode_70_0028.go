package G20200343040028

import "math"

func climbStairs(n int) int {
	sqrt5 := math.Sqrt(5)
	fibN := math.Pow((1+sqrt5)/2, float64(n+1)) - math.Pow((1-sqrt5)/2, float64(n+1))
	return int(math.Round(fibN / sqrt5))

}