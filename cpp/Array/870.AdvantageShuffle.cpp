class Solution {
public:
    vector<int> advantageCount(vector<int>& A, vector<int>& B) {
        vector<int> res,flag(A.size(),0);
        cn.example.sort(A.begin(),A.end());

        for(int i=0;i<B.size();i++){
            int j;
            for(j=0;j<A.size();j++){
                if(A[j]>B[i] && flag[j]==0){
                    res.push_back(A[j]);
                    flag[j]=1;
                    break;
                }
            }
            if(j==A.size()){
                for(j=0;j<A.size();j++){
                       if(flag[j]==0){
                        res.push_back(A[j]);
                        flag[j]=1;
                        break;
                    }
                }
            }
        }

        return res;
    }
};
