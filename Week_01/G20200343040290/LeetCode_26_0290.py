class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        doing_item = None
        count = 0 
        for item in nums:
            if not item == doing_item:
                doing_item = item
                nums[count] = doing_item
                count += 1
        return count
