#include <vector>
#include <functional>
#include <algorithm>
#include <queue>

using namespace std;

class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        sort(events.begin(),events.end());
        priority_queue<int,vector<int>,greater<int>> pq;
        int res=0;

        for(int day=1,i=0;day<=100000;day++){
            while(!pq.empty() && pq.top()<day){
                pq.pop();
            }
            while(i<events.size() && day==events[i][0]){
                pq.push(events[i++][1]);
            }
            if(!pq.empty()){
                res++;
                pq.pop();
            }
        }
        return res;
    }
};
