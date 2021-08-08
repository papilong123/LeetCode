package cn.leetcode.tree;

import cn.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//打败的人太少了，效率较低
public class $297_SerializeandDeserializeBinaryTree {

    // Encodes a cn.example.tree to a single cn.example.string.
    public String serialize(TreeNode root) {
        return helper(root,"");
    }
    public String helper(TreeNode root,String str){
        if(root==null){
        str+="null,";
        }else{
            str+=str.valueOf(root.val)+",";
            str=helper(root.left,str);
            str=helper(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to cn.example.tree.
    public TreeNode deserialize(String data) {
        String[] data_array=data.split(",");
        List<String> data_list= new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
    public TreeNode rdeserialize(List<String> l){
        //recursive desrialization.
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }

        TreeNode root=new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left=rdeserialize(l);
        root.right=rdeserialize(l);

        return root;
    }
}
