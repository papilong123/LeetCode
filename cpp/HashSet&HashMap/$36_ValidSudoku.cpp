class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'&&!isValid(board,i,j))
                return false;
            }
        }
        return true;
    }

    bool isValid(vector<vector<char>>& b,int i,int j){
        for(int k=0;k<9;k++){
            if(k!=i && b[k][j]==b[i][j]) return false;//check col
            if(k!=j && b[i][k]==b[i][j]) return false;//check row
            bool flag1=3*(i/3)+k/3!=i,flag2=3*(j/3)+k%3!=j;
            if(flag1 && flag2 && b[3*(i/3)+k/3][3*(j/3)+k%3]==b[i][j]) return false;//check box
        }
        return true;
    }
};
