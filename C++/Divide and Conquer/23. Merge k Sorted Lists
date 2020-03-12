/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int n=lists.size();
        if(n==0) return NULL;

        //分治循环模板
        for(int interval=1;interval<n;interval*=2){//interval是每次的间隔，每走一遍，间隔乘二，最终小于总长度
            for(int i=0;i<n-interval;i+=2*interval){
                lists[i]=mergeTwo(lists[i],lists[i+interval]);
            }
        }
        return lists[0];
    }

    ListNode* mergeTwo(ListNode* l1,ListNode* l2){
        if(l1==NULL) return l2;
        if(l2==NULL) return l1;

        ListNode* pre=new ListNode(0);
        ListNode* p=pre;
        while(l1!=NULL && l2!=NULL){
            if(l1->val <= l2->val){
                p->next=l1;
                l1=l1->next;
            }else{
                p->next=l2;
                l2=l2->next;
            }
            p=p->next;
        }
        p->next= l1==NULL?l2:l1;
        return pre->next;
    }
};
