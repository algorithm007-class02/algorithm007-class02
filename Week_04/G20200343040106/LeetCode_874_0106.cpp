// reading comprehension

class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int dx[4] = {0,-1,0,1};
        int dy[4] = {1,0,-1,0};
        int curx = 0;
        int cury = 0;
        int curDirection = 0;
        int ans = 0;
        set<pair<int,int>> record;
        for(int i=0;i<obstacles.size();i++){
            record.insert(make_pair(obstacles[i][0],obstacles[i][1]));
        }

        for(int i=0;i<commands.size();i++){
            if(commands[i]==-2){
                curDirection = (curDirection+1)%4;
            }else if(commands[i]==-1){
                curDirection = (curDirection+3)%4;
            }else{
                int n = commands[i];
                while(n--){
                    int tempx = curx+dx[curDirection];
                    int tempy = cury+dy[curDirection];
                    if(record.find(make_pair(tempx,tempy))==record.end()){
                        curx = tempx;
                        cury = tempy;
                        ans = max(ans,abs(curx*curx+cury*cury));
                    }
                }
            }
        }
        return ans;
    }
};