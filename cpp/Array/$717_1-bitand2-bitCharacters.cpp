class Solution {
public:
    bool isOneBitCharacter(vector<int>& bits) {
        int i=0;
        for(;i<bits.size()-1;){
            if(bits[i]==1) i+=2;
            else i+=1;
        }
        if(i==bits.size()) return false;
        return true;
    }
};
