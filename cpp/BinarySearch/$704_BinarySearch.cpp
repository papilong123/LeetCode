#include <vector>
using namespace std;


class Solution {
public:
    int search(vector<int>& nums, int target) {
        int i=0,j=nums.size()-1;
        while (i+1<j){//i和j差值为1的时候，直接就中止了
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                i=mid;
            }else{
                j=mid;
            }
        }
        //因为差值为1的时候，直接就中止了，所以，需要判断i和j
        if(nums[i]==target) return i;
        if(nums[j]==target) return j;

        return -1;
        
    }
};
