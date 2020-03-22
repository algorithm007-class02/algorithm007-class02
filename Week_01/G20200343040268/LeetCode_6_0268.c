#define SWAP_NUM(x, y)	\
do {				\
	int tmp = x;	\
	x = y;			\
	y = tmp;		\
}while(0)

void moveZeroes(int* nums, int numsSize){
	int i = 0;
	int j = 0;
    if (nums == NULL) return NULL;
	for (i = 0; i < numsSize; i++){
		if (nums[i] != 0){
			SWAP_NUM(nums[j], nums[i]);
			j++;
		}
	}
}
