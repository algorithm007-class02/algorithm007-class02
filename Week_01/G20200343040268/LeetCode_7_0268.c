int* plusOne(int* digits, int digitsSize, int* returnSize){
        int i = 0;
        for (i = digitsSize - 1; i>= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                *returnSize = digitsSize;
                return digits;
            }
            digits[i] = 0;
        }
        int * res_num = (int *)malloc(sizeof(int) * (digitsSize + 1));
        res_num[0] = 1;
        for(i = digitsSize; i>0; i--){
            res_num[i] = 0;
        }
        *returnSize = digitsSize +1;
        return res_num;
}
