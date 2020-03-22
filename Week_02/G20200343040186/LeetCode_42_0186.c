/* 双指针 */
int trap(int* height, int heightSize){
    if (height == NULL || heightSize == 0)
        return 0;

    int sum = 0;
    int leftmax = 0;
    int rightmax = 0;
    int left = 0;
    int right = heightSize-1;

    while (left < right)
    {
        if (height[left] < height[right])
        {
            leftmax = leftmax < height[left] ? height[left] : leftmax;

            sum += (leftmax - height[left]); 
            left++;
        }
        else
        {
            rightmax = rightmax < height[right] ? height[right] : rightmax;

            sum += (rightmax - height[right]);
            right--;
        }
    }

    return sum;
}

/* 使用栈 */
typedef struct stack_tag
{
    int value;
    struct stack_tag *next;
}MyStack;

typedef struct stackhead_tag
{
    int count;
    MyStack *next;
}MyStackHead;

int stackIsempty(MyStackHead *stackHead)
{
    if (stackHead == NULL)
        return 1;

    return stackHead->count == 0 ? 1 : 0;
}

int stackPeek(MyStackHead *stackHead)
{
    if (stackHead == NULL || stackHead->next == NULL)
        return 0;

    MyStack *stacknode = stackHead->next;

    return stacknode->value;
}

void stackPush(MyStackHead *stackHead, int value)
{
    if (stackHead == NULL)
        return ;

    MyStack *pushnode = (MyStack *)malloc(sizeof(MyStack));
    if (pushnode == NULL)
        return ;

    memset(pushnode, 0, sizeof(MyStack));

    pushnode->value = value;
    pushnode->next = stackHead->next;
    stackHead->next = pushnode;

    stackHead->count++;

    return ;
}

int stackPop(MyStackHead *stackHead)
{
    if (stackHead == NULL || stackHead->next == NULL)
        return 0;

    int popvalue = 0;
    MyStack *stacknode = stackHead->next;
    stackHead->next = stacknode->next;

    popvalue = stacknode->value;
    free(stacknode);
    stacknode = NULL;

    stackHead->count--;

    return popvalue;
}

int trap(int* height, int heightSize)
{
    int outsum = 0;
    int i = 0;
    MyStackHead *stackHead = NULL;

    stackHead = (MyStackHead *)malloc(sizeof(MyStackHead));
    if (stackHead == NULL)
        return -1;

    memset(stackHead, 0, sizeof(MyStackHead));

    int y1 = 0;
    int y2 = 0;

    for (i = 0; i < heightSize; i++)
    {
            while (stackIsempty(stackHead) != 1 && height[i] >= height[stackPeek(stackHead)])
            {
                y1 = height[stackPop(stackHead)];

                if (stackIsempty(stackHead) == 1)
                    break;

                y2 = (height[i] < height[stackPeek(stackHead)]) ? height[i] : height[stackPeek(stackHead)];
                outsum += (i - stackPeek(stackHead) - 1) * (y2 - y1);
            }

            stackPush(stackHead, i);
    }

    stackPop(stackHead);
    free(stackHead);
    stackHead = NULL;

    return outsum;
}
