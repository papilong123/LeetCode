class Solution {
public:
    bool isPalindrome(cn.example.string s) {
        cn.example.string str="";
        for(char c : s){
            if(isalnum(c)){
                str+=c;
            }
        }
        int i=0,j=str.size()-1;
        while( i<=j || i+1<=j ){
            if(tolower(str[i])!=tolower(str[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};
