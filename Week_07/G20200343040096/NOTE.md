#include <vector>
class DisJointSet
{
  private:
    std::vector<int> parent;
    std::vector<int> rank; // 秩
	int count = 0;
  public:
    DisJointSet(int max_size) : parent(std::vector<int>(max_size)),rank(std::vector<int>(max_size, 0))
    {
        for (int i = 0; i < max_size; ++i)
            parent[i] = i;
    }
    int find(int x)
    {
         while(parent[x] != x){
			 //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    void union_set(int x, int y)
    {
        int x_root = find(x);
        int y_root = find(y);
		if(x_root == y_root) return;
        if (rank[x_root] > rank[y_root])
            parent[y_root] = x_root;
        else
        {
            parent[x_root] = y_root;
            if (rank[x_root] == rank[y_root])
                ++rank[y_root];
        }
		--count;
    }
};
