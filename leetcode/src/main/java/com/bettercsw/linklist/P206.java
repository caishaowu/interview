package com.bettercsw.linklist;


/**
 * 链表反转
 *
 * @author csw
 * @date 2020/8/31 16:12
 */
public class P206 {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
