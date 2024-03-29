#include <vector>
#include <string>
#include <climits>

using namespace std;

class Solution {
public:
    vector<string> commonChars(vector<string>& A) {
        vector<string> res;

        vector<int> vals(26,INT_MAX);

        for(int i=0;i<A.size();i++){
            vector<int> nums(26,0);
            for(int j=0;j<A[i].size();j++){
                nums[A[i][j]-'a']++;
            }
            for(int i=0;i<26;i++){
                vals[i]=min(vals[i],nums[i]);
            }
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<vals[i];j++){
                res.push_back(string(1,i+'a'));
            }
        }
        return res;
    }
};
