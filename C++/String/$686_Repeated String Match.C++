class Solution {
public:
    int repeatedStringMatch(string A, string B) {
        string T(A);
        int k=1;
        while(T.size()<B.size()){
            T.append(A);
            k++;
        }
        if( T.find(B) != string::npos ){
            return k;
        }
        T.append(A);//使T被B充分遍历
        k+=1;
        if(T.find(B) != string::npos ){
            return k;
        }else{
            return -1;
        }
    }
};
