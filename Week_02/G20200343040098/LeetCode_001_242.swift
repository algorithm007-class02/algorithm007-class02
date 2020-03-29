// 242.有效的字母异位词
// https://leetcode-cn.com/problems/valid-anagram/
class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if s.count != t.count {
            return false
        }
        var dict = [UInt32: Int]()
        for v in s.unicodeScalars {
            let str = v.value
            if let count = dict[str] {
                dict[str] = count + 1;
            } else {
                dict[str] = 1;
            }
        }
        for v in t.unicodeScalars {
            let str  = v.value
            if let count = dict[str] {
                if count == 1 {
                    dict.removeValue(forKey: str)
                } else {
                    dict[str] = count - 1;
                }
            } else {
                return false;
            }
        }
        return dict.count == 0
    }
}