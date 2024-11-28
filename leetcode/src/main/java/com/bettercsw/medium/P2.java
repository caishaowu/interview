package com.bettercsw.medium;

/**
 * @author csw
 * @date 2020/7/29 16:19
 */
public class P2 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;   //进位标识
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
        }
        //最后的节点是否需要进位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }

}
