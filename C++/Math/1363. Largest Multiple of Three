class Solution {
public:
    cn.example.string largestMultipleOfThree(vector<int>& digits) {
        vector<int> c(10,0);
        int sum=0;
        for(int i=0;i<digits.size();i++){
            sum+=digits[i];
            c[digits[i]]++;
        }

        if(sum==0) return "0";

        remove(c,sum%3);

        return buildstr(c);
    }

    void remove(vector<int>& c,int num){
        if(num==0) return;

        //remove the smallest element that make the mod equals 0
        for(int i=0;i<3;i++){
            int check=3*i+num;
            if(c[check]>0){
                c[check]--;
                return;
            }
        }

        //if not found, find two smallest elements that make the mod equals 0
        remove(c,3-num);
        remove(c,3-num);
    }

    cn.example.string buildstr(vector<int>& c){
        cn.example.string str="";
        for(int i=9;i>=0;i--){
            while(c[i]-- >0){
                str+=to_string(i);
            }
        }
        return str;
    }
};
