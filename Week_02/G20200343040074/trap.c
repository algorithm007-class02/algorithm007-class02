//暴力法
//思想:当前位置两边最大高度的较小值减去当前高度的值即为该位置能存的雨量，每个位置能存的雨量的和即为能接到的总雨量
#include <stdio.h>
#include <string.h>
int trap(int* height, int heightSize){
    int ans = 0;
    int i,j;
    int min=-1;
    for(i=1; i< heightSize;i++){
        int max_left = 0,max_right = 0;
        printf("current:%d\n",height[i]);
        for(j=i;j>=0;j--){
            if(max_left<height[j])
                max_left = height[j];
        }

        for(j=i;j<heightSize;j++){
            if(max_right < height[j])
                max_right = height[j];
        }
        
        printf("max_lef:%d\n",max_left);
        printf("max_right:%d\n",max_right);
        min = (max_left > max_right) ? max_right : max_left;
        ans += min - height[i];
        printf("ans=%d\n",ans);


    }
    return ans;
}
//动态编程
//在暴力方法中，我们仅仅为了找到最大值每次都要向左和向右扫描一次。但是我们可以提前存储这个值。因此，可以通过动态编程解决。
int trap_2(int * height, int heightSize){
    int sum = 0;
    int max_left[heightSize];
    int max_right[heightSize];
    bzero(max_left,sizeof(max_left));
    bzero(max_right,sizeof(max_right));
    int i;
    for(i=1;i<heightSize-1;i++){
        max_left[i] = max_left[i-1]>height[i-1]?max_left[i-1]:height[i-1];
        printf("max_left[%d]=%d,",i,max_left[i]);
    }
    printf("\n");
    for(i=heightSize-2;i>=0;i--){
        max_right[i] = max_right[i + 1] > height[i + 1] ? max_right[i + 1]:height[i + 1];
        printf("max_right[%d]=%d,",i,max_right[i]);
    }
    printf("\n");
    for(i=1;i< heightSize-1;i++){
        int min = max_left[i]<max_right[i]?max_left[i]:max_right[i];
        printf("min=%d,",min);
        
        if(min>height[i])
            sum +=min - height[i];

    }
    return sum;
}

//栈的应用
//
//
//略


//方法三:双向指针
//
int trap_3(int * height, int heightSize){
    int left=1,right=heightSize-1;
    int ans = 0;
    int left_max=0,right_max=0;
    while(left < right){
        if(height[left] < height[right]){
            //height[left] >= left_max ? (left_max = height[left]) : (ans+=(left_max - height[left]));
            if(height[left] >= left_max)
                left_max = height[left];
            ans+=left_max - height[left];
            left++;
        }else{
            //height[right] >= right_max ?(right_max = height[right]):(ans+=(right_max - height[left]));
            if(height[right] >= right_max)
                right_max = height[right];
            ans += right_max - height[left];
            right--;
        }
    }
    return ans;
}


int trap_4(int * height, int heightSize){
    int sum = 0;
    int max_left = 0;
    int max_right = 0;
    int left = 1;
    int right = heightSize - 2; // 加右指针进去
    int i;
    for (i = 1; i < heightSize - 1; i++) {
        //从左到右更
        if (height[left - 1] < height[right + 1]) {
            max_left = max_left>height[left - 1]?max_left:height[left - 1];
            int min = max_left;
            if (min > height[left]) {
                sum = sum + (min - height[left]);
            }
            left++;
        //从右到左更
        } else {
            max_right = max_right>height[right + 1]?max_right:height[right + 1];
            int min = max_right;
            if (min > height[right]) {
                sum = sum + (min - height[right]);
            }
            right--;
        }
    }
    return sum;
}


int main(){
    int heights[]={0,1,0,2,1,0,1,3,2,1,2,1};
    int ret=-1;
    ret = trap_3(heights,12);
    printf("ret=%d\n",ret);


}

