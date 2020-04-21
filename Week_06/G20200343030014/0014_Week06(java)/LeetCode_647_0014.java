
public  class Solution2 {
    public int countSubstrings(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        int sum=0;
        int n=s.length();
        sum+=n;
        boolean [][]count_palindrome=new boolean[n][n];
        for(int i=0;i<n;i++) count_palindrome[i][i]=true;


        for(int r=2;r<=n;r++){
            for(int i=0;i<n-r+1;i++){
                int j=i+r-1;
                if(r==2){
                    if(s.charAt(i)==s.charAt(j)){count_palindrome[i][j]=true; sum+=1;}
                    else count_palindrome[i][j]=false;
                }else{
                    count_palindrome[i][j]=count_palindrome[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                    if(count_palindrome[i][j]) sum+=1;
                }

            }

        }

        return sum;

    }
}
