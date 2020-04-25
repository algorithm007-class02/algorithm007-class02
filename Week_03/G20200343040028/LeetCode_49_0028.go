package G20200343040028

import (
	"container/heap"
	"math"
)

func nthUglyNumber(n int) int {
	uglyNum := -1 // 首先把丑数初始化为一个不合法的值-1
	var h IntHeap // 然后定义最小堆
	heap.Init(&h)
	heap.Push(&h, 1) // 并且把第一个丑数1，加入到最小堆中
	for n > 0 {      // 当n大于0时执行以下操作
		for h[0] == uglyNum { // 检查堆顶元素是否等于上一个丑数
			heap.Pop(&h) // 如果是就不断丢弃
		} // 这一步的作用是去重
		// 直到不重复就取出堆顶元素,把它作为新的丑数
		uglyNum = heap.Pop(&h).(int)
		// 接着把当前丑数乘以2,3,5后的候选值，加入最小堆中
		// 由于候选集合增长非常快，有可能在还没有求出第n个丑数时，
		// 就已经超出了整数最大值，于是这里使用整数的最大值进行约束
		if 2*uglyNum <= math.MaxInt32 { heap.Push(&h, 2*uglyNum) }
		if 3*uglyNum <= math.MaxInt32 { heap.Push(&h, 3*uglyNum) }
		if 5*uglyNum <= math.MaxInt32 { heap.Push(&h, 5*uglyNum) }
		n-- // 计算出一个新的丑数后n要减一
	}
	// 循环结束后返回记录着的丑数即可
	return uglyNum
}

type IntHeap []int

func (h IntHeap) Len() int            { return len(h) }
func (h IntHeap) Less(i, j int) bool  { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) { *h = append(*h, x.(int)) }
func (h *IntHeap) Pop() interface{} {
	res := (*h)[len(*h)-1]
	*h = (*h)[:len(*h)-1]
	return res
}
