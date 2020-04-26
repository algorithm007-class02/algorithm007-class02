# 第12课 | 动态规划

## 1. 动态规划的实现及关键点

### 参考链接

- [递归代码模板](http://shimo.im/docs/DjqqGCT3xqDYwPyY/)

    ```python
    # Python 代码模板
    def recursion(level, param1, param2, ...): 
        # recursion terminator 
        if level > MAX_LEVEL: 
    	   process_result 
    	   return 
        # process logic in current level 
        process(level, data...) 
        # drill down 
        self.recursion(level + 1, p1, ...) 
        # reverse the current level status if needed
    ```

    ```java
    //Java 代码模板
    public void recur(int level, int param) { 
      // terminator 
      if (level > MAX_LEVEL) { 
        // process result 
        return; 
      
      // process current logic 
      process(level, param); 
      // drill down 
      recur( level: level + 1, newParam);
      // restore current status 
    }
    ```

- [分治代码模板](http://shimo.im/docs/3xvghYh3JJPKwdvt/)

    ```python
    def divide_conquer(problem, param1, param2, ...): 
      # recursion terminator 
      if problem is None: 
    	print_result 
    	return 
    
      # prepare data 
      data = prepare_data(problem) 
      subproblems = split_problem(problem, data) 
    
      # conquer subproblems 
      subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
      subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
      subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
      …
    
      # process and generate the final result 
      result = process_result(subresult1, subresult2, subresult3, …)
    	
      # revert the current level states
    ```

- [动态规划定义](https://en.wikipedia.org/wiki/Dynamic_programming)

## 2. DP例题解析：Fibonacci数列、路径计数

#### [509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)

```php
class Solution {

    /**
     * 方法一：迭代（动态规划）
     * @param Integer $N
     * @return Integer
     */
    function fib($N) {
        if ($N <= 1) return $N;
        $first = 0;
        $second = 1;
        for ($i = 2; $i <= $N; $i++) {
            $tmp = $first + $second;
            $first = $second;
            $second = $tmp;
        }
        return $second;
    }
    //方法二：记忆化递归
    function fib($n) {
        if ($n <= 1) return $n;
        if (!isset($this->map[$n])) {
            $this->map[$n] = $this->fib($n - 1) + $this->fib($n - 2);
        }
        return $this->map[$n];
    }
    //方法三：公式法
    function fib($N) {
        $goldenRatio = (1 + sqrt(5)) / 2;
        return (int)round(pow($goldenRatio, $N)/ sqrt(5));
    }
    //方法四：矩阵求幂
}
```

## 3. DP例题解析：最长公共子序列

### 参考链接

#### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

```java
class Solution {
    public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    public int uniquePaths1(int m, int n) {
		int[] cur_row = new int[n];
        Arrays.fill(cur_row, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur_row[j] += cur_row[j - 1];
            }
        }
        return cur_row[n - 1];
    }
}
```

```php
class Solution {

    /**
     * 方法一：自底向上，动态规划
     * @param Integer $m
     * @param Integer $n
     * @return Integer
     */
    function uniquePaths($m, $n) {
        $dp = [];
        //最后一列
        for ($i = 0; $i < $n; $i++) $dp[$m - 1][$i] = 1;
        //最后一行
        for ($i = 0; $i < $m; $i++) $dp[$i][$n - 1] = 1;
        for ($i = $m - 2; $i >= 0; $i--) {
            for ($j = $n - 2; $j >= 0; $j--) {
                $dp[$i][$j] = $dp[$i + 1][$j] + $dp[$i][$j + 1];
            }
        } 
        return $dp[0][0];
    }
    //方法二：自顶向下，动态规划
    function uniquePaths($m, $n) {
        $dp = [];
        for ($i = 0; $i < $m; $i++) {
            for ($j = 0; $j < $n; $j++) {
                if ($i == 0 || $j == 0) {
                    $dp[$i][$j] = 1;
                } else {
                	$dp[$i][$j] = $dp[$i - 1][$j] + $dp[$i][$j - 1];
                }
            }
        } 
        return $dp[$m - 1][$n - 1];
    }
}
```

#### [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

```php
class Solution {

    /**
     * 动态规划，自顶向下
     * @param Integer[][] $obstacleGrid
     * @return Integer
     */
    function uniquePathsWithObstacles($obstacleGrid) {
        $m = count($obstacleGrid);
        $n = count($obstacleGrid[0]);
        if ($obstacleGrid[0][0] == 1) return 0;
        $dp = [];
        for ($i = 0; $i < $m; $i++) {
            for ($j = 0; $j < $n; $j++) {
                if ($obstacleGrid[$i][$j] == 1) {
                    $dp[$i][$j] = 0;
                } else if ($i == 0 && $j == 0) {
                    $dp[$i][$j] = 1;
                } else {
                    $dp[$i][$j] = $dp[$i - 1][$j] + $dp[$i][$j - 1];
                }
            }
        }
        return $dp[$m - 1][$n - 1];
    }
    //标准写法
    function uniquePathsWithObstacles($obstacleGrid) {
        $m = count($obstacleGrid);
        $n = count($obstacleGrid[0]);
        if ($obstacleGrid[0][0] == 1) return 0;
        $dp = [[1]];
        //初始化第一行
        for($i = 1; $i < $n; $i++) {
            $dp[0][$i] = $obstacleGrid[0][$i] ? 0 : $dp[0][$i-1];
        }
        //初始化第一列
        for ($i = 1; $i < $m; $i++) {
            $dp[$i][0] = $obstacleGrid[$i][0] ? 0 : $dp[$i - 1][0];
        }
        for ($i = 1; $i < $m; $i++) {
            for ($j = 1; $j < $n; $j++) {
                if ($obstacleGrid[$i][$j] == 1) {
                    $dp[$i][$j] = 0;
                } else {
                    $dp[$i][$j] = $dp[$i - 1][$j] + $dp[$i][$j - 1];
                }
            }
        }
        return $dp[$m - 1][$n - 1];
    }
}
```

#### [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)

```python
class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        m = len(text1)
        n = len(text2)
        # 构建 DP table 和 base case
        dp = [[0]*(n + 1) for _ in range(m + 1)] # m+1 行 n+1 列
        # 进行状态转移
        for i in range(1, m + 1):
            for j in range(1, n + 1):
            	if text1[i - 1] == text2[j - 1]:
                    # 找到一个 lcs 中的字符
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        return dp[m][n]
```

```php
class Solution {

    /**
     * @param String $text1
     * @param String $text2
     * @return Integer
     */
    function longestCommonSubsequence($text1, $text2) {
        $dp = [];
        //$dp = array_fill(0,$m+1,array_fill(0,$n+1,0));
        for ($i = 0; $i < strlen($text1); $i++) {
            for ($j = 0; $j < strlen($text2); $j++) {
                if ($text1{$i} == $text2{$j}) {
                    $dp[$i][$j] = ($dp[$i - 1][$j - 1] ?? 0) + 1;
                } else {
                    $dp[$i][$j] = max($dp[$i - 1][$j] ?? 0, $dp[$i][$j - 1] ?? 0);
                }
            }
        }
        return $dp[strlen($text1) - 1][strlen($text2) - 1];
    }
    //降维
    function longestCommonSubsequence($text1, $text2) {
        // 动态规划的做法：穷举+剪纸
        $dp=[0];
        for($i = 1; $i <= strlen($text1); $i++){
            $last = 0;
            for($j = 1; $j <= strlen($text2); $j++){
                $tmp=$dp[$j];
                if($text1[$i - 1] == $text2[$j - 1]){
                    $dp[$j] = $last + 1;
                }else{
                    $dp[$j] = max($dp[$j - 1],$tmp);
                }
                $last=$tmp;
            }
        }
        return $dp[strlen($text2)];
    }
}
```

#### [MIT 动态规划课程最短路径算法](https://www.bilibili.com/video/av53233912?from=search&seid=2847395688604491997)

## 4. 实战题目解析：三角形最小路径和

## 5. 实战题目解析：最大子序列和

### 实战题目

#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

```php
// 1. 可以走1,2,3步（easy）
// 2. 相邻两步的部分不能相同（medium）

class Solution {

    /**
     * 空间优化的dp
     * @param Integer $n
     * @return Integer
     */
    function climbStairs($n) {
 		if ($n < 3) return $n;
        $first = 1;
        $second = 2;
        for ($i = 3; $i <= $n; $i++) {
            $tmp = $first + $second;
            $first = $second;
            $second = $tmp;
        }
        return $second;
    }
    //递归
    function climbStairs($n) {
        if ($n <= 2) return $n;
        if (!isset($this->map[$n])) {
            $this->map[$n] = $this->climbStairs($n - 1) + $this->climbStairs($n - 2);
        }
        return $this->map[$n];
    }
}
```



#### [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)、[参考代码](https://leetcode.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up))

[递归记忆化搜索](https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/)

```php
class Solution {

    /**
     * 动态规划
     * @param Integer[][] $triangle
     * @return Integer
     */
    function minimumTotal($triangle) {
        $dp = $triangle;
        for ($i = count($triangle) - 2; $i >= 0; $i--) {
            for ($j = 0; $j < count($triangle[$i]); $j++){
                $dp[$i][$j] += min($dp[$i + 1][$j], $dp[$i + 1][$j + 1]);
            }
        }
        return $dp[0][0];
    }
    //动态规划（降维）
    function minimumTotal($triangle) {
        $dp = array_fill(0, count($triangle) + 1, 0);
        for ($i = count($triangle) - 1; $i >= 0; $i--) {
            for ($j = 0; $j < count($triangle[$i]); $j++){
                $dp[$j]= min($dp[$j], $dp[$j + 1]) + $triangle[$i][$j];
            }
        }
        return $dp[0];
    }
    //递归
    function minimumTotal($triangle) {
        $this->row = count($triangle);
        $this->memo = [];
        return $this->helper(0, 0, $triangle);
    }
    private $row;
    private $memo;
    function helper($row, $col, $triangle) {
        if (isset($this->memo[$row][$col])) {
            return $this->memo[$row][$col];
        }
        if ($row == $this->row - 1) {
            return $this->memo[$row][$col] = $triangle[$row][$col];
        }
        $left = $this->helper($row + 1, $col, $triangle);
        $right = $this->helper($row + 1, $col + 1, $triangle);
        return $this->memo[$row][$col] = min($left, $right) + $triangle[$row][$col];
    }
}
```

#### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

```php
class Solution {

    /**
     * 方法一：动态规划
     * @param Integer[] $nums
     * @return Integer
     */
    function maxSubArray($nums) {
        $dp = [];
        $dp[0] = $nums[0];
        $max = $nums[0];
        foreach ($nums as $i=>$num) {
            if ($i == 0) continue;
            $dp[$i] = max(0, $dp[$i - 1]) + $num;
            $max = max($dp[$i], $max);
        }
        return $max;
    }
    //方法二：贪心
    //方法三：分治
}
```

```cpp
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
		std::vector<int> dp(nums.size(), 0);
        dp[0] = nums[0];
        int res_max = dp[0];
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = std::max(dp[i - 1] + nums[i], nums[i]);
            if (res_max < dp[i]) {
                res_max = dp[i];
            }
        }
        return res_max;
    }
};
```

#### [152. 乘积最大子数组](https://leetcode-cn.com/problems/maximum-product-subarray/)

```php
class Solution {

    /**
     * 标准dp写法
     * @param Integer[] $nums
     * @return Integer
     */
    function maxProduct($nums) {
        $n = count($nums);
        $max = $min = [$nums[0]];
        $ans = $nums[0];
        for ($i = 1; $i < $n; $i++) {
            if ($x >= 0) {
                $max[$i] = max($max[$i - 1] * $nums[$i], $nums[$i]);
                $min[$i] = min($min[$i - 1] * $nums[$i], $nums[$i]);
            } else {
                $max[$i] = max($min[$i - 1] * $nums[$i], $nums[$i]);
                $min[$i] = min($max[$i - 1] * $nums[$i], $nums[$i]);
            }
            $ans = max($ans, $max[$i]);
        }
		return $ans;
    }
}
```

```python
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mi = ma = res = nums[0]
        for i in range(1, len(nums)):
            if nums[i] < 0: mi, ma = ma, mi
            ma = max(ma * nums[i], nums[i]) # 正数最大值
            mi = min(mi * nums[i], nums[i]) # 负数最小值
            res = max(ma, res)
        return res
```

#### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

```php
class Solution {
public:
    //动态规划
    int coinChange(vector<int>& coins, int amount) {
		int Max = amount + 1;
        vector<int>dp(amount + 1, Max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.size(); j++) {
                if (coins[j] <= i) {
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
};
```

## 6. 实战题目解析：打家劫舍

### 实战题目

#### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)

```php
class Solution {

    /**
     * 二维dp
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) 不偷
     * dp[i][1] = dp[i - 1][0] + nums[i] 偷
     * @param Integer[] $nums
     * @return Integer
     */
    function rob1($nums) {
        if (!$nums) return 0;
        $dp = [];
        $dp[0][0] = 0;
        $dp[0][1] = $nums[0];
        $n = count($nums);
        for ($i = 1; $i < $n; $i++) {
            $dp[$i][0] = max($dp[$i - 1][0], $dp[$i - 1][1]);
            $dp[$i][1] = $dp[$i - 1][0] + $nums[$i];
        }
        return max($dp[$n - 1]);
    }
    //一维dp[i] = max($dp[$i - 1], $dp[$i - 1] + $nums[$i]) 第 i 天偷 的金额
    function rob($nums) {
        if (!$nums) return 0;
        $n = count($nums);
        if ($n == 1) return $nums[0];
        $dp = [];
        $dp[0] = $nums[0];
        $dp[1] = max($nums[0], $nums[1]);
        for ($i = 2; $i < $n; $i++) {
            $dp[$i] = max($dp[$i - 1], $dp[$i - 2] + $nums[$i]);
        }
        return $res;
    }
    //简化的dp
    function rob($nums) {
        $preMax = $curMax = 0;
        foreach($nums as $num) {
        	$tmp = $curMax;
            $curMax = max($preMax + $num, $curMax);
            $preMax = $tmp; 
        }
        return $curMax;
    }
    //递归
    function rob ($nums) {
        return $this->helper($nums, count($nums) - 1);
    }
    function helper($nums, $i) {
        if ($i < 0) return 0;
        return max($this->helper($nums, $i - 1), $this->hepler($nums, $i - 2) + $nums[$i]);
    }
}
```

#### [213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)

```php
class Solution {

    /**
     * 动态规划：
     * 1. 包含头，不包含尾
     * 2, 不包含头，包含尾
     * 3，求 1 和 2 最大值
     * @param Integer[] $nums
     * @return Integer
     */
    function rob($nums) {
        if (count($nums) == 1) return $nums[0];
        return max($this->robRange($nums, 0, count($nums) - 2), $this->robRange($nums, 1, count($nums) - 1));
    }
    function robRange($nums, $start, $end) {
        $preMax = $curMax = 0;
        for ($i = $start; $i <= $end; $i++) {
            $tmp = $curMax;
            $curMax = max($preMax + $nums[$i], $curMax);
            $preMax = $tmp;
        }
        return $curMax;
    }
}
```

```java
private int rob(int[] num, int lo, int hi) {
    int include = 0, exclude = 0;
    for (int j = lo; j <= hi; j++) {
        int i = include, e = exclude;
        include = e + num[j];
        exclude = Math.max(e, i);
    }
    return Math.max(include, exclude);
}
```

#### [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

```php
class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
    	$cur = $res = 0;
        for ($i = 1; $i < count($prices); $i++) {
            $cur = max(0, $cur + $prices[$i] - $prices[$ - 1]);
            $res = max($cur, $res);
        }
        return $res;
    }
    //标准dp
    function maxProfit($prices) {
        $n = count($prices);
    	$dp = [];
        $dp[0][0] = 0;
        $dp[0][1] = -$prices[0];
        for ($i = 1; $i < $n; $i++) {
            //不持有股票
            $dp[$i][0] = max($dp[$i - 1][0], $dp[$i - 1][1] + $prices[$i]);
            //持有股票
            $dp[$i][1] = max($dp[$i - 1][1], -$prices[$i]);
        }
        return $dp[$n - 1][0];
    }
    //简化
    function maxProfit($prices) {
        $n = count($prices);
    	$dpi0 = 0; $dpi1 = -$prices[0];
        for ($i = 0; $i < $n; $i++) {
            //不持有股票
            $dpi0 = max($dpi0, $dpi1 + $prices[$i]);
            //持有股票
            $dpi1 = max($dpi1, -$prices[$i]);
        }
        return $dpi0;
    }
}
```

#### [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

```php
class Solution {
    //dp
    function maxProfit($prices) {
       	$n = count($prices);
    	$dpi0 = 0; $dpi1 = -$prices[0];
        for ($i = 0; $i < $n; $i++) {
            $tmp = $dpi0;
            //不持有股票
            $dpi0 = max($dpi0, $dpi1 + $prices[$i]);
            //持有股票
            $dpi1 = max($dpi1, $tmp - $prices[$i]);
        }
        return $dpi0;
    }
}
```

#### [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)

```php
class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $n = count($prices);
        if (!$n) return 0;
        $dp = [];
        for ($i = 0; $i < $n; $i++) {
            for ($k = 2; $k > 0; $k--) {
                if ($i == 0) {
                    $dp[$i][$k][0] = 0;
                    $dp[$i][$k][1] = -$prices[$i];
                    continue;
                }
                $dp[$i][$k][0] = max($dp[$i - 1][$k][0], $dp[$i - 1][$k][1] + $prices[$i]);
                $dp[$i][$k][1] = max($dp[$i - 1][$k][1], $dp[$i - 1][$k - 1][0] - $prices[$i]);
            }
        }
        return $dp[$n - 1][2][0];
    }
    //简化
    function maxProfit($prices) {
        $dp_i10 = 0, $dp_i11 = -$prices[0];
        $dp_i20 = 0, $dp_i21 = -$prices[0];
        foreach ($prices as  $price) {
            $dp_i20 = max($dp_i20, $dp_i21 + $price);
            $dp_i21 = max($dp_i21, $dp_i10 - $price);
            $dp_i10 = max($dp_i10, $dp_i11 + $price);
            $dp_i11 = max($dp_i11, -$price);
        }
        return $dp_i20;
    }
    //简化
    function maxProfit($prices) {
        $cur = $res = 0;
        $len = count($prices);
        $states = array_fill(0, $len, 0);
        for ($i = 1; $i < $len; $i++) {
            $cur = max(0, $cur + $prices[$i] - $prices[$i - 1]);
            $states[$i] = max($cur, $states[$i - 1]);
        }
        for ($i = $len - 2, $cur = 0; $i >= 0; $i--) {
            $cur = max(0, $cur + $prices[$i + 1] - $prices[$i]);
            $res = max($cur + $states[$i], $res);
        }
        return $res;
    }
}
```

#### [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)

```php
class Solution {

    /**
     * @param Integer $k
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($k1, $prices) {
        $n = count($prices);
        if ($n == 0 || $k1 == 0) return 0;
        if ($k1 > $n /2) return $this->maxProfit1($prices); 
        $dp = [];
        for ($i = 0; $i < $n; $i++) {
            for ($k = $k1; $k > 0; $k--) {
                if ($i == 0) {
                    $dp[$i][$k][0] = 0;
                    $dp[$i][$k][1] = -$prices[$i];
                    continue;
                }
                $dp[$i][$k][0] = max($dp[$i - 1][$k][0], $dp[$i - 1][$k][1] + $prices[$i]);
                $dp[$i][$k][1] = max($dp[$i - 1][$k][1], $dp[$i - 1][$k - 1][0] - $prices[$i]);
            }
        }
        return $dp[$n - 1][$k][0];
    }
    function maxProfit1($prices) {
       	$n = count($prices);
    	$dpi0 = 0; $dpi1 = -$prices[0];
        for ($i = 0; $i < $n; $i++) {
            $tmp = $dpi0;
            //不持有股票
            $dpi0 = max($dpi0, $dpi1 + $prices[$i]);
            //持有股票
            $dpi1 = max($dpi1, $tmp - $prices[$i]);
        }
        return $dpi0;
    }
    
    //简化
    function maxProfit($k, $prices) {
        $len = count($prices);
        if ($len == 0) return 0;
        if ($k > $len / 2) {
            $buy = - $prices[0];
            $sell = 0;
            $res = 0;
            for ($i = 1, $len = count($prices); $i < $len; $i++) {
                $buy = max($buy, $sell - $prices[$i]);
                $sell = max($sell, $buy + $prices[$i]);
                $res = max($sell, $res);
            }
            return $res;
        }
        $local = array_fill(0, $k + 1, 0);
        $global =  array_fill(0, $k + 1, 0);
        for ($i = 1; $i < $len; $i++) {
            $diff = $prices[$i] - $prices[$i - 1];
            $tmp = array_fill(0, $k + 1, 0);
            for ($j = 1; $j <= $k; $j++) {
                $local[$j] =  max($global[$j - 1], $local[$j]) + $diff;
                $tmp[$j] =  max($global[$j], $local[$j]);
            }
            $global = $tmp;
        }
        return $global[$k];
    }
}
```

#### [309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)

```php
class Solution {
    //dp
    function maxProfit($prices) {
       	$n = count($prices);
    	$dpi0 = 0; $dpi1 = -$prices[0];
        $dppre0 = 0;
        for ($i = 0; $i < $n; $i++) {
            $tmp = $dpi0;
            //不持有股票
            $dpi0 = max($dpi0, $dpi1 + $prices[$i]);
            //持有股票
            $dpi1 = max($dpi1, $dppre0 - $prices[$i]);
            $dppre0 = $dpi0;
        }
        return $dpi0;
    }
}
```

#### [714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

```php
class Solution {
    //dp
    function maxProfit1($prices, $free) {
       	$n = count($prices);
    	$dpi0 = 0; $dpi1 = -$prices[0];
        for ($i = 0; $i < $n; $i++) {
            //不持有股票
            $dpi0 = max($dpi0, $dpi1 + $prices[$i] - $free);
            //持有股票
            $dpi1 = max($dpi1, $dpi0 - $prices[$i]);
        }
        return $dpi0;
    }
    
    function maxProfit2($prices, $fee) {
        $res = 0;
        for ($i = 1, $len = count($prices); $i < $len; $i++) {
            if ($prices[$i] > $prices[$i - 1]) {
                $res += $prices[$i] - $prices[$i - 1] - $fee;
            }
        }
        return $res;
    }
     //dp
    function maxProfit($prices, $fee) {
        $buy = - $prices[0];
        $sell = 0;
        $res = 0;
        for ($i = 1, $len = count($prices); $i < $len; $i++) {
            $buy = max($buy, $sell - $prices[$i]);
            $sell = max($sell, $buy + $prices[$i] - $fee);
            $res = max($sell, $res);
        }
        return $res;
    }
}
```

####  [一个方法团灭 6 道股票问题](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/)

### 高级 DP 实战题目

#### [279. 完全平方数](https://leetcode-cn.com/problems/perfect-squares/)

#### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/) （重点）

#### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

#### [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

#### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

#### [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

#### [980. 不同路径 III](https://leetcode-cn.com/problems/unique-paths-iii/)

#### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

#### [518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/)

## 本周作业及下周预习

### 本周作业

#### 中等

##### [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

```php
class Solution {

    /**
     * dp(自顶向下)
     * @param Integer[][] $grid
     * @return Integer
     */
    function minPathSum($grid) {
        $m = count($grid);
        if ($m == 0) return 0;
        $n = count($grid[0]);
        $dp = [];
        $dp[0][0] = $grid[0][0];
        //初始化第一行
        for($i = 1; $i < $n; $i++) {
            $dp[0][$i] = $dp[0][$i - 1] + $grid[0][$i];
        }
        for ($i = 1; $i < $m; $i++) {
            $dp[$i][0] = $dp[$i - 1][0] + $grid[$i][0];
            for ($j = 1; $j < $n; $j++) {
                $dp[$i][$j] = min($dp[$i][$j - 1], $dp[$i - 1][$j]) + $grid[$i][$j];
            }
        }
		return $dp[$m - 1][$n - 1];
    }
    //dp 降维
    function minPathSum($grid) {
        $m = count($grid);
        if ($m == 0) return 0;
        $n = count($grid[0]);
        $dp = [];
        $dp[0] = $grid[0][0];
        //初始化第一行
        for($i = 1; $i < $n; $i++) {
            $dp[$i] = $dp[$i - 1] + $grid[0][$i];
        }
        for ($i = 1; $i < $m; $i++) {
            $dp[0] = $dp[0] + $grid[$i][0];
            for ($j = 1; $j < $n; $j++) {
                $dp[$j] = min($dp[$j - 1], $dp[$j]) + $grid[$i][$j];
            }
        }
		return $dp[$n - 1];
    }
}
```

##### [91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)

```php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function numDecodings($s) {
        $n = strlen($s);
        if ($n == 0 || $s[0] == 0) return 0;
        $dp = [];
        $dp[0] = 1;
        if (substr($s, 0, 2) <= '26') $dp[1] = $s[1] == 0 ? 1 : 2;
        else $dp[1] = $s[1] == 0 ? 0 : 1;
        for ($i = 2; $i < $n; $i++) {
            if ($s[$i - 1] != 1 && $s[$i - 1] != 2) {
                if ($s[$i] == '0') 0;
                else $dp[$i] = $dp[$i - 1];
            } else {
                $dp[$i] = $s[$i] == 0? $dp[$i - 2] : (substr($s, $i - 1, 2) <= '26' ? $dp[$i - 1] + $dp[$i - 2] :$dp[$i - 1]);
            }
        }
        return $dp[$n - 1];
    }
}
```

##### [221. 最大正方形](https://leetcode-cn.com/problems/maximal-square/)

```php
class Solution {

    /**
     * 动态规划
     * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare($matrix) {
		$m = count($matrix);
        if ($m == 0) return 0;
        $n = count($matrix[0]);
        $dp  = [];
        $maxsqlen = 0;
        for ($i = 0; $i <= $m; $i++) $dp[] = array_fill(0, $n + 1, 0);
        for ($i = 1; $i <= $m; $i++) {
            for ($j = 1; $j <= $n; $j++) {
                if ($matrix[$i - 1][$j - 1] == 1) {
                    $dp[$i][$j] = min($dp[$i][$j - 1], $dp[$i - 1][$j], $dp[$i - 1][$j - 1]) + 1;
                    $maxsqlen = max($maxsqlen, $dp[$i][$j]);
                }
            }
        }
        return $maxsqlen * $maxsqlen;
    }
    //空间优化使用一维dp
    function maximalSquare($matrix) {
		$m = count($matrix);
        if ($m == 0) return 0;
        $n = count($matrix[0]);
        $maxsqlen = $pre = 0;
        $dp = array_fill(0, $n + 1, 0);
        for ($i = 1; $i <= $m; $i++) {
            for ($j = 1; $j <= $n; $j++) {
                $tmp = $dp[$j];
                if ($matrix[$i - 1][$j - 1] == 1) {
                    $dp[$j] = min($dp[$j - 1], $dp[$j], $pre) + 1;
                    $maxsqlen = max($maxsqlen, $dp[$j]);
                } else {
                    $dp[$j] = 0;
                }
                $pre = $tmp;
            }
        }
        return $maxsqlen * $maxsqlen;
    }
}
```

##### [621. 任务调度器](https://leetcode-cn.com/problems/task-scheduler/) (需要深入研究)

```php
class Solution {

    /**
     * @param String[] $tasks
     * @param Integer $n
     * @return Integer
     * https://leetcode-cn.com/problems/task-scheduler/solution/python-xiang-jie-by-jalan/
     */
    function leastInterval($tasks, $n) {
        $len = count($tasks);
        if ($len <= 1) return $len;
        $counts = array_count_values($tasks);
        arsort($counts);
        $max_task_count = current($counts);
        $res = ($max_task_count - 1) * ($n + 1);
        foreach($counts as $task=>$count) {
            if ($count == $max_task_count) {
                $res++;
            }
        }
       return $res >= $len ? $res : $len;
    }
}
```

##### [647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)(继续)

```php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function countSubstrings($s) {
        $dp = [];
        $ans = 0;
        $n = strlen($s);
        for ($j = 0; $j < $n; $j++) {
            for ($i = 0; $i <= $j; $i++) {
                if ($s[$i] == $s[$j] && ($j - $i < 2 || $dp[$i + 1][$j -1])) {
                    $dp[$i][$j] = true;
                    $ans++;
                }
            }
        }
        return $ans;
    }
    //方法一：从中心往两侧延伸【通过】
    function countSubstrings($s) {
        $ans = 0;
        $n = strlen($s);
       	for ($center = 0; $center <= 2*$n-1; ++$center) {
            $left = intval($center / 2);
            $right = $left + $center % 2;
            while ($left >=0 && $right < $n && $s[$left] == $s[$right]) {
                $ans++;
                $left--;
                $right++;
            }
        }
        return $ans;
    } 	
}
```

#### 困难

##### [32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)

##### [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)



##### [363. 矩形区域不超过 K 的最大数值和](https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/)

##### [403. 青蛙过河](https://leetcode-cn.com/problems/frog-jump/)

##### [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/)

##### [552. 学生出勤记录 II](https://leetcode-cn.com/problems/student-attendance-record-ii/)

##### [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

##### [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/)

​	

### 下周预习

#### 预习知识点：

- [红黑树（上）：为什么工程中都用红黑树这种二叉树？](https://time.geekbang.org/column/article/68638)
- [红黑树（下）：掌握这些技巧，你也可以实现一个红黑树](https://time.geekbang.org/column/article/68976)
- [搜索：如何用 A* 搜索算法实现游戏中的寻路功能？](https://time.geekbang.org/column/article/78175)
- [Trie 树：如何实现搜索引擎的搜索关键词提示功能？](https://time.geekbang.org/column/article/72414)
- [B+ 树：MySQL 数据库索引是如何实现的？](https://time.geekbang.org/column/article/77830)
- [搜索：如何用 A* 搜索算法实现游戏中的寻路功能？](https://time.geekbang.org/column/article/78175)
- [索引：如何在海量数据中快速查找某个数据？](https://time.geekbang.org/column/article/78449)

#s### 预习题目：

- [实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/#/description)
- [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii/)
- [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
- [有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/)
- [N 皇后](https://leetcode-cn.com/problems/n-queens/)
- [单词接龙](https://leetcode-cn.com/problems/word-ladder/)
- [二进制矩阵中的最短路径