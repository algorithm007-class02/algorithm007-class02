package main

import "fmt"

func main() {
	n := 3
	//fmt.Scan(&n)
	num1, num2 := 0, 1
	for i := 2; i <= n; i++ {
		//num1 = num2
		//num2 = num1+num2
		num2, num1 = num1+num2, num2
	}
	fmt.Println(num2)
	fmt.Println(fib(n))
}
func fib(n int) int {
	if n==0 ||n==1{
		return n
	}
	var (
		a=0
		b=1
		temp int
	)
	for i:=2;i<=n;i++{
		temp = b
		b = (a + b)%1000000007
		a = temp
	}
	return b
}