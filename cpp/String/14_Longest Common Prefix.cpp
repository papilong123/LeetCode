#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) return "";//strs无字符串，则为空
		string prefix = strs[0];//假设第一个字符串为公共前缀
		for (int i=1;i<strs.size();i++){
			while (strs[i].find(prefix)!=0){
				if (prefix == "") return "";//如果prefix为空串，则说明公共前缀为空
				prefix = prefix.substr(0, prefix.length() - 1);
			}
		}
		return prefix;
    }
};
