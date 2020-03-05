class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        set<int> c;
        for(auto a: arr){
            if(c.find(2*a)!=c.end() || a%2==0&&c.find(a/2)!=c.end()) return true;
            c.insert(a);
        }
        return false;
    }
};
