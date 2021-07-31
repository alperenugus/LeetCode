/*

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Complexity: O(n)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Set<ListNode> setA = new HashSet<>();
        
        while(headA != null){
            setA.add(headA);
            headA = headA.next;
            
        }
        
        while(headB != null){
            if(setA.contains(headB)) return headB;
            headB = headB.next;
        }
        
        return null;    
    }
}