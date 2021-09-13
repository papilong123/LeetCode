#include <vector>
#include <map>
using namespace std;


class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        vector<int> res;
        map<int, int> m;
        int pos=0;

        for(int i=0;i<arr1.size();i++){
            m[arr1[i]]++;
        }

        for(auto val: arr2){
            while(m[val]-- >0) arr1[pos++]=val;
        }

        for(auto val: m){
            while(val.second-- >0) arr1[pos++]=val.first;
        }

        return arr1;
    }
};
