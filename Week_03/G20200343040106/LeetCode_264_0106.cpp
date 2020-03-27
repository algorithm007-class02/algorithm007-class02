//方法一：小根堆+hash-table 
class Solution {
public:
    int nthUglyNumber(int n) {
        priority_queue<long,vector<long>,greater<long>> q;
        unordered_map<long,bool> record;
        q.push(1);
        long temp;
        while(n){
            temp = q.top();
            q.pop();
            if(!record[temp*2]){
                q.push(temp*2);
                record[temp*2] = true;
            }
            if(!record[temp*3]){
                q.push(temp*3);
                record[temp*3] = true;
            }
            if(!record[temp*5]){
                q.push(temp*5);
                record[temp*5] = true;
            }
            
            n--;
        }
        return (int)temp;
    }
};

// 方法二：DP

 
