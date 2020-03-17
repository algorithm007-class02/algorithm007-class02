class Solution:
    def removeDuplicates(self, lst):
        if not lst:
            return 0

        p = 0

        for i in range(1, len(lst)):
            if lst[i] != lst[p]:
                p += 1
                lst[p] = lst[i]

        return p + 1