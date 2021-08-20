class Solution {
public:
    bool isMonotonic(vector<int>& A) {
        bool up=true,down=true;
        for(int i=0;i<A.size()-1;i++)
            up &= A[i]<=A[i+1], down &= A[i]>=A[i+1];
        return up||down;
    }
};
