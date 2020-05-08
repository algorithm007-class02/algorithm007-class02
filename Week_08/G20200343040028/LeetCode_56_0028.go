package G20200343040028

import (
	"sort"
)
func merge(intervals [][]int) [][]int {
	if len(intervals) <= 0 {
		return nil
	}

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	merged := [][]int{}
	merged = append(merged, intervals[0])

	for i := 1; i < len(intervals); i++ {
		m := merged[len(merged)-1]
		c := intervals[i]

		if c[0] > m[1] {
			merged = append(merged, c)
			continue
		}

		if c[1] > m[1] {
			m[1] = c[1]
		}
	}

	return merged
}