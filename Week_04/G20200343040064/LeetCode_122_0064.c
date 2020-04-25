/**
 * 122. 买卖股票的最佳时机 II
 * */

int maxProfit(int* prices, int pricesSize){
    int total = 0;
    for(int i=1;i<pricesSize;++i) {
        if(prices[i] > prices[i-1]) {
            total += prices[i]-prices[i-1];
        }
    }
    return total;
}