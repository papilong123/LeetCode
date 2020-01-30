class Solution {
public:
    string simplifyPath(string path) {
        string res,tmp;
        stringstream ss(path);
        vector<string> stk;
        while(getline(ss,tmp,'/')){
            if(tmp==""||tmp==".") continue;
            else if(tmp==".." && !stk.empty()){
                stk.pop_back();
            }else if(tmp!=".."){
                stk.push_back(tmp);
            }
        }
        for(auto str:stk){
            res+="/"+str;
        }
        if(res=="") res+="/";
        return res;
    }
};
