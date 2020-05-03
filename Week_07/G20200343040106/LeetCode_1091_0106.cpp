class Solution {
public:
    class Compare {
    public:
        bool operator() (pair<pair<int,int>,pair<int,int>>& p1,pair<pair<int,int>,pair<int,int>>& p2) {
            pair<int,int> x = p1.first;
            pair<int,int> y = p2.first;
            int far = p1.second.first;
            /*
            return max(far-1-x.first,far-1-x.second)+p1.second.second > max(far-1-y.first,far-1-y.second) + p2.second.second;*/
            /*
            return abs(x.first-far)+abs(x.second-far) > abs(y.first - far) + abs(y.second-far) ;*/
        }
    };

    int d[8][2] = {{1,0},{0,1},{-1,0},{0,-1},{1,-1},{1,1},{-1,1},{-1,-1}};
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n =grid.size();
        if(n == 0||grid[0][0]==1||n!=grid[0].size()) return -1;
        if(n == 1) return 1;
        priority_queue<pair<pair<int,int>,pair<int,int>>,vector<pair<pair<int,int>,pair<int,int>>>,Compare> q;
        map<pair<int,int>,int> isvisited;
        q.push(make_pair(make_pair(0,0),make_pair(n,1)));
        isvisited[make_pair(0,0)] = 1;
        while(!q.empty()){
            pair<pair<int,int>,pair<int,int>> frontier = q.top();
            q.pop();
            int curstep = frontier.second.second;
            int x = frontier.first.first;
            int y = frontier.first.second;
            cout<<x<<" "<<y<<endl;
            if(x==n-1&&y==n-1) return curstep;
            for(int i=0;i<8;i++){
                int newx = x+d[i][0];
                int newy = y+d[i][1];
                if(!(newx>=0&&newx<n&&newy>=0&&newy<n)) continue;
                if(grid[newx][newy]==1) continue;
                if(isvisited.find(make_pair(newx,newy))==isvisited.end()||isvisited[make_pair(newx,newy)]>curstep+1) {
                    q.push(make_pair(make_pair(newx,newy),make_pair(n,curstep+1)));
                    isvisited[make_pair(newx,newy)] = curstep+1;
                }
            }
            
        }

        return -1;
    }
};