void rotate(int* nums, int numsSize, int k){
	int num = 0;
	int curr = 0;
	int next = 0;
	int tmp = 0;
	int start = 0;
	int curr_num = 0;
	k = k % numsSize;
	while (num < numsSize){
		curr = start;
		curr_num = nums[start];
		do {
			next = (curr + k) % numsSize;
			tmp = nums[next];
			nums[next] = curr_num;
			curr_num = tmp;
			curr = next;
			num++;
		}while (curr != start);
		start++;
	}
}
