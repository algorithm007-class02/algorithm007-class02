/**
 * 455. 分发饼干
 * */

void sort(int* Nums,int Low,int High)
{
    if(Low<High)
    {
        int i=Low,j=High,temp=Nums[Low];
        while(i!=j)
        {
            while(i<j&&temp<Nums[j])--j;
            if(i<j)Nums[i++]=Nums[j];
            while(i<j&&temp>Nums[i])++i;
            if(i<j)Nums[j--]=Nums[i];
        }
        Nums[i]=temp;
        sort(Nums,Low,i-1);
        sort(Nums,i+1,High);
    }
}


int findContentChildren(int* g, int gSize, int* s, int sSize){
    sort(g,0,gSize-1);
    sort(s,0,sSize-1);
    
    int i=0;
    for(int j=0;i<gSize&&j<sSize;++j) {
        if(g[i] <= s[j]) ++i;
    }

    return i;
}