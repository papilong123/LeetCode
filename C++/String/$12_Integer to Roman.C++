class Solution {
public:
    string intToRoman(int num) {
        vector<string> store={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        vector<int> ivec={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        string res;
        //greedy
        for(int i=0;i<store.size();i++){
            while(num>=ivec[i]){
                res.append(store[i]);
                num-=ivec[i];
            }
        }
        return res;
    }
};
