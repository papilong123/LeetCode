class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int r=matrix.size(),c=matrix[0].size();

        //预标记状态,第一行和第一列是否有零,零所在的第一行和第一列都标为零
        bool heng=false,shu=false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    if(i==0) heng=true;
                    if(j==0) shu=true;

                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }


        for(int i=1;i<r;i++){
            if(matrix[i][0]==0)
            for(int j=1;j<c;j++){
                matrix[i][j]=0;
            }
        }

        for(int j=1;j<c;j++){//中间元素归零
            if(matrix[0][j]==0)
            for(int i=1;i<r;i++){
                matrix[i][j]=0;
            }
        }

        if(heng){//行归零
            for(int j=0;j<c;j++){
                matrix[0][j]=0;
            }
        }

        if(shu){//列归零
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }
    }
};
