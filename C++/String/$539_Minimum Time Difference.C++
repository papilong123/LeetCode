class Solution {
private:
    int help(string s){
        int hour=stoi(s.substr(0,2));
        int minute=stoi(s.substr(3,2));
        return 60*hour+minute;
    }

public:
    int findMinDifference(vector<string>& timePoints) {
        int n=timePoints.size();
        vector<int> time(n,0);
        const int DAY_MINUTE=24*60;
        for(int i=0;i<n;i++){
            time[i]=help(timePoints[i]);
        }
        sort(time.begin(),time.end());
        int res=min(time[n-1]-time[0],DAY_MINUTE-time[n-1]+time[0]);
        for(int i=1;i<n;i++){
            res=min(res,time[i]-time[i-1]);
        }
        return res;
    }
};
