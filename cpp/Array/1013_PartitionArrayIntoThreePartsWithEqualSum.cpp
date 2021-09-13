#include <vector>
using namespace std;

class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& A) {
        int sum=0;
        for(auto num: A){
            sum+=num;
        }
        int ave=sum/3,tmp=0,count=0;
        for(auto num: A){
            tmp+=num;
            if(tmp==ave){
                count++;
                tmp=0;
            }
        }
        return count==3 && sum%3==0;
    }
};
