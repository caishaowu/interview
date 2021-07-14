package com.bettercsw.medium;

/**
 * @author csw
 * @date 2020/8/11 17:56
 */
public class P24 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode p1 = curr.next;
            ListNode p2 = curr.next.next;
            curr.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            curr = p1;

        }
        return dummy.next;
    }
}
