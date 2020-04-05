## 第四周学习总结
### 一.题目
使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

#### 思路
> 对于数组[4, 5, 6, 7, 0, 1, 2]，返回 index = 4，也就是说从index = 4 开始，数组变得无序。

**数组按照递增顺序排列，也就是说，nums[mid] < nums[mid + 1]，nums[mid] > nums[mid - 1]。因此，一旦出现：nums[mid] > nums[mid + 1]，nums[mid] < nums[mid - 1]则说明违反了递增的规则，也就说明，数组从该位置起，则开始变得无序。**

#### 代码
```java
public static int findChange(int[] nums) {   
    if (nums.length == 1) {       
        return -1;   
    }    
    int left = 0, right = nums.length - 1;   
    // nums[left] < nums[right]说明数组为有序(从小到大排序)的,返回 -1    
    if (nums[left] < nums[right]) {        
        return -1;   
    }    
    while (right >= left) {        
        int mid = left + (right - left) / 2;
        // nums[mid] > nums[mid + 1]，说明nums[mid + 1]打断了递增顺序，mid + 1即为开始无序的地方
        if (nums[mid] > nums[mid + 1]) {            
            return mid + 1;        
        }
        // nums[mid] < nums[mid - 1]，说明nums[mid - 1]打断了递增顺序，mid - 1即为开始无序的地方
        if (nums[mid] < nums[mid - 1]) {            
            return mid;        
        }        
        if (nums[mid] > nums[0]) {            
            left = mid + 1;        
        } else {            
            right = mid - 1;        
        }    
    }    
    return -1;
}
```
### 二.本周遇到的小知识点
#### 关于二维数组
```java
package week04.g20200343040172;

public class Main {    
    public static void main(String[] args) {       
        int[ ][ ] a = { };       
        int[ ][ ] b = {{ }};       
        System.out.println("a.length: " + a.length);       
        try {            
            System.out.println("a[0].length: " + a[0].length);       
        } catch (Exception e) {           
            e.printStackTrace();       
        }       
        System.out.println("Is a equals null?: " + (a == null));        
        System.out.println("b.length: " + b.length);        
        System.out.println("b[0].length: " + b[0].length);        
        System.out.println("Is b equals null?: " + (b == null));   
    }
}
```
**打印结果**

**System.out.println("a[0].length: " + a[0].length)** 为第九行，报错！！

> a.length: 0
Is a equals null?: false
b.length: 1
b[0].length: 0
Is b equals null?: false
java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
	at week04.g20200343040172.Main.main(Main.java:9)
    
对于二维数组
```java
int[ ][ ] a = { };
int[ ][ ] b = {{ }};   
```
* **a.length**打印的是二维矩阵的行的数量，对于M×N的数组而言，a.length对应的就是M。可以把一行看成一个整体，一个二维数组有多少行，里面就有多少个元素。这么来看的话，其实就可以把二维数组当成一个一维数组。
* **a[0].length**打印的是二维矩阵的列的数量，对于M×N的数组而言，a[0].length对应的就是N。

---
 * 对于 int[ ][ ] a = { }。如果我们把一行看作一个元素的话，现在里面完完全全就是空的。我们想当然认为a[0]表示第一行的元素，但是此时里面根本就没有初始化，索引0对应的是哪块区域，索引1对应的是哪块区域，根本就没有划分出来，于是，用索引0去寻找a[0]这个元素的时候，会发现什么都找不到。因为根本就没有a[0]这个元素。对应于下面的一维数组，同样也是如此。
 ```java
int[ ] c = { };
System.out.println("c.length: " + c.length); //打印0
System.out.println(c[0]); // ArrayIndexOutOfBoundsException

int[ ] d = new int[10];
System.out.println("d.length: " + d.length); //打印10
System.out.println(d[0]); //打印0
```
* 对于int[ ][ ] b = {{ }}。同样的，我们如果把一行看作一个元素的话，里面有一个空的括号，表示该行什么元素都没有，但是与int[ ][ ] a = { }不同的是，虽然b里面第一个元素为空，但是b为第一行的元素也就是b[0]已经分配了一块地址，它告诉程序员：“好了，我已经为第一行的元素腾出来一块空间，你赶紧把元素放进来吧。"虽然此时的b[0]里面没有放任何元素，但是起码b[0]是有名有姓的。所以b[0].length不会出错。
而int[ ][ ] a = { }却根本就没有为a[0]这个元素开辟空间，连a[0]是谁，对于a这个二维数组而言都不知道。所以用a[0].length会出错。

#### 二维的List
类比于上面的二维数组，二维的List就可以这么写：
```java
List<List<Integer>> list = new ArrayList<>();
list.get(0).add(1); //为list里面的第一个list添加一个元素1
```
### 三.使用String构造字符串


[LeetCode-874. 模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/)
在本题中对于网格点上的障碍物，有两种表示方式，**一种方法是使用long来保存坐标，结合移位，能保证每一个障碍物的坐标都有一个唯一映射的值**。**另一种方式则是构造一个字符串**，但是在构造字符串的时候有一点小小的坑。比如对于(ox,oy)这个坐标，最开始我是这样写的。莫名其妙的就报错了。
```java
 String str = " " + ox + oy;
```
而采用这样的写法就能顺利通过
```java
 String str = ox + " "  + oy;
```
为什么呢？因为第一种写法构造的字符串不能唯一的映射一个坐标。比如用第一种构造方式，得到了这样一个值
```java
str = " 123"
```
那str可以对应两个坐标，(1,23)和(12,3)。这明显就会带来很多问题。题目的关键就是确定障碍物的坐标位置，遇到障碍物，则无法前进，如果连障碍物的坐标表示都有问题，自然得到的结果就会千奇百怪。
 





