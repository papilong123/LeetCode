#include <vector>

using namespace std;

class Solution {
public:
    vector<int> distributeCandies(int candies, int num_people) {
        vector<int> res(num_people,0);
        int n=1,index=0;

        while(candies-n>0){
            res[index%num_people]+=n;
            candies-=n++;
            index++;
        }
        res[index%num_people]+=candies;
        return res;
    }
};
