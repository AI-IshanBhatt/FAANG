package leetcode.MonthlyChallange.Nov;

import java.util.Stack;
// This ListNode implementation is useful for creating linkedlist
// https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3516/
public class DayOne {


     static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        getDecimalValue(head);
    }

    public static int getDecimalValue(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head != null) {
            s.push(head.val);
            head = head.next;
        }

        int sum=0, power=0;
        while (!s.isEmpty()) {
            sum += Math.pow(2, power++) * s.pop();
        }

        return sum;
    }
}
