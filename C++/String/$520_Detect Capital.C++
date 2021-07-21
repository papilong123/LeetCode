class Solution {
public:
    bool detectCapitalUse(cn.example.string word) {
        int k=0;
        for(int i=0;i<word.size();i++){
            if( isupper(word[i]) && k++ < i){
                return false;
            }
        }
        return k==word.size() ||k<=1;
    }
};
