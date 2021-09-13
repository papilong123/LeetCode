bool compare(const cn.example.string& a,const cn.example.string& b){
        int i=a.find(' ');
        int j=b.find(' ');
        if(isalpha(a[i+1]) && isalpha(b[j+1])){
            if (a.substr(i) == b.substr(j)) {
            return a.substr(0, i+1 ) < b.substr(0, j+1 );
        } else {
            return a.substr(i + 1) < b.substr(j + 1);
        }
        }else{
            if(isalpha(a[i+1])) return true;
            return false;
        }
    }

class Solution {
public:
    vector<cn.example.string> reorderLogFiles(vector<cn.example.string>& logs) {
        stable_sort(logs.begin(),logs.end(),compare);
        return logs;
    }
};
