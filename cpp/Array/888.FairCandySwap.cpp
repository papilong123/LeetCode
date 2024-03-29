#include <vector>
#include <unordered_set>
#include <numeric>

using namespace std;


class Solution {
public:
    vector<int> fairCandySwap(vector<int>& A, vector<int>& B) {
        int dif = (accumulate(A.begin(), A.end(), 0) - accumulate(B.begin(), B.end(), 0)) / 2;
        unordered_set<int> S;
        for(auto num : A){
            S.insert(num);
        }
        for (int b: B)
            if (S.count(b + dif))
                return {b + dif, b};
        return {-1,-1};
    }
};
