#include <vector>
#include <string>
#include <algorithm>
#include <map>

using namespace std;

bool cmp(pair<string,int> &a,pair<string,int> &b){
    return a.first.size()>b.first.size();
}

bool isS1subsOfS2(string &s1, string &s2){//判断s1是否是s2的子序列，即s2删除后的是否可为s1
    int j = 0, i = 0;
    for(; i < s1.size(); ++i){
        while(j < s2.size() && s1[i] != s2[j]) ++j;
        if(j == s2.size())
           return false;
        ++j;
    }
    return true;
}

class Solution {
public:
    int findLUSlength(vector<string>& strs) {
        map<string,int> m;
        vector<pair<string,int>> p;

        for(auto str: strs){//收集到哈希表中
            m[str]++;
        }

        for(auto pointer=m.begin();pointer!=m.end();pointer++){//哈希表转化为pair
            p.push_back(*pointer);
        }

        sort(p.begin(),p.end(),cmp);//按长度从大到小排序

        for(int i=0;i<p.size();i++){
            if(p[i].second==1){
                int j=0;
                for(;j<i;j++)
                    if(isS1subsOfS2(p[i].first, p[j].first)) break;
                if(i==j) return p[i].first.size();
            }
        }
        return -1;
    }
};
