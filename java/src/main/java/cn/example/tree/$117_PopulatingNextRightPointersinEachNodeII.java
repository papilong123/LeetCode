package cn.example.tree;

import cn.example.common.Node;

class $117_PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        Node p=root;
        Node head=null;
        Node rear=null;
        while(p!=null){
            while(p!=null){
                if(p.left!=null){
                    if(head==null){
                        head=p.left;
                        rear=head;
                    }else{
                        rear.next=p.left;
                        rear=rear.next;
                    }
                }
                if(p.right!=null){
                    if(head==null){
                        head=p.right;
                        rear=head;
                    }else{
                        rear.next=p.right;
                        rear=rear.next;
                    }
                }
                p=p.next;
            }
            p=head;
            head=null;
            rear=null;
        }
        return root;
    }
}
