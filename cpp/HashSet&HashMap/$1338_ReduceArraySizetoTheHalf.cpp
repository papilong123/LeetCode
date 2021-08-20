class Solution {
public:
    int minSetSize(vector<int>& arr) {
        int res=0,n=arr.size();
        unordered_map<int,int> m;
        priority_queue<int,vector<int>,less<int>> pq;

        for(auto num:arr){
            m[num]++;
        }

        for(unordered_map<int,int>::iterator it=m.begin();it!=m.end();it++){//哈希表转到优先队列
            pq.push(it->second);
        }

        int tmp=n;
        while(!pq.empty() && tmp>n/2){//pq不空的前提下tmp减pq里的最大元素
            tmp-=pq.top();
            pq.pop();
            res++;
        }
        return res;
    }
};
