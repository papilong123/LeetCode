#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    bool valid(const string& s, const string& q) {
        int i = 0;
        int j = 0;
        int l1 = 0;
        int l2 = 0;
        int d1 = 0;
        int d2 = 0;
        while (i < s.size() && j < q.size()) {
            if (s[i] != q[j]) return false;
            while (i < s.size() && s[i] == s[l1]) ++i;
            while (j < q.size() && q[j] == q[l2]) ++j;
            d1 = i - l1;
            d2 = j - l2;
            if (d1 < d2 || (d1 < 3 && d1 > d2)) return false;
            l1 = i;
            l2 = j;
        }
        d1 = s.size() - i;
        d2 = q.size() - j;
        if (d1 < d2 || (d1 < 3 && d1 > d2)) return false;
        return true;
    }
    int expressiveWords(string S, vector<string>& words) {
        int res = 0;
        for (auto& w : words) {
            res += valid(S, w);
        }
        return res;
    }
};
