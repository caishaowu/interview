package com.bettercsw.easy;

import java.util.concurrent.Semaphore;

/**
 * 链表
 *
 * @author csw
 * @date 2020/8/11 14:35
 */
public class P141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }
}
