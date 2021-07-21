package cn.example.dp;

class $198_HouseRobber {
    public int rob(int[] nums) {
        int pre=0,p=0;
        for(int v: nums ){
            int tmp=p;
            p=Math.max(pre+v,p);
            pre=tmp;
        }
        return p;
    }
}
