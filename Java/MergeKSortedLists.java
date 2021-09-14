/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

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
class Solution {
    
    public static int customCompare(ListNode head1, ListNode head2){
        return Integer.compare(head1.val, head2.val);
    }
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        
        PriorityQueue<ListNode> q = new PriorityQueue<>(Solution::customCompare);
        
        for(ListNode head : lists){
            if(head != null) q.add(head);
        }
        
        ListNode newList = q.poll();
        if(newList != null){
            if(newList.next != null) q.add(newList.next);
            ListNode traverse = newList;
        
            while(!q.isEmpty()){
                traverse.next = q.poll();
                traverse = traverse.next;
                if(traverse.next != null) q.add(traverse.next);
            }
        }
        
        return newList;
        
    }
}