package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

class $108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
         return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums,int a,int b){
        if(a>b) return null;
        int mid=(a+b) >>>1;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=helper(nums,a,mid-1);
        node.right=helper(nums,mid+1,b);
        return node;
    }
}
