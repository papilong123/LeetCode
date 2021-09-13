#include <vector>
#include <string>

using namespace std;


class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int count=0;
        for(auto n:nums){
            if(to_string(n).size()%2==0){
                count++;
            }
        }
        return count;
    }
};
