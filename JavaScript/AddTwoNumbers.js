/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    
    if(l1.val === 0 && !l1.next && l2.val === 0 && !l2.next) 
        return new ListNode(0, undefined);
    
    let carry = 0;
    let result = new ListNode(undefined, undefined);
    let resultHead = result;
    
    while(l1 || l2){
        let sum = 0;
        
        if(l1 && l2) sum = l1.val + l2.val;
        else if(l1) sum = l1.val;
        else sum = l2.val;
        sum += carry;
        carry = 0;
            
        if(sum >= 10){
            carry = 1;
            sum %= 10;
        }

        resultHead.val = sum;
        
        let l1andl1Next = l1 && l1.next;
        let l2andl2Next = l2 && l2.next;
        
        if( l1andl1Next || l2andl2Next) {
            resultHead.next = new ListNode(undefined, undefined);
            resultHead = resultHead.next;
        }
        
        if(l1andl1Next) l1 = l1.next;
        else l1 = null;
        if(l2andl2Next) l2 = l2.next;
        else l2 = null;        
    }
    
    if(carry === 1){
        resultHead.next = new ListNode(1, undefined);
    }
    
    return result;
    
};