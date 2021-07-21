class Solution {
public:
    int month[13]={-1,31,28,31,30,31,30,31,31,30,31,30,31};

    int daysBetweenDates(cn.example.string date1, cn.example.string date2) {
        return abs(count(date1)-count(date2));
    }

    int count(cn.example.string str){
        int y=0,m=0,d=0,time=0;
        y=stoi(str.substr(0,4));
        m=stoi(str.substr(5,2));
        d=stoi(str.substr(8,2));
        for(int i=1970;i<y;i++){
            if(isleap(i)) time+=366;
            else time+=365;
        }
        for(int i=1;i<m;i++){
            time+=month[i];
            if(i==2 && isleap(y))
            time+=1;
        }
        time+=d;
        return time;
    }

    int isleap(int y){
        return y%4==0 && y%100!=0 || y%400==0;
    }
};
