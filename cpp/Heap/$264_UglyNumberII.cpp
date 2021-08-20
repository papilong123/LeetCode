// 利用优先队列有自动排序的功能
// 每次取出队头元素，存入队头元素*2、队头元素*3、队头元素*5
// 但注意，像12这个元素，可由4乘3得到，也可由6乘2得到，所以要注意去重

class Solution {
public:
    int nthUglyNumber(int n) {
        double res=1;
        priority_queue<double,vector<double>,greater<double> > q;
        while(n-- >1){//执行n-1次
            q.push(res*2);
            q.push(res*3);
            q.push(res*5);
            res=q.top();
            q.pop();
            while(!q.empty() && res==q.top()){
                q.pop();
            }
        }
        return res;
    }
};
