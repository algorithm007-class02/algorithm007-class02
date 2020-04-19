class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        states = [[0]*n for _ in range(n)]
        ans = 0
        for i in range(n-1,-1,-1):
            for j in range(i,n):
                if s[i] == s[j]:
                    if j-i <2:
                        states[i][j] = 1
                        ans += 1
                    else:
                        if states[i+1][j-1]:
                            states[i][j] = states[i+1][j-1]
                            ans += 1
        return ans
