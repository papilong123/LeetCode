class Solution {
public:
    int maximum69Number (int num) {
        int res;
        cn.example.string str=to_string(num);
        for(auto& c:str){
            if(c=='6'){
                c='9';
                break;
            }
        }
        return stoi(str);
    }
};
