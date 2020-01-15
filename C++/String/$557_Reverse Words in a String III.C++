class Solution {
public:
    string reverseWords(string s) {
        int anchor=0;
        int n=s.size();
        for(int i=0;i<n;i++){
            if(s[i]==' '){
                reverse(s.begin()+anchor,s.begin()+i);
                anchor=i+1;
            }
        }
        reverse(s.begin()+anchor,s.end());
        return s;
    }
};
