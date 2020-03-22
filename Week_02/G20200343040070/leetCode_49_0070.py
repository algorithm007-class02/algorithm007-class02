class Solution:
    @staticmethod
    def group_anagrams(strs):
        word_list = {}
        for word in strs:
            # 根据题意,取出数组中字符串
            # 将字符串重新排序,使用元组类型将其存为key
            # 注:元组虽然是不可变,但是如果做key使用,元组内部不能存在可变对象
            key = tuple(sorted(word))
            # 将有相同key的字符串存进对应数组中
            word_list[key] = word_list.get(key, []) + [word]
        return list(word_list.values())
