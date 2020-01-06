class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        vector<int> ans;

        for(int i=0;i<A.size();i++){
            if(A[i] % 2 == 0){
                ans.push_back(A[i]);
            }
        }

        int k=1;
        for(int i=0;i<A.size();i++){
            if( A[i] % 2 == 1){
                ans.insert(ans.begin()+k,A[i]);
                k+=2;
            }
        }
        return ans;
    }
};
