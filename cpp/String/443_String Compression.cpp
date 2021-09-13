#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int compress(vector<char>& chars) {
        int anchor=0,k=0;
        for(int i=0;i<chars.size();i++){
            if(i==chars.size()-1||chars[i]!=chars[i+1]){
                chars[k++]=chars[anchor];
                if(i>anchor){
                    for(char c: to_string(i-anchor+1)){
                        chars[k++]=c;
                    }
                }
                anchor=i+1;
            }
        }
        return k;
    }
};
