860. 柠檬水找零
class Solution {
    func lemonadeChange(_ bills: [Int]) -> Bool {
        var m5:Int = 0
        var m10:Int = 0
        for item in bills {
            if item == 5 {
                m5 += 1
            } else if item == 10 {
                m10 += 1
                m5 -= 1
            } else if item == 20 {
                if(m10>=1) {
                    m10 -= 1
                    m5 -= 1
                } else {
                    m5 -= 3
                }
            }
            if m5<0 || m10<0 {
                return false
            }
        }
        return true
    }
}