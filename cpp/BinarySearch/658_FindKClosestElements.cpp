#include <vector>
#include <queue>
using namespace std;

// 二分搜索，先找到和 x 最接近的两个数，再向两边扩展。不过这个方法在 k 值较大的时候会退化，因此比较傻。
vector<int> findClosestElements(vector<int>& arr, int k, int x) {
    if (arr.size() == 1) return arr; 
    // 双候选
    int lo = 0, hi = arr.size() - 1;
    while (lo + 1 < hi) {
        int mid = lo + (hi - lo >> 1);
        if (x <= arr[mid]) {
            hi = mid;
        } else {
            lo = mid;
        }
    }
    deque<int> res;
    int i = lo, j = hi;
    while (res.size() < k) {
        if (j == arr.size() || (i >= 0 && x - arr[i] <= arr[j] - x)) {
            res.push_front(arr[i--]);
        } else {
            res.push_back(arr[j++]);
        }
    }
    return vector<int>(res.begin(), res.end());
}

//方法二，双指针
class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> res;
        int i=0,j=arr.size()-1,cnt=arr.size()-k;
        while(cnt>0){
            if(x-arr[i]<=arr[j]-x){
                j--;
            }else{
                i++;
            }
            cnt--;
        }
        for(int s=i;s<=j;s++){
            res.push_back(arr[s]);
        }
        return res;
    }
};
