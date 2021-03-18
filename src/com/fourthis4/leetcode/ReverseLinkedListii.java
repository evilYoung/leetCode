package com.fourthis4.leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ReverseLinkedListii {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode cur = head;

        ListNode leftNode = null;
        int point = 1;
        while (point < left) {
            point++;
            leftNode = cur;
            cur = cur.next;
        }

        ListNode reverseTail = cur;

        ListNode tmp = cur;
        ListNode tmpNext = cur.next;
        point++;
        cur = cur.next;

        while (point <= right) {
            point++;
            cur = cur.next;

            tmpNext.next = tmp;
            tmp = tmpNext;
            tmpNext = cur;
        }

        if (leftNode != null) {
            leftNode.next = tmp;
        } else {
            head = tmp;
        }
        reverseTail.next = tmpNext;

        return head;
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
}

