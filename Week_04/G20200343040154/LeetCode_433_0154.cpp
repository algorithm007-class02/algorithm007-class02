// 433. 最小基因变化
// https://leetcode-cn.com/problems/minimum-genetic-mutation/
// [待补齐]1.find函数的使用：https://blog.csdn.net/zhangweijiqn/article/details/9107571
// [待补齐]2.string的常用API

// 解法1:单向BFS
// 来自：https://leetcode-cn.com/problems/minimum-genetic-mutation/solution/liang-chong-fang-fa-dan-xiang-bfsjie-ti-shuang-xia/
//本题为图论中的求两个顶点的最短路径的经典例题，所以我们可利用BFS遍历出最短路径便可得到结果了。
//1）排除边界条件：start或end空或bank为空或end不在bank中。
//2）bfs的初始化工作：初始化步长，初始化queue，将start入队列，用vecotr来标记已经访问过的点。
//3）进行bfs：先将步长+1，然后确定每次bfs的长度size，寻找目标基因，然后出栈入栈等操作。
class Solution {
public:
	int minMutation(string start, string end, vector<string>& bank) {
		// 1.判读极端情况
		if (start.empty() || end.empty() || bank.empty()) return -1;
		if (find(bank.begin(), bank.end(), end) == bank.end()) return -1; // 基因不在基因库中

		// 2.初始化BFS
		vector<int> visit(bank.size(), 0);
		queue<string> q;
		int step = 0;
		q.push(start);

		// 3.进行BFS
		while(!q.empty()) {
			step++;
			int n = q.size(); //确定每次bfs的宽度
			// n=1
			for(int i =0; i<n; i++) {
				// tmp: "AACCGGTT"
				string &tmp = q.front(); //获得队头元素
				q.pop();
				// bank.size()=3
				for (int j = 0; j<bank.size(); j++) { //遍历整个基因库,访问未标记的基因；找到某个字符变异的基因添加标记，并进入队列即可
					if (visit[j] == 0) {
						int diff = 0;
						// bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
						// bank[j=0]="AACCGGTA"
						// bank[j=0].size()=8
						for (int k=0; k<bank[j].size();k++) {
							if (tmp[k] != bank[j][k]) diff++;
						}
						if (diff == 1) { //找到某个字符变异的基因
							if (bank[j] == end) return step; // 若该下表j代表的基因为目标基因，则直接返回步长
							visit[j] = 1; // 标记下标为j的基因已访问
							q.push(bank[j]);
						}
					}
				}
			}
		}
		return -1;
	}
};

