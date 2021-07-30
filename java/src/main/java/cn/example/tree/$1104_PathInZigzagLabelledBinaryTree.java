package cn.example.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class $1104_PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int row = 1, count = 1;
        while(count*2 <= label){
            row++;
            count <<= 1;
        }

        if(row % 2 == 0){
            label = getReverse(label, row);
        }

        while(row > 0){
            if(row % 2 == 0){
                res.add(getReverse(label, row));
            }else{
                res.add(label);
            }
            row -= 1;
            label >>= 1;
        }
        Collections.reverse(res);
        return res;
    }

    public int getReverse(int label, int row){
        return (1 << row - 1) + ((1 << row)) - 1 - label;
    }
}
