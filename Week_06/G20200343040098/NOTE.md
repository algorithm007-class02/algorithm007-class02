### 递归(recursion)
代码模板：
```
public void recur(int level, int param) { 

  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }

  // process current logic 
  process(level, param); 

  // drill down 
  recur( level: level + 1, newParam); 

  // restore current status 
}
```

### 分治(Divide&Conquer)
是递归的一种特殊形式，将大的问题分解为子问题
```
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

### 需要注意点
1.人肉递归低效、很累
2.找到最近最简方法，将其拆解成可重复解决问题
3.数学归纳法思维(抵制人肉递归的诱惑)

本质：寻找重复性->计算机指令集

### 动态规划(Dynamic Programming)
1.WIKI定义:https://en.wikipedia.org/wiki/Dynamic_programming

2.simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner. 

3.Divide & Conquer + Optimal substructure
  分治+最优子结构
  
 #### 关键点
 动态规划和递归或者分治没有根本上的区别(关键看有无最优的子结构)
  
 共性：找到重复问题
 
 差异性：最优子结构、中途可以淘汰次优解