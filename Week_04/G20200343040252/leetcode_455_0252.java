class Solution {
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child=0,cookie=0;
        while(child<children.length && cookie<cookies.length){
            if(children[child]<=cookies[cookie]) child++;
            cookie++;    
        }   
        return child;
    }
}
