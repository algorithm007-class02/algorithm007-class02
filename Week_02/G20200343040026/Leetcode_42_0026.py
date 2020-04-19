# 双指针夹逼法
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)<=2:
            return 0
        hmax = max(height)
        hmax_index = height.index(hmax)
        i = 1
        j = len(height)-2
        res = 0
        lmax = height[0]
        rmax = height[-1]
        if hmax_index>1:
            while i<hmax_index:
                if height[i]>lmax:
                    lmax = height[i]
                else:
                    res += lmax-height[i]
                i += 1
        if hmax_index<len(height)-2:
            while j>hmax_index:
                if height[j]>rmax:
                    rmax = height[j]
                else:
                    res += rmax-height[j]
                j -= 1
        return res

# 扫描法
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)<=2:
            return 0
        res_left = [0]*len(height)
        res_right = [0]*len(height)
        res = 0
        l_max = height[0]
        r_max = height[-1]
        # 从左向右扫描
        for i in range(1,len(height)):
            if height[i]<=l_max:
                res_left[i] = l_max-height[i]
            else:
                l_max = height[i]
        # 从右向左扫描
        for j in range(len(height)-2,-1,-1):
            if height[j]<=r_max:
                res_right[j] = r_max-height[j]
            else:
                r_max = height[j]
        for k in range(len(height)):
            res += min(res_left[k], res_right[k])
        return res