package cn.example.array;

class $169_MajorityElement {
    public int majorityElement(int[] nums) {
        int count=1;
        int tmp=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]==tmp){
                count++;
            }else{
                if(count>0){
                    count--;
                }else{
                    count=1;
                    tmp=nums[i];
                }
            }
        }
        return tmp;
    }
}
