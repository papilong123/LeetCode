#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int findTheLongestSubstring(string s) {
        unordered_map<int,int> m{{0,-1}};//每个元素出现次数都为偶数
        //-1 stands for the empty (sub)string and 0 stands for the appeared times of "aeiou" are
        // all even (to be specific, all zero indeed). To be clarified, -1 works well when we
        // calculate the substring length: i - (-1) = i + 1 which means the whole substring from 0 to i included.
        int res=0,cur=0,state=0;
        for(int i=0;i<s.size();i++){
            cur^=1<<string("aeiou").find(s[i])+1>>1;//记录此时0到i字串的状态，抵消find()函数返回的-1
            if(!m.count(cur)) m[cur]=i;
            res=max(res,i-m[cur]);//取i+1到j之间的子串
        }
        return res;
    }
};
