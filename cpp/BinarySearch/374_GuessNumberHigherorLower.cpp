#include <vector>
#include <string>

using namespace std;

// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution {
public:
    //函数接口提供反了
    int guessNumber(int n) {
        int i=1,j=n;
        while (i+1<j){//i和j差值为1的时候，直接就中止了
            int mid=i+(j-i)/2;
            if(guess(mid)==0){
                return mid;
            }else if(guess(mid)==1){
                i=mid;
            }else{
                j=mid;
            }
        }
        //因为差值为1的时候，直接就中止了，所以，需要判断i和j
        if(guess(i)==0) return i;
        if(guess(j)==0) return j;

        return -1;
    }
};
