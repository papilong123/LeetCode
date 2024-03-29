#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string sortString(string s) {
        string res;
        int count[26]={0};
        for(char c:s){
            count[c-'a']++;
        }
        for(int num=s.size();num>0;){
            for(int i=0;i<26;i++){
                if(count[i]>0){
                    count[i]--;
                    num--;
                    res.push_back(i+'a');
                }
            }
            for(int i=25;i>=0;i--){
                if(count[i]>0){
                    count[i]--;
                    num--;
                    res.push_back(i+'a');
                }
            }
        }
        return res;
    }
};
