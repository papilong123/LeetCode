#include <vector>
#include <algorithm>

using namespace std;


class Solution {
    int bit[10010]={0};
public:
    vector<int> sortByBits(vector<int>& arr) {
        for (int i=1;i<=10000;++i) bit[i]=bit[i>>1]+(i&1);
        sort(arr.begin(),arr.end(),[&](int x, int y){
            return bit[x]==bit[y]? x<y: bit[x]<bit[y];
        });
        return arr;
    }
};
