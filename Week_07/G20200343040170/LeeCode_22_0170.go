func generateParenthesis(n int) []string {
    res := make([]string, 0, n)
    if n == 0 {
        return res
    }

    dfs("", n, n, &res)
    return res
}

func dfs(str string, left, right int, res *[]string) {
    if left == 0 && right == 0 {
        *res = append(*res, str)
        return
    }

    if left > right {
        return
    }

    if left > 0 {
        dfs(str + "(", left - 1, right, res)
    }
    if right > 0 {
        dfs(str + ")", left, right - 1, res)
    }
}
