//
// Created by apple on 2020/3/14.
//

int* plusOne(int* digits, int digitsSize, int* returnSize){
    for (int i = digitsSize-1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }
        digits[i] = 0;
    }
    int *result = (int*)malloc(sizeof(int)*(digitsSize+1));
    result[0] = 1;
    for (int i = 1; i < digitsSize+1; i++) {
        result[i] = 0;
    }
    *returnSize = digitsSize+1;
    return result;
}
