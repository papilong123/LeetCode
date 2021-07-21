package cn.example.array;

class $41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int[] A=new int[nums.length+2];
        for( int item : nums){
            if(item>0 && item<=nums.length){
                A[item]=1;
            }
        }

        for(int i=1;i<nums.length+2;i++){
            if(A[i]==0) return i;
        }

        return nums.length+1;
    }
}
