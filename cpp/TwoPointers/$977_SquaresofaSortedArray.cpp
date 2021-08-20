class Solution {
public:
    vector<int> sortedSquares(vector<int>& A) {
        vector<int> res;
        int i=0,j=A.size()-1;
        while(i<=j){
            if(A[i]*A[i]>A[j]*A[j]) {
                res.push_back(A[i]*A[i]);
                i++;
            }
            else{
                res.push_back(A[j]*A[j]);
                j--;
            }
        }
        reverse(res.begin(),res.end());
        return res;
    }
};
