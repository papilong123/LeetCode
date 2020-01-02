class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if(matrix.size()==0) return;
        
        bool firstRaw=false;
        bool firstColum=false;
        int m=matrix.size();
        int n=matrix[0].size();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0) firstRaw=true;
                    if(j==0) firstColum=true;
                    
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j]==0||matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }    
        }

        if(firstRaw){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }

        if(firstColum){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
};

