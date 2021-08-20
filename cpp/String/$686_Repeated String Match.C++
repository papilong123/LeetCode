class Solution {
public:
    int repeatedStringMatch(cn.example.string A, cn.example.string B) {
        cn.example.string T(A);
        int k=1;
        while(T.size()<B.size()){
            T.append(A);
            k++;
        }
        if( T.find(B) != cn.example.string::npos ){
            return k;
        }
        T.append(A);//使T被B充分遍历
        k+=1;
        if(T.find(B) != cn.example.string::npos ){
            return k;
        }else{
            return -1;
        }
    }
};
