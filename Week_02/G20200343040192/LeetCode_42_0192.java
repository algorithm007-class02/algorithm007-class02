class Solution{

  /**
   * 一开始想到用栈了，但是没有往括号匹配弹出的方面想
   * 拍脑袋认为碰到比栈顶大的弹空栈即可，弹空的数量就是面积
   * 一看人家的解法就懂了
   * @param height
   * @return
   */
  public int trap(int[] height) {
    int sum = 0;
    Stack<Integer> stack = new Stack<>();
    int current = 0;
    while (current < height.length) {
      //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
      while (!stack.empty() && height[current] > height[stack.peek()]) {
        int h = height[stack.peek()]; //取出要出栈的元素
        stack.pop(); //出栈
        if (stack.empty()) { // 栈空就出去
          break;
        }
        int distance = current - stack.peek() - 1; //两堵墙之前的距离。
        int min = Math.min(height[stack.peek()], height[current]);
        sum = sum + distance * (min - h);
      }
      stack.push(current); //当前指向的墙入栈
      current++; //指针后移
    }
    return sum;
  }
}

//class Solution {
//  public int trap(int[] height) {
//    Stack<Integer> stack = new Stack<>();
//    int water = 0;
//    for (int i =0 ;i< height.length;++i){
//      if (i == 0){
//        stack.push(height[i]);
//        continue;
//      }
//      if (height[i]>=stack.peek()){
//        water+=stack.elementAt(0) *stack.size();
//      }
//    }
//  }
//}