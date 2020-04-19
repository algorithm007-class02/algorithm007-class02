# 1. 排序后作为字典的key来存储
#       可以直接将sorted()返回的字符列表转为字符串作为key
#       也可以用join()函数连成字符串作为key
#       使用join()结果运行比较快，可能是key比较短，查找比较快
# 2. 暴力法
#       for loop, 每趟建立列表然后遍历数组，将相同元素加入到列表中
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # res = dict()
        # for word in strs:
        #     key = "".join(sorted(word))
        #     if key in res:
        #         res[key].append(word)
        #     else:
        #         res[key] = [word]
        # return list(res.values())

        # simple code
        d = {}
        for w in sorted(strs):
            key = tuple(sorted(w))
            d[key] = d.get(key, []) + [w]
        return list(d.values())

        # 2. 暴力法 - 超出时间限制
        # res = []
        # for word in strs[:]:
        #     lst = []
        #     key = sorted(word)
        #     for item in strs[:]:
        #         if key == sorted(item):
        #             lst.append(item)
        #             strs.remove(item)
        #     if lst:
        #         res.append(lst)
        # return res