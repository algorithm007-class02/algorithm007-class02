# 1. 暴力遍历，def一个单步位移函数，然后用for循环调用k次位移函数，时间复杂度O(n^k)

# 2. 新建一个数组，然后从nums[-3]开始依次append到新数组中，时间复杂度O(n),空间复杂度O(n)

# 3.    1) len%2 == 1  直接用一个临时变量temp记录被替换掉的元素值
#                      然后不停交换元素知道全部完成位移，如：
#                      1换4. 4换7， 7换3， 3换6， 6换2， 2换5，5换1，完成
#       2) len%2 == 0  end记录循环完成标识，temp记录当前被替换元素值，count记录位移元素个数
#                      1换4，4换1，2换5，5换2, 3换6，6换3   需要进行k次循环交换

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)   #
        nums[:] = nums[-k:] + nums[:-k] # 不能写成 nums = nums[-k:] + nums[:-k]
        # nums[-k:]从倒数第k个元素到末尾
        # nums[:-k]从首元到倒数第k个元素
        # 元素向右移动k个位置，则原数组的末尾元素移动到数组的第k位
        # 由于元素之间的相对位置不会改变，所以照着相对位置移动即可

        # # 循环解法
        # size = len(nums)
        # count = 0
        # if size % 2 == 1:   # 奇数个元素，一口气循环到底
        #     end = 0
        #     pos = 0
        #     temp = nums[pos]
        #     nums[(pos+k)%size], temp = temp, nums[(pos+k)%size]
        #     count += 1
        #     pos  = (pos+k)%size
        #     while(pos%size != end):
        #         nums[(pos+k)%size], temp = temp, nums[(pos+k)%size]
        #         count += 1
        #         pos = (pos + k) % size
        #         if (count == size):
        #             break
        # else:       # 偶数个元素，k次循环
        #     for i in range(k):
        #         if i > size:
        #             break
        #         pos = i
        #         end = i
        #         temp = nums[pos]
        #         nums[(pos+k)%size], temp = temp, nums[(pos+k)%size]
        #         count += 1
        #         pos  = (pos+k)%size
        #         while(pos%size != end):
        #             nums[(pos+k)%size], temp = temp, nums[(pos+k)%size]
        #             count += 1
        #             pos = (pos + k) % size
        #         if count == size:
        #             break
        # 空间换时间
        # lst = []
        # size = len(nums)
        # for i in range(-k,size-k):
        #     lst.append(nums[i])
        # 暴力法
        # def move(nums):
        #     temp = nums[-1]
        #     size = len(nums)
        #     for i in range(size-1, -1, -1):
        #         nums[i] = nums[i-1]
        #     nums[0] = temp
        # for i in range(k):
        #     move(nums)