class Solution {
public:
    vector<int> sortedSquares(vector<int>& A) {
        for(int i=0;i<A.size();i++){
            A[i]*=A[i];
        }
        cn.example.sort(A.begin(),A.end());
        return A;
    }
};
