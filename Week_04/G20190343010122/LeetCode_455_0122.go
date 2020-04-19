package homework

import "sort"

func findContentChildren(g []int, s []int) int {
	children := 0
	sort.Ints(g)
	sort.Ints(s)
	for _, cookie := range s {
		if g[children] <= cookie {
			children++
			if children > len(g) -1 {
				return children
			}
		}

	}

	return children
}