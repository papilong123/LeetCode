#include <vector>
using namespace std;


class Solution {
public:
    int distanceBetweenBusStops(vector<int>& distance, int start, int destination) {
        int res=0,sum=0;

        if(start>=destination) swap(start,destination);
        for(int i=0; i < distance.size() ;i++){
            sum+=distance[i];
            if(start <= i && i < destination) res+=distance[i];
        }

        return min(res,sum-res);
    }
};
