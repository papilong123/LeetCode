#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        int a[26]={0};
        for(int i=0;i<magazine.size();i++){//统计元素数量
            a[magazine[i]-'a']++;
        }
        for(int i=0;i<ransomNote.size();i++){//减去有的数量
            a[ransomNote[i]-'a']--;
        }
        for(int i=0;i<26;i++){//若发现有小于0的元素，直接返回false
            if(a[i]<0) return false;
        }
        return true;//所有的都匹配，正确
    }
};
