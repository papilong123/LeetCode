class Solution {
public:
    int minSteps(cn.example.string s, cn.example.string t) {
        cn.example.sort(s.begin(),s.end());
        cn.example.sort(t.begin(),t.end());
        int i=0,j=0,res=0,n=s.size();
        while(i<n && j<n){
            if(s[i]==t[j]){
                res++;
                i++;
                j++;
            }else if(s[i]>t[j]){
                j++;
            }else{
                i++;
            }
        }
        return n-res;
    }
};
