#include <vector>
using namespace std;

class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int anchor=-1,res=0;
        int i=0;
        for(;i<seats.size();i++){
            if(seats[i]==1){
                res= anchor<0 ? i : max(res,(i-anchor)/2);
                anchor=i;
            }
        }
        res=max(res,i-anchor-1);
        return res;
    }
};
