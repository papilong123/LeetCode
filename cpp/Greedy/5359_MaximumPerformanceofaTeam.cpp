#include <vector>
#include <functional>
#include <algorithm>
#include <queue>

using namespace std;

class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        //总的思路是每个节点的效率都试一边，找到比自己效率高的小于等于k-1个元素，在计算中保留出现的最大值
        priority_queue<int,vector<int>,greater<int>> pq;
        vector<pair<int,int>> arr;
        for(int i=0;i<n;i++){
            arr.push_back({efficiency[i],speed[i]});//将效率和速度成对的加入数组
        }
        sort(arr.rbegin(),arr.rend());//按照<效率,速度>按从大到小排序
        long sum=0,res=0;
        for(int i=0;i<n;i++){
            pq.push(arr[i].second);//出现新元素就入队
            sum+=arr[i].second;//加上新元素的speed
            if(pq.size()>k){//队列里若超过了所能选择的工程师数量k，减去speed最小的
                sum-=pq.top();
                pq.pop();
            }
            res=max(res,sum*arr[i].first);//每次探测可能出现的最大值
        }
        return res % (int)(1e9+7);
    }
};
