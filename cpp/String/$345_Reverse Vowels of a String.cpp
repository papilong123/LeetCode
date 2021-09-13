class Solution {
public:
    bool helper(char c){
        if(c=='a'||c=='e'||c=='o'||c=='i'||c=='u'||
        c=='A'||c=='E'||c=='O'||c=='I'||c=='U')
        return true;
        else return false;
    }
    cn.example.string reverseVowels(cn.example.string s) {
        int i=0,j=s.size()-1;
        while(i<j){
            if(!helper(s[i])){
                i++;
                continue;
            }
            if(!helper(s[j])){
                j--;
                continue;
            }
            swap(s[i++],s[j--]);
        }
        return s;
    }
};
