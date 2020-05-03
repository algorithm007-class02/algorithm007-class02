class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        generate(list,0,0,n,"");
        return list;
    }

    public void generate (List<String> list,int left,int right,int n,String curStr){
        if (left + right == n*2){ //如果符合结果，那么加入数组
            list.add(curStr);
            return;
        }
        if(left < right){//如果做括号数量小于右括号 那么其余的都不符合结果
            return;
        }
        if (left < n){//左括号不可大于总括号数量
            generate (list,left+1,right,n,curStr+"(");
        }
        if (right < n){//右括号不可大于总括号数量
            generate (list,left,right+1,n,curStr+")");
        }
    }
}