package cn.example.binarysearch;

public class $33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target){
        int n = nums.length, i = 0, j = n - 1;
        while(i <= j){
            int mid = (i+j) / 2;
            if(nums[mid] == target){
                return mid;
//            先判断在那个区内，mid将整个区域分为两块，[0, mid - 1]和[mid + 1, n-1]
//            比较中值和左端点，如果中值大于等于左端点nums[0]，则mid左边完全排序
            }else if(nums[mid] >= nums[i]){
//                mid左边全部有序，若target在有序的一块，则舍弃右边部分有序的一块
                if(target >= nums[i] && target < nums[mid]){
                    j = mid - 1;
                }else{
                    i = mid + 1;
                }
//            mid右边完全有序
            }else {
//                若target在全部有序的一块
                if(target > nums[mid] && target <= nums[j]){
                    i = mid + 1;
                }else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        $33_SearchInRotatedSortedArray solution = new $33_SearchInRotatedSortedArray();
        int ans = solution.search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(ans);
    }
}
