class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {

        unordered_set<int> vals;
        for(int i=0;i<20 && pow(x,i)<bound;i++){
            for(int j=0;j<20 && pow(y,j)<bound;j++){
                int tmp=pow(x,i)+pow(y,j);
                if(tmp<=bound){
                    vals.insert(tmp);
                }
            }
        }

        vector<int> res(vals.begin(),vals.end());
        return res;
    }
};
