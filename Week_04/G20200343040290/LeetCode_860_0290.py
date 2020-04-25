class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        change5_save,change10_save = 0,0

        for i in bills:
            if i == 5:
                change5_save += 1
            elif i == 10:
                if change5_save:
                    change5_save -= 1
                else:
                    return False
                change10_save += 1

            elif i == 20:
                if change10_save and change5_save:
                    change10_save -= 1
                    change5_save -= 1
                elif change5_save >= 3:
                    change5_save -= 3
                else:
                    return False
        return True
