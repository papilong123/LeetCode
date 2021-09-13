#include <vector>

using namespace std;

class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> res;
        for(int i=left;i<=right;i++){
            if(isSDN(i)) res.push_back(i);
        }
        return res;
    }

    bool isSDN(int num){
        int k=num;
        while(k!=0){
            int tmp=k%10;
            k/=10;
            if(tmp==0 || num%tmp!=0)
            return false; 
        }
        return true;
    }
};
