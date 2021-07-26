/*

Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

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

 // A recursive algorithm that will return the head of the smaller linked list in each iteration
 // Key points: Base cases, a head node inorder not to lose track, passing the next node for the next iteration

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode head = new ListNode();
        
        if(l1.val <= l2.val) {
            head.val = l1.val;
            head.next = mergeTwoLists(l1.next, l2);
        }
        else{
            head.val = l2.val;
            head.next = mergeTwoLists(l1, l2.next);
        }
        
        return head;
    }
}