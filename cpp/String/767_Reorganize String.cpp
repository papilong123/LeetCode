#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string reorganizeString(string S) {
        vector<int> count(26,0);
        vector<pair<int,char>> p;
        string res;
        int n=S.size();
        for(int i=0 ; i<n ; i++){
            count[S[i]-'a']++;
        }

        for(int i=0;i<26;i++){
            if( count[i] > (n+1)/2 ) return "";
            p.push_back({count[i],i+'a'});
        }

        sort(p.rbegin(),p.rend());

        string str;
        for(auto& tmp : p){
            str+=string(tmp.first,tmp.second);
        }

        for(int i=0,j=(n-1)/2+1 ; i<=(n-1)/2 ; i++,j++){
            res += str[i];
            if (j < n) res += str[j];
        }
        return res;
    }
};
