class Solution:
    def reverseWords(self, s: str) -> str:
        s_arr = s.split(" ")
        return " ".join(ss for ss in s_arr[::-1] if ss)