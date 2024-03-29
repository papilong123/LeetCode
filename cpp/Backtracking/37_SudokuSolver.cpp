#include <vector>
using namespace std;


class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }

    bool solve(vector<vector<char>>& board){
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]=='.'){
                    for(int c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;

                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    bool isValid(vector<vector<char>>& b,int i,int j,char c){
        for(int k=0;k<9;k++){
            if(b[k][j]==c) return false;//check col
            if(b[i][k]==c) return false;//check row
            if(b[3*(i/3)+k/3][3*(j/3)+k%3]==c) return false;//check box
        }
        return true;
    }
};
