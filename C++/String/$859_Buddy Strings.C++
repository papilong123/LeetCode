class Solution {
public:
    bool buddyStrings(string& A, string& B) {
        if(A.size()!=B.size()) return false;
        vector<int> res;
        for(int i=0;i<A.size();i++){
            if(A[i]!=B[i]){
                res.push_back(i);
                if(res.size()>2) return false;
            }
        }
        if(res.size()==0){
            return set<char>(A.begin(),A.end()).size()<A.size();
        }else if(res.size()==2){
            return A[res[0]]==B[res[1]] && A[res[1]]==B[res[0]];
        }
        return false;
    }
};
