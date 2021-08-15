/*

Given the head of a linked list, remove the nth node from the end of the list and return its head.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null || n < 0){
            return null;
        }
        
        ListNode traverse = head;
        
        int length = 0;
        
        while(traverse != null){
            
            length++;
            traverse = traverse.next;
            
        }
        
        int toBeRemovedIndex = length - n;
        
        traverse = head;
        
        int counter = 0;
        
        if(toBeRemovedIndex == 0){
            head = head.next;
        }
        
        else{            
            while(traverse != null){

                counter++;

                if(counter == toBeRemovedIndex){

                    traverse.next = traverse.next.next;                

                }

                traverse = traverse.next;

            }
        }
        return head;
    }
}