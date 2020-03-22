//方法1 最好的方法
int moveZeroes_1(int *nums, int numsize) {
  int i = 0, j = 0;
  for (; i < numsize; i++) {
    if (nums[i] != 0) {
      nums[j] = nums[i];
      printf("i=%d,j=%d\n", i, j);
      if (j != i)
        nums[i] = 0;
      j++;
    }
  }
}
//交换
int moveZeros_2(int *nums, int count) {
  if (count <= 0)
    return -1;
  int i, j;
  for (i = 0, j = 0; i < count; i++) {
    if (nums[i] != 0) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
      j++;
    }
  }
}

//时间复杂度（n^2）
int moveZeros_3(int *nums, int count) {
  int i, j = 0;

  for (i = 0; i < 5; i++) {
    if (nums[i] != 0)
      nums[j++] = nums[i];
  }
  for (; j < count; j++) {
    nums[j] = 0;
  }
}

int main() {
  int a[5] = {1, 0, 0, 5, 3};
  moveZeros_1(a, 5);
  // moveZeros_2(a,5);
  // moveZeros_3(a,5);
  int i = 0;
  for (; i < 5; i++) {
    printf("%d,", a[i]);
  }
}