package io.github.qxqrose.leetcode.day4;

/**
 * @author: qiu
 * 2021/7/18
 */
public class Question876 {
    public static void main(String[] args) {


    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 1;

        while(temp.next != null) {
            temp = temp.next;
            count ++;
        }
        if(count % 2 == 0) {
            count = count / 2 + 1;
        } else {
            count = (count + 1) / 2;
        }

        int c = 1;
        while(head.next != null) {
            if(c == count) {
                break;
            }
            temp = temp.next;
            c ++;
        }

        return head;
    }


}
