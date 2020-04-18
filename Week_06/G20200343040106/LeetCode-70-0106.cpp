#include<iostream>

using namespace std;
class Solution {
public:
    // f(0) = 1 ; f(1) = 1
    // f(n) = f(n-1) + f(n-2)
    int climbStairs(int n) {
        if(n<=1) return 1;
        int i = 1;
        int j = 1;
        for(int k=2;k<=n;k++){
            int temp = j;
            j = i+j;
            i = temp;
        }
        return j;
    }
};


int climbStairs2(int n){
    if(n<=1) return 1;
    if(n==2) return 2;
    int i = 1;
    int j = 1;
    int k = 2;
    //dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    for(int p = 3;p<=n;p++){
        int temp = i+j+k;
        i = j;
        j = k;
        k = temp;
    }
    return k;
}


int climbStairs3(int n){
    if(n<=1) return 1;
    int dp[n+1][3] = {1};
    // dp[i][j] 表示上第i楼是通过j+1步上来的。
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[0][2] = 0;
    dp[1][0] = 1;
    dp[1][1] = 0;
    dp[1][2] = 0;
    dp[2][0] = 0;
    dp[2][1] = 1;
    dp[2][2] = 0;
    for(int i=3;i<=n;i++){
        for(int j=0;j<3;j++){
            if(j==0){
                dp[i][j] = dp[i-1][1]+dp[i-1][2];
            }
            if(j==1){
                dp[i][j] = i-2>=0?dp[i-2][0]+dp[i-2][2]:0;
            }
            if(j==2){
                dp[i][j] = i-3>=0?dp[i-3][0]+dp[i-3][1]:0;
            }
        }
    }
    return dp[n][0]+dp[n][1]+dp[n][2];
}


int main(){
    int test[10] = {1,2,3,9,10,100,150,200,235,1000};
    for(int i=0;i<10;i++){
        cout<<test[i]<<" "<<climbStairs3(test[i])<<endl;
    }
    return 0;
}