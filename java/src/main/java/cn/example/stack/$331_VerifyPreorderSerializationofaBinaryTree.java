package cn.example.stack;

import java.util.ArrayList;
import java.util.List;

public class $331_VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        List<String> stack = new ArrayList<>();
        String[] array = preorder.split(",");
        for (String s : array) {
            stack.add(s);
            int len = stack.size();
            while (len >= 3 && stack.get(len - 1).equals("#") && stack.get(len - 2).equals("#") && !stack.get(len - 3).equals("#")) {
                stack.remove(len - 1);
                stack.remove(len - 2);
                stack.remove(len - 3);
                stack.add("#");
                len = stack.size();
            }
        }

        return stack.size()  == 1 && stack.get(0).equals("#");
    }

    public static void main(String[] args) {
        $331_VerifyPreorderSerializationofaBinaryTree test = new $331_VerifyPreorderSerializationofaBinaryTree();
        System.out.println(test.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
