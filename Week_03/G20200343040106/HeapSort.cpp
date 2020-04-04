class HeapSort{
    public:
        void heapSort(vector<int>& nums){
            int n = nums.size();
            //build a max heap
            buildHeap(nums);
            //One by one extrace maximum form heap
            for(int i=n-1;i>=0;i--){
                swap(nums[0],nums[i]);
                heapify(nums,i,0);  
            }
            return ;
        }

        void buildHeap(vector<int>& nums){
            //O(N) time complexity
            int n = nums.size();
            for(int i=n/2;i>=0;i--){
                heapify(nums,n,i);
            }
        }

        void heapify(vector<int>& nums,int n,int i){
            int largest = i;
            int lchild = 2*i+1;
            int rchild = 2*i+2;
            if(lchild<n && nums[lchild]>nums[largest])
                largest = lchild;
            if(rchild<n && nums[rchild]>nums[largest])
                largest = rchild;
            if(largest != i){
                swap(nums[i],nums[largest]);
                heapify(nums,n,largest);
            }

        }
};
