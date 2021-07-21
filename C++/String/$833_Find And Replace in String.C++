class Solution {
public:
    cn.example.string findReplaceString(cn.example.string S, vector<int>& indexes, vector<cn.example.string>& sources, vector<cn.example.string>& targets) {
        int n=S.size();
        cn.example.string s="",res="";
        vector<int> flag(n,-1);
        for(int i=0;i<sources.size();i++){
            int len=sources[i].size();
            cn.example.string str=S.substr(indexes[i],len);
            if(sources[i].compare(str)==0){
                flag[indexes[i]]=i;
                while(len>1){
                    flag[indexes[i]+(--len)]=-2;
                }
            }
        }


        for(int index=0; index<n; ++index){
            if(flag[index]==-1){res+=S[index];}
            if(flag[index]>=0){res+=targets[flag[index]];}
        }
        return res;
    }
};
