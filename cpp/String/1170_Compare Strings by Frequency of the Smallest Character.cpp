#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
    int f(string& str){//统计最小字母个数
        sort(str.begin(),str.end());
        int i;
        for(i=0 ; i<str.size() && str[0]==str[i] ; i++);
        return i;
    }
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        vector<int> res;
        vector<int> count(12,0);
        for(int i=0;i<words.size();i++){
            count[f(words[i])]++;
        }
        for(int i=9;i>=0;i--){
            count[i]+=count[i+1];
        }
        for(int i=0;i<queries.size();i++){
            res.push_back(count[f(queries[i])+1]);
        }
        return res;
    }
};
