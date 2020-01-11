class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows==1) return s;
        vector<string> row(min(numRows,int(s.size())));

        bool flag=false;
        int i=0;
        for(char c : s){
            row[i]+=c;
            if(i==0||i==numRows-1) flag=!flag;
            i+=flag?1:-1;
        }
        string res;
        for(string c: row){
            res+=c;
        }
        return res;
    }
};
