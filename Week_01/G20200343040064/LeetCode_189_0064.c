/**
 * 189.旋转数组
 * 
 * */
//反转法
void reverseArray(int* num,int numsSize) {
    for(int i=0,j=numsSize-1;i<j;++i,--j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
void rotate(int* num,int numsSize,int k) {
    if(k%numsSize == 0)
        return ;
    k = k%numsSize;
    reverseArray(num,numsSize);
    reverseArray(num,k);
    reverseArray(num+k,numsSize-k);
}
