class Solution {
public:
    int compareVersion(cn.example.string version1, cn.example.string version2) {
        char c;
        istringstream str1(version1);
        istringstream str2(version2);
        int v1,v2;

        while(bool(str1>>v1)+bool(str2>>v2)){
            if(v1>v2) return 1;
            if(v1<v2) return -1;

            v1=0;
            v2=0;
            str1>>c;
            str2>>c;
        }
        return 0;
    }
};
