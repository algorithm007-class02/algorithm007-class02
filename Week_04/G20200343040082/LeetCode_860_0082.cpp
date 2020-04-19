
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

/**
 
 860. 柠檬水找零
 
 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 
 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 
 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 
 注意，一开始你手头没有任何零钱。
 
 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 
 */

class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        unordered_map<int, int> maps;
        bool ret = true;
        
        for (int e : bills) {
            
            if (e == 5) {
                maps[5]++;
            } else if (e == 10) {
                maps[10]++;
                if (maps[5] > 0) {
                    maps[5]--;
                } else {
                    ret = false;
                    break;
                }
            } else if (e == 20) {
                maps[20]++;
                if (maps[10] > 0 && maps[5] > 0) {
                    maps[10]--;
                    maps[5]--;
                } else if (maps[5] > 2) {
                    maps[5]= maps[5]-3;
                } else {
                    ret = false;
                    break;
                }
            }
        }
        
        return ret;
    }
};


