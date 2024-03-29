package cn.leetcode.arraylist;

class $48_RotateImage {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        //transpose matrix;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        //reverse each row;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=tmp;
            }
        }
    }
}
