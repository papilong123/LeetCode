class Solution {
public:
    vector<cn.example.string> wordSubsets(vector<cn.example.string>& A, vector<cn.example.string>& B) {
        vector<cn.example.string> res;

        int B_max[26]={};
        for(int i=0;i<B.size();i++){
            int tmp[26]={};
            for(int j=0;j<B[i].size();j++){
                tmp[B[i][j]-'a']++;
                B_max[B[i][j]-'a']=max(B_max[B[i][j]-'a'],tmp[B[i][j]-'a']);//获得最大收集到的元素哈希表
            }
        }


        for(int i=0;i<A.size();i++){                    //和A中元素个数比较
            int A_max[26]={};                           //每个单词元素个数的哈希表
            for(int j=0;j<A[i].size();j++){
                A_max[A[i][j]-'a']++;
            }
            int k=0;
            while(k<26 && B_max[k]<=A_max[k]) k++;
            if(k==26)  res.push_back(A[i]);
        }

        return res;
    }
};
