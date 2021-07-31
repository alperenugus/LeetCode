/*

Given the head of a singly linked list, reverse the list, and return the reversed list.

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

 // Solution 1 using stack
 // Time complexity: O(n)
 // Space complexity: O(n)

class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null) return null;
        
        Stack<ListNode> stack = new Stack<>();
        
        while(head != null){
                        
            stack.add(head);
            head = head.next;
            
        }
        
        head = stack.pop();
        ListNode newHead = head;
        
        while(!stack.isEmpty()){
            head.next = stack.pop();
            head = head.next;
        }
        
        // Last element should point null
        head.next =null;
      
        return newHead;
        
    }
}

// Solution 2 iteration
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head == null) return null;
        
        ListNode ptr = head;
        
        ListNode prev = null;
        
        while(head.next != null){
            
            ptr = head.next;
            
            head.next = prev;
            
            prev = head;
            
            head = ptr;
                        
        }
        
        ptr.next = prev;
        
        return ptr;
    }
}