/*

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Solution 1
// HashMap: Time: O(n), Space: O(n)

public class Solution {

    public boolean hasCycle(ListNode head) {
        
        Set<ListNode> set = new HashSet<>();
        
        int index = 0;
        
        while(head != null){
            index++;
            if(set.contains(head)) return true;
            else set.add(head);
            head = head.next;
        }
        
        return false;
    }
}

// Solution 2
// Floyd’s slow and fast pointers approach: Time: O(n), Space: O(1)

public class Solution {
    
    public boolean hasCycle(ListNode head) {
        
        if(head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
                        
        while(fast != null && fast.next != null && slow != null){
            
            if(fast == slow) return true;
            else fast = fast.next.next;
            slow = slow.next;
            
        } 
        
        return false;
    }
}
