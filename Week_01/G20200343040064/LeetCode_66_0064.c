/**
 * 66.加一
 * 
 * */

int* plusOne(int* digits, int digitsSize, int* returnSize){
    int flag = 1;
    int i = digitsSize-1;
    int *res = malloc((digitsSize+1)*sizeof(int));
    while(i>=0) {
        if(flag&&(digits[i] == 9)) {
            res[i+1] = 0;
            flag = 1;
        }
        else {
            res[i+1] = digits[i]+flag;
            flag = 0;
        }
        i--;
    }
    
    res[0] = flag;
    *returnSize = digitsSize+flag;
    return res+!flag;
}