学习笔记

#### 题号：49、字母异位词分组
该题首先想到的是对数组中的每个字符做归一化处理，然后再排序，用排序后的做key,构建二维数组，最后返回数组的values
```php
function groupAnagrams($strs) {
        
        $result = [];

        foreach($strs as $val) {
            $temp = $this->returnOrdSum($val);
            $result[$temp][] = $val;
        }
        
        return array_values($result);

    }


    function returnOrdSum($str) {

        $ordArr = [];
        $len = strlen($str);

        for ($i=0; $i < $len; $i++) { 
            # code...
            $ordArr[] = ord($str[$i]);
        }

        sort($ordArr);

        return implode('', $ordArr);

    }
```
看其他人的题解有将26个字母映射为素数，构建一个无冲突的hash
```php
    function groupAnagrams($strs) {
        $resArr = [];
        // 将 26 个字母映射为 素数，求积可得唯一 key，相当于一个无冲突的 hash function
        $prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103];
        foreach ($strs as $str) {
            $strlen = 1;
            for ($i = 0; $i < strlen($str); $i++) {
                $strlen *= $prime[ord($str[$i]) - 97];
            }
            $resArr[$strlen][] = $str;
        }
        return array_values($resArr);
    }
```


#### 题号：641、设计循环双端队列
该题初看没思路[🤦‍♂️]。对题解中的解题思路还需要再多看几遍才能明白。

#### 题号：42、接雨水
参考双指针的解题思路：
```php
function trap($height) {
        $count = count($height);
        if ($count <= 1) {
            return 0;
        }

        $result = 0;
        $maxLeft = $maxRight = array_fill(0, $count, 0);

        // 从左向右计算左侧最高
        for ($i = 1; $i < $count; ++$i) {
            $maxLeft[$i] = max($maxLeft[$i - 1], $height[$i - 1]);
        }
        
        // 从右向左计算右侧最高
        for ($i = $count - 1; $i > 0; --$i) {
            $maxRight[$i] = max($maxRight[$i + 1], $height[$i + 1]);
        }

        for ($i = 1; $i < $count - 1; ++$i) {
            $diff = min($maxLeft[$i], $maxRight[$i]) - $height[$i];
            if ($diff > 0) {
                $result += $diff;
            }
        }

        return $result;
    }
```
看解题思路有动态规划和简单的暴力法，还需要再多练习掌握[🤦‍♂️]