func robotSim(commands []int, obstacles [][]int) int {
    var dx = []int{0, 1, 0, -1}
    var dy = []int{1, 0, -1, 0}

    var obs = make(map[string]bool)
    for _,o := range obstacles {
        obs[fmt.Sprintf("%d,%d", o[0], o[1])] = true
    }

    var x, y, di, ans int
    for _,c := range commands {
        if c == -2 {
            di = (di + 3) % 4
        } else if c == -1 {
            di = (di + 1) % 4
        } else {
            for k := 0; k < c; k++ {
                nx := x + dx[di]
                ny := y + dy[di]
                if obs[fmt.Sprintf("%d,%d", nx, ny)] {
                    break
                }
                x = nx
                y = ny
                ans = max(ans, x*x + y*y)
            }
        }
    }
    return ans
}

func max (x, y int) int {
    if x > y {
        return x
    }
    return y
}
