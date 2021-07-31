/*

Given the head of a singly linked list, return true if it is a palindrome.

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

// Time complexity: O(n)
// Key point: If String class is used instead of StringBuilder, the complexity becomes O(n^2) since Strings are immutable, and
// in every concat operation, a new String object is created.

// Could be solved using:
// - Stack
// - Finding the medium Node and reversing the half list by using a fast and a slow pointer

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null) return false;
        
        if(head.next == null) return true;
        
        StringBuilder str = new StringBuilder();
        
        while(head != null){
            str = str.append(String.valueOf(head.val));
            head = head.next;
        }
        
        
        int i = 0;
        int j = str.length() - 1;
        
        int middle = str.length() / 2;
        
        boolean even = str.length() % 2 == 0;
        
        while(i <= middle && j >= middle){
            
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}