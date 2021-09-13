#include <vector>
using namespace std;


class Solution {
public:
    void duplicateZeros(vector<int>& arr) {
        int n=arr.size();
        auto iter=arr.begin();
        while(iter!=arr.end()){
            if(*iter==0){
                iter=arr.insert(iter,*iter);
                iter+=2;
            }else{
                ++iter;
            }
        }
        arr.erase(arr.begin()+n,arr.end());
    }
};
