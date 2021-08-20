class Solution {
public:
// 如果当前所有灯都是蓝色，那么亮灯的编号和必定等于1+2+...+亮灯数目，维护亮灯数目和亮灯编号和即可。
    int numTimesAllBlue(vector<int>& light) {
        int res;
        double cnt=0,sum=0;
        res=0;
        for(auto n:light){
            cnt++;
            sum+=n;
            if(sum==(1+cnt)*cnt/2) res++;
        }
        return res;
    }
};
