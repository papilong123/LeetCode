class Solution {
public:
    bool judgeCircle(string moves) {
        int r=0,l=0,u=0,d=0;
        for(char c: moves){
            if(c=='R'){
                r+=1;
            }else if(c=='L'){
                l+=1;
            }else if(c=='U'){
                u+=1;
            }else{
                d+=1;
            }
        }
        if(r!=l || u!=d){
            return false;
        }
        return true;
    }
};
