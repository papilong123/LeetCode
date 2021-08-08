package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

public class $449_SerializeandDeserializeBST {

    // Encodes a cn.example.tree to a single cn.example.string.
    public String serialize(TreeNode root) {
        if(root==null) return "";

        StringBuilder sb=new StringBuilder();
        helper(root,sb);
        return sb.substring(0,sb.length()-1);
    }

    private void helper(TreeNode root,StringBuilder sb){
        if(root!=null){
            sb.append(root.val).append(",");
            helper(root.left,sb);
            helper(root.right,sb);
        }
    }

    // Decodes your encoded data to cn.example.tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0) return null;
        String[] arr=data.split(",");
        return build(arr,0,arr.length-1);
    }

    private TreeNode build(String[] arr,int s1,int s2){
        if(s1>s2) return null;
        TreeNode root =new TreeNode(Integer.valueOf(arr[s1]));

        //找到第一个比首元素大的元素下标
        int index=s2+1;
        for(int i=s1+1;i<=s2;i++){
            if(Integer.valueOf(arr[i])> root.val){
                index=i;
                break;
            }
        }
        root.left=build(arr,s1+1,index-1);
        root.right=build(arr,index,s2);
        return root;
    }
}
