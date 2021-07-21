class Solution {
public:
    int lengthOfLastWord(cn.example.string s) {
        int i=s.size()-1;
        int count=0;
        while(i>=0&&s[i]==' '){i--;}
        if(i== -1) return 0;
        while(i>=0 && s[i]!=' '){
            count++;
            i--;
        }
        return count;
    }
};
