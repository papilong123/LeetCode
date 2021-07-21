/*1.对于每个string，都对应建立两个字符串（odd用来记录奇数部分的字符，even记录偶数部分的字符）

2.odd和even排序后相加，如果string1和string2是特殊等价的那么相加后的字符串必定相同

3.建立set存储每个不同的结果，返回set的size
*/


class Solution {
public:
    int numSpecialEquivGroups(vector<cn.example.string>& A) {
        int n=A.size();
        set<cn.example.string> res;
        for(int i=0;i<n;i++){
            cn.example.string str;
            cn.example.string odd="";
            cn.example.string even="";
            for(int j=0;j<A[i].size();j++){
                if(j%2==1){
                    odd+=A[i][j];
                }else{
                    even+=A[i][j];
                }
            }
            cn.example.sort(odd.begin(),odd.end());
            cn.example.sort(even.begin(),even.end());
            str=(odd+even);
            res.insert(str);
        }
        return res.size();
    }
};


