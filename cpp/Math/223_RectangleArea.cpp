#include <vector>

using namespace std;

class Solution {
public:
    long area(int x1, int y1, int x2, int y2){
        return (y2-y1)*(x2-x1);
    }

    long overlap(int A, int B, int C, int D, int E, int F, int G, int H){
        if(min(C,G)>max(A,E) && min(D,H)>max(B,F))
            return (min(C,G)-max(A,E))*(min(D,H)-max(B,F));
        return 0;
    }

    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return area(A,B,C,D)+area(E,F,G,H)-overlap(A,B,C,D,E,F,G,H);
    }
};
