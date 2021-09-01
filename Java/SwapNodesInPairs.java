/*

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time Complexity: O(n)

class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null) return null;
        
        if(head.next == null) return head;
        
        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;
        temp.next= swapPairs(temp.next);
        
        return head;
        
    }
}