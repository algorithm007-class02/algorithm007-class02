class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        if int(s[0]) == 0:
            return 0
        if n == 1:
            return 1
        states = [0]*n
        states[0] = 1
        if int(s[:2])<= 26 and int(s[1]) != 0:
            states[1] = 2
        elif s[0] == '0' or (s[1] == '0' and int(s[:2]) > 26):
            return 0
        else:
            states[1] = 1
        for i in range(2,n):
            if 0 < int(s[i-1:i+1]) <= 26 and int(s[i-1]) != 0 and int(s[i]) != 0:
                states[i] = states[i-1] + states[i-2]
            elif int(s[i-1:i+1]) == 0 or (s[i-1] == '0' and int(s[i-2])>2) or (s[i] == '0' and int(s[i-1])>2):
                return 0
            elif s[i] == '0':
                states[i] = states[i-2]
            else:
                states[i] = states[i-1]
        return states[-1]
