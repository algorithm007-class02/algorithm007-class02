class Solution {
public:
    int minMutation(string start, string end, vector<string>& bank) {
            set<string> setHelp;
            for (auto s : bank) {
                setHelp.insert(s);
            }

            if (setHelp.find(end) == setHelp.end()) return -1;

            char four[4] = {'A', 'C', 'G', 'T'};

            queue<string> queueHelp;
            queueHelp.push(start);

            int step = 0;
            while(!queueHelp.empty()) {
                step++;
                for (int count = queueHelp.size(); count > 0; count--) {
                    string temp = queueHelp.front();
                    queueHelp.pop();
                    for (int i = 0; i < temp.size(); i++) {
                        char old = temp[i];

                        for (int j = 0; j < 4; j++) {
                            temp[i] = four[j];

                            string newstr = temp;
                            if (end == newstr) {
                                return step;
                            } else if (setHelp.find(newstr) != setHelp.end()) {
                                setHelp.erase(newstr);
                                queueHelp.push(newstr);
                            }
                        }

                        temp[i] = old;
                    }
                }
            }

            return -1;
    }
};