#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    bool detectCapitalUse(string word) {
        int k=0;
        for(int i=0;i<word.size();i++){
            if( isupper(word[i]) && k++ < i){
                return false;
            }
        }
        return k==word.size() ||k<=1;
    }
};
