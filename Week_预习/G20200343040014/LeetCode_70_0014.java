    // 0,1,1,2,3,5,8,13,21,34,55,89,144,233,370...
    static int count = 0;
    public int fib (int n){
        count++;
        if (n <= 1 ) {
            return n;
        }
        System.out.println("现在是"+n);
        return fib(n-1) + fib(n-2);
    }

    public int fib2 (int n){
        int cun = 0;
        int next = 1;
        for (int i = 2; i < n ; i++) {
            int temp = next;
            next = cun +next;
            cun = temp;
        }
        return cun + next;
    }