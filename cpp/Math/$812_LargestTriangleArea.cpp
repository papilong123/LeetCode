class Solution {
public:
    double largestTriangleArea(vector<vector<int>>& points) {
        double res=0,n=points.size();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    res=max(res,area(points[i],points[j],points[k]));
                }
            }
        }
        return res;
    }
    double area(vector<int>& A, vector<int>& B, vector<int>& C){//鞋带公式
        return 0.5*abs(A[0]*B[1]+B[0]*C[1]+C[0]*A[1]-A[1]*B[0]-B[1]*C[0]-C[1]*A[0]);
    }
};
