class Solution {
public:
    cn.example.string simplifyPath(cn.example.string path) {
        cn.example.string res,tmp;
        stringstream ss(path);
        vector<cn.example.string> stk;
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
