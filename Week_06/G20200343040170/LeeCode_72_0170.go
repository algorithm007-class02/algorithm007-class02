func minDistance(word1 string, word2 string) int {
    dist := lwstDP(word1, word2)
	return dist
}

func lwstDP(word1, word2 string) int {
	n := len(word1)
	m := len(word2)
	if n == 0 {
		return m
	}
	if m == 0 {
		return n
	}

	// 初始化0行0列，代表 从字符串i的位置变成空字符串需要的步数
	var dist = make([][]int, n+1, n+1)
	for i := 0; i <= n; i++ {
		dist[i] = make([]int, m+1, m+1)
		dist[i][0] = i
		for j := 0; j <= m; j++ {
			dist[0][j] = j
		}
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			if word1[i-1] == word2[j-1] {
				dist[i][j] = dist[i-1][j-1]
			} else {
				dist[i][j] = min(dist[i-1][j-1], dist[i-1][j], dist[i][j-1]) + 1
			}
		}
	}
	return dist[n][m]
}

func min(i, j, k int) int {
	if i > j {
		if j > k {
			return k
		}
		return j
	}
	if i > k {
		return k
	}
	return i
}
