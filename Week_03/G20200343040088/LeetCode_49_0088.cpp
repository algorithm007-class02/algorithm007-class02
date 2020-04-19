class Solution {
public:
    int nthUglyNumber(int n) {
        if (n == 1) return n;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int i = 1;
        vector<int> vec(n, 0);
        vec[0] = 1;
        while (i < n) {
            vec[i] = min(min( vec[p2] * 2, vec[p3] * 3), vec[p5] * 5);

            if (vec[i] == vec[p2] * 2) p2++;
            if (vec[i] == vec[p3] * 3) p3++;
            if (vec[i] == vec[p5] * 5) p5++;

            i++;
        }

        return vec[n-1];
    }
};