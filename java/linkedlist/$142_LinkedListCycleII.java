Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
