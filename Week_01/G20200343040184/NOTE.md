学习笔记
# 第一周 第三课|数组、链表、跳表

## Array 实战题目

- #### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

    ```php
    //方法一： 暴力求解 双循环
    class Solution {
        /**
         * @param Integer[] $height
         * @return Integer
         */
        function maxArea($height) {
          $max = 0;
          $len = count($height);
          for ($i = 0; $i < $len - 1; $i++) {
            for ($j = $i + 1; $j < $len; $j++) {
              $area = ($j - $i) * min($height[$i], $height[$j]);
              $max = $area < $max ? $max : $area;
            }
          }
          return $max;
        }
    }
    
    //方法二：双指针法
    class Solution {
        /**
         * @param Integer[] $height
         * @return Integer
         */
        function maxArea($nums) {
          $max = 0;
          for ($i = 0, $j = count($nums) - 1; $i < $j;) {
            $width = $j - $i;//计算宽度
            $height = $nums[$i] < $nums[$j] ? $nums[$i++] : $nums[$j--];//获取最小高度
            $max = max($max, $width * $height);
          }
          return $max;
        }
    }
    ```

    ```java
    //java 双指针
    class Solution {
        public int maxArea(int[] height) {
          int max = 0;
          for (i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
          }
          return max;
        }
    }
    ```

    

- #### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

    ```php
    //方法一
    class Solution {
        /**
         * @param Integer[] $nums
         * @return NULL
         */
        function moveZeroes(&$nums) {
    		for ($lastNonZeroe = 0, $i = 0; $i < count($nums); $i++) {
                //如果为0，交换两个数的值
                if ($nums[$i] != 0) {
                  $tmp = $nums[$i];
                  $nums[$i] = $nums[$lastNonZeroe];
                  $nums[$lastNonZeroe++] = $tmp;
                } 
          	}
        }
    }
    //方法二 谭超写法
    class Solution {
        /**
         * @param Integer[] $nums
         * @return NULL
         */
        function moveZeroes(&$nums) {
    		for ($lastNonZeroe = 0, $i = 0; $i < count($nums); $i++) {
                //如果为0，交换两个数的值
                if ($nums[$i] != 0) {
                     $nums[$lastNonZeroe] = $nums[$i];
                     if ($i != $lastNonZeroe){
                          $nums[$i] = 0;
                     }
                     $lastNonZeroe++;
                }
          	}
        }
    }
    ```

    

- #### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

    ```c++
    class Solution {
    public:
        int climbStairs(int n) {
          if (n <= 2) return n;
          //一次迭代法
          int first = 1, second = 2;
          for (int i = 3; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
          }
    	  return second;
        }
    };
    //方法二：递归
    
    //方法三：递归 + 剪支
    ```

    

- #### [15. 三数之和](https://leetcode-cn.com/problems/3sum/)(高频老题）

    ```php
    //方法一： 暴力， 三层循环
    
    //方法二：hash表
    class Solution {
        /**
         * @param Integer[] $nums
         * @return Integer[][]
         */
        function threeSum($nums) {
            $len = count($nums);
            $res = [];
            sort($nums);
            for ($i = 0; $i < $len; $i++) {
                if ($i > 0 && $nums[$i] == $nums[$i - 1]) continue;
                $d = [];
                for ($j = $i + 1; $j < $len; $j++) {
                    if (!$d[$nums[$j]]) {
                        $d[- $nums[$i] - $nums[$j]] = 1;
                    } else if ($d[$nums[$j]] == 1) {
                        $d[$nums[$j]] = 2;
                        $res[] = [$nums[$i], -$nums[$i]-$nums[$j], $nums[$j]];
                    }
                }
            }
            return $res;
        }
    }
    //方法三：排序 + 双指针
    class Solution {
        /**
         * @param Integer[] $nums
         * @return Integer[][]
         */
        function threeSum($nums) {
            sort($nums);//排序 O(NlogN)
          	$res = [];
          	for ($k = 0; $k < count($nums) - 2 && $nums[$k] < 1; $k++) {
              //如果k大于0，过滤重复数字
              if($k > 0 && $nums[$k-1] == $nums[$k]) continue;
              for ($i = $k + 1, $j = count($nums) - 1; $i < $j;) {
                $sum = $nums[$k] + $nums[$i] + $nums[$j];
               	if ($sum < 0) {
                   while ($i < $j && $nums[$i] == $nums[++$i]);
                } else if ($sum > 0) {
                   while ($i < $j && $nums[$j] == $nums[--$j]);
                } else {
                  //相等
                  $res[] = [$nums[$k], $nums[$i], $nums[$j]];
                  //过滤重复解
                  while ($i < $j && $nums[$i] == $nums[++$i]);
                  while ($i < $j && $nums[$j] == $nums[--$j]);
                }
              }
            }
            return $res;
        }
    }
    ```

    

## Linked List 实战题目

- #### [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

    ```php
    //方法一：迭代 （就地逆置法）
    /**
     * Definition for a singly-linked list.
     * class ListNode {
     *     public $val = 0;
     *     public $next = null;
     *     function __construct($val) { $this->val = $val; }
     * }
     */
    class Solution {
        /**
         * @param ListNode $head
         * @return ListNode
         */
        function reverseList($head) {
    		$pre = null;
            $cur = $head;
            while ($cur) {
                $next = $cur->next;
                $cur->next = $pre;
                $pre = $cur;
                $cur = $next;
            }
            return $pre;
        }
    }
    //方法二：头插法
    class Solution {
        /**
         * @param ListNode $head
         * @return ListNode
         */
        function reverseList($head) {
            $tmp_head = new ListNode(0);
            while ($head) {
                $tmp = $head->next;
                $head->next = $tmp_head->next;
                $tmp_head->next = $head;
                $head = $tmp;
            }
            return $tmp_head->next;
        }
    }
    //方法三：递归
    class Solution {
        /**
         * @param ListNode $head
         * @return ListNode
         */
        function reverseList($head) {
            if ($head == null || $head->next == null) return $head;
            $p = $this->reverseList($head->next);
            $head->next->next = $head;
            $head->next = null;
    		return $p;//$this->reverse($head);
        }
        function reverse($head) {
            if ($head == null || $head->next == null) {
                return $head;
            }
            $rhead = $this->reverse($head);
            $head->next->next = $head;
            $head->next = null;
            return $rhead;
        }
    }
    ```

- #### [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

    ```php
    /**
     * Definition for a singly-linked list.
     * class ListNode {
     *     public $val = 0;
     *     public $next = null;
     *     function __construct($val) { $this->val = $val; }
     * }
     */
    class Solution {
    
        /**
         * @param ListNode $head
         * @return ListNode
         */
        function swapPairs($head) {
            $dummy = new ListNode(0);
            $dummy->next = $head;
    		$pre = $dummy;
            while ($pre->next) {
                $a = $pre->next;
                $b = $a->next;
                //记录b指向的节点
                $next = $a->next->next;
                //交换位置
                $b->next = $a;
                $pre->next = $b;
                //连接后面节点
                $a->next = $next;
                $pre = $a;//移动头节点
            }
            return $dummy->next;
        }
    }
    ```

- #### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

    ```c++
    //方法一：hash表
    //方法二：快慢指针方法
    /**
     * Definition for singly-linked list.
     * struct ListNode {
     *     int val;
     *     ListNode *next;
     *     ListNode(int x) : val(x), next(NULL) {}
     * };
     */
    class Solution {
    public:
        bool hasCycle(ListNode *head) {
            ListNode *slow = head, *fast = head;
            while (fast && fast->next) {
                slow = slow->next;
                fast = fast->next->next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    };
    ```

- #### [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

    ```php
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //方法一：hash表
    //方法二：快慢指针方法
    class Solution {
    public:
        ListNode *detectCycle(ListNode *head) {
            ListNode *slow = head, *fast = head;
            while (fast && fast->next) {
                slow = slow->next;
                fast = fast->next->next;
                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow->next;
                        fast = fast->next;
                    }
                    return slow;
                }
            }
            return NULL;
        }
    };
    ```

- #### [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

    ```php
    /**
     * Definition for a singly-linked list.
     * class ListNode {
     *     public $val = 0;
     *     public $next = null;
     *     function __construct($val) { $this->val = $val; }
     * }
     */
    class Solution {
    
        /**
         * @param ListNode $head
         * @param Integer $k
         * @return ListNode
         */
        function reverseKGroup($head, $k) {
            $dummy = new ListNode(0);
            $dummy->next = $head;
            $pre = $dummy;
            $tail = $dummy;
            while ($pre->next) {
                for($i = 0; $i < $k && $tail; $i++) $tail = $tail->next;
                if (!$tail) break;
                //记录翻转后的尾部节点
                $head = $pre->next;
                //尾插法
                while($pre->next != $tail){
                    $cur = $pre->next;
                    $pre->next = $cur->next;
                    //插入尾部
                    $cur->next = $tail->next;
                    $tail->next = $cur;
                }
                $pre = $tail = $head;
            }
            return $dummy->next;
        }
        //方法二
        function reverseKGroup2($head, $k) {
         	$dummy = new ListNode(0);
            $dummy->next = $head;
            $pre = $end = $dummy;
            while ($end) {
                for ($i = 1; $i <= $k && $end; $i++) $end = $end->next;
                if (!$end) break;
                $start = $pre->next;
                $next = $end->next;
                $end->next = null;
                //翻转
                $pre->next = $this->reverse($start);
                $start->next = $next;
                $end = $pre = $start;
            }
            return $dummy->next;
        }
        
        //头插法
        function reverse($head) {
            $tmp_head = new ListNode(0);
            while ($head) {
                $tmp = $head->next;
                $head->next = $tmp_head->next;
                $tmp_head->next = $head;
                $head = $tmp;
            }
            return $tmp_head->next;
        }
    }
    
    
    ```

## 课后作业

- #### [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

    ```php
    //双指针
    class Solution {
    
        /**
         * @param Integer[] $nums
         * @return Integer
         */
        function removeDuplicates(&$nums) {
            if (empty($nums)) return 0;//异常情况
            $num = 0;
            for ($i = 1; $i < count($nums); $i++) {
                if ($nums[$num] != $nums[$i]) {
                    $nums[++$num] = $nums[$i];
                }
            }
    		return $num + 1;
        }
    }
    ```

    ```c++
    //双指针
    class Solution {
    public:
        int removeDuplicates(vector<int>& nums) {
            if (nums.size() == 0) return 0;
            int len = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums[len] != nums[i]) {
                    nums[++len] = nums[i];
                }
            }
            return len + 1;
        }
    };
    ```

- #### [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/)

    ```php
    //方法一：暴力（执行超时）
    class Solution {
    
        /**
         * @param Integer[] $nums
         * @param Integer $k
         * @return NULL
         */
        function rotate(&$nums, $k) {
            $tail = count($nums) - 1;
            while ($k--) {
                $last = $nums[$tail];
                for ($i = $tail - 1; $i >=0; $i--) {
                    $nums[$i+1] = $nums[$i];
                }
                $nums[0] = $last;
            }
        }
    }
    //方法二：借助新数组，直接将元素放到对应位置 (i + k) % 数组长度
    //方法三：使用环状替换
    class Solution {
    
        /**
         * @param Integer[] $nums
         * @param Integer $k
         * @return NULL
         */
        function rotate(&$nums, $k) {
            $len = count($nums);
            $k %= $len;
            for ($start = 0, $count = 0; $count < $len; $start++) {
                $current = $start; //记录当前位置
                $pre_num = $nums[$start]; //记录当前元素
                do {
                    //计算移动到位置
                    $next = ($current + $k) % $len;
                    $next_num = $nums[$next]; //暂存移动到位置的元素
                    $nums[$next] = $pre_num;
                    //重复上述过程， 直到current 与 start 相等 停止本次移动
                    $current = $next;
                    $pre_num = $next_num;
                    $count++;
                } while ($current != $start);
            }
        }
    }
    //方法四：三次翻转
    class Solution {
    
        /**
         * @param Integer[] $nums
         * @param Integer $k
         * @return NULL
         */
        function rotate(&$nums, $k) {
            $len = count($nums);
            //异常判断
            if ($len == 0) return;
            $k %= $len;
            $this->reverse($nums, 0, $len - 1);
            $this->reverse($nums, 0, $k - 1);
            $this->reverse($nums, $k, $len - 1);
        }
        function reverse(&$nums, $start, $end) {
            while ($start < $end) {
                $tmp = $nums[$end];
                $nums[$end--] = $nums[$start];
                $nums[$start++] = $tmp;
            }
        }
    }
    ```

- #### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

    ```php
    /**
     * Definition for a singly-linked list.
     * class ListNode {
     *     public $val = 0;
     *     public $next = null;
     *     function __construct($val) { $this->val = $val; }
     * }
     */
    class Solution {
        /**
         * @param ListNode $l1
         * @param ListNode $l2
         * @return ListNode
         */
        function mergeTwoLists($l1, $l2) {
            $head = new ListNode(0);
            $pre = $head;
            while ($l1 && $l2) {
                if ($l1->val < $l2->val) {
                    $pre->next = $l1;
                    $l1 = $l1->next;
                } else {
                    $pre->next = $l2;
                    $l2 = $l2->next;
                }
                $pre = $pre->next;
            }
            if ($l1) {
                $pre->next = $l1;
            } else {
                $pre->next = $l2;
            }
    		return $head->next;
        }
    }
    ```

    

- #### [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

    ```php
    //方法一 : 合并后排序
    //方法二 : 双指针 / 从前往后 (需要使用临时数组保存$nums1元素)
    //方法三 : 双指针 / 从后往前
    class Solution {
    
        /**
         * @param Integer[] $nums1
         * @param Integer $m
         * @param Integer[] $nums2
         * @param Integer $n
         * @return NULL
         */
        function merge(&$nums1, $m, $nums2, $n) {
            $right = $m + $n - 1;
            $p1 = $m - 1;
            $p2 = $n - 1;
            while ($p1 >= 0 && $p2 >= 0) {
                //这里可以改为 ?: 三元运算符
                //$nums1[$right--] = $nums1[$p1] < $nums2[$p2] ? $nums2[$p2--] : $nums1[$p1--];
            	if ($nums1[$p1] < $nums2[$p2]){
                    $nums1[$right--] = $nums2[$p2--];
                } else {
                    $nums1[$right--] = $nums1[$p1--];
                }
            }
            while ($p2 >= 0) {
                $nums1[$right--] = $nums2[$p2--];
            }
        }
    }
    ```

    

- #### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

    ```php
    // 方法一：暴力 两层循环
    class Solution {
    
        /**
         * @param Integer[] $nums
         * @param Integer $target
         * @return Integer[]
         */
        function twoSum($nums, $target) {
            $len = count($nums);
            for ($i = 0; $i < $len - 1; $i++) {
                for ($j = $i + 1; $j < $len; $j++) {
                    if ($nums[$i] + $nums[$j] == $target) {
                        return [$i, $j];
                    }
                }
            }
            return null;
        }
    }
    //方法二：hash表
    class Solution {
    
        /**
         * @param Integer[] $nums
         * @param Integer $target
         * @return Integer[]
         */
        function twoSum($nums, $target) {
            $hash = [];
            $hash[$nums[0]] = 0;
            for ($i = 1; $i < count($nums); $i++) {
                $diff = $target - $nums[$i];
                if (isset($hash[$diff])) {
                 	return [$hash[$diff], $i];
                }
                $hash[$nums[$i]] = $i;
            }
            return null;
        }
    }
    ```

    

- #### [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/)

    ```php
    //方法一：一次遍历，双指针
    class Solution {
        /**
         * @param Integer[] $nums
         * @return NULL
         */
        function moveZeroes(&$nums) {
            for ($i = 0, $j = 0; $i < count($nums); $i++) {
                if ($nums[$i] != 0) {
                    if ($i != $j) {
                        $nums[$j] = $nums[$i];
                        $nums[$i] = 0;
                    }
                    $j++;
                }
            }
        }
    }
    //方法二：
    class Solution {
        /**
         * @param Integer[] $nums
         * @return NULL
         * @ 思路：
         *   双指针方法，
         *    ① 变量"cur"表示快速指针，处理新元素。如果新找到的元素不是0，就在最后找到的非0元素之后记录它。
         *    ② 最后找到的非0元素的位置，由慢指针"lastnonzerofoundat"变量表示。当不断发现新的非0元素时，
         *      只是在"lastnonzerofoundat+1"第个索引处覆盖它们。此覆盖不会导致任何数据丢失，因为已经处理了
         *      其中的内容（如果是非0，则已经写入了相应的索引，或者如果是0，则稍后将进行处理）。
         *    ③ 在"cur"索引到达数组的末尾之后，现在知道所有非0元素，都已按原始顺序移动到数组的开头。
         *    ④ 将所有0移动到末尾，现在只需要在"lastnonzerofoundat"索引之后，用0填充所有索引。
         */
        function moveZeroes(&$nums) {
            // 最后找到的非零元素位置
            $lastnonzerofoundat = 0;
            
            // 找出所有非零元素，并按照原顺序放入数组
            for ($i = 0; $i < count($nums); $i++) {
                if ($nums[$i] != 0) {
                    $nums[$lastnonzerofoundat] = $nums[$i];
                    $lastnonzerofoundat++;
                }
            }
            // 从非零位置的末尾补充0的个数
            for ($i = $lastnonzerofoundat; $i < count($nums); $i++) {
                $nums[$i] = 0;
            }
        }
    }
    ```

    

- #### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

    ```php
    //三种情况 [1] [499] [99]
    class Solution {
        /**
         * @param Integer[] $digits
         * @return Integer[]
         */
        function plusOne($digits) {
            for ($len = count($digits) -1; $len >= 0; $len--) {
                $digits[$len] = ($digits[$len] + 1) % 10;
                if ($digits[$len] != 0) {
                    return $digits;
                }
            }
            array_unshift($digits, 1);
            return $digits;
        }
    }
    ```