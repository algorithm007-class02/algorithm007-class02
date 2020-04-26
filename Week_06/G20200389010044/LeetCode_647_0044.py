class Solution:
    def countSubstrings(self, s: str) -> int:
        # size, res = len(s), 0
        # if not size: return res
        # for center in range(2 * size - 1): #
        #     left = center // 2
        #     right = left + center % 2
        #     while left >= 0 and right < size and s[left] == s[right]:
        #         res += 1
        #         left -= 1
        #         right += 1
        # return res

        '''

        '''
        def manachers(S):
            A = '@#' + '#'.join(S) + '#$'
            Z = [0] * len(A)
            center = right = 0
            for i in range(1, len(A) - 1):
                if i < right: # 
                    Z[i] = min(right - i, Z[2 * center - i])
                while A[i + Z[i] + 1] == A[i - Z[i] - 1]: # 
                    Z[i] += 1
                if i + Z[i] > right: # 
                    center, right = i, i + Z[i]
            return Z
        return sum( (v + 1) // 2 for v in manachers(s) )