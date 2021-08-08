package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

/**
 * Definition for a binary cn.example.tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
