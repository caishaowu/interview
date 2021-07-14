package com.bettercsw.linklist;

/**
 * @author csw
 * @date 2020/8/4 17:34
 */
public class P21 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode curr = new ListNode();
        ListNode dummy = curr;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;

            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;

    }
}
