学习笔记
如何从十进制转换为二进制
https://zh.wikihow.com/%E4%BB%8E%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E6%8D%A2%E4%B8%BA%E4%BA%8C%E8%BF%9B%E5%88%B6

N皇后位运算
class Solution {
	private int size; 
	private int count;

	private void solve(int row, int ld, int rd) { 
		if (row == size) { 
			count++; 
			return; 
		}
		int pos = size & (~(row | ld | rd)); 
		while (pos != 0) { 
			int p = pos & (-pos); 
			pos -= p; // pos &= pos - 1; 
			solve(row | p, (ld | p) << 1, (rd | p) >> 1); 
		} 
	} 

public int totalNQueens(int n) { 
	count = 0; 
	size = (1 << n) - 1; 
	solve(0, 0, 0); 
	return count; 
  } 
}

指定位置的位运算
1. 将x最右边的n位清零 x & (~0<<n)
2. 获取x的第n位值：(x>>n)&1
3. 获取x的第n位的幂值: x&(1<<n)
4. 仅将第n位置为1: x|(1<<n)
5. 仅将第n位置为0: x &(~(1<<n))
6. 将x最高位至第n位（含）清零: x&((1<<n) - 1)
7. 将第n位至第0位(含)清零: x&(~((1<<(n+1))-1))


    
