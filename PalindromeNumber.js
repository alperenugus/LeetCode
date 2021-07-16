/*

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

*/

/**
 * @param {number} x
 * @return {boolean}
 */

 var isPalindrome = function(x) {
    
    if(x < 0) return false;
    
    let unchanged = x;
    
    var arr = [];
    
    while(x >= 10){
        var lastDigit = x % 10;
        arr.push(lastDigit);
        x = Math.floor(x / 10);
    }
    
    arr.push(x);
    
    let result = 0;
    let digit = 0;
    
    for(let i = arr.length - 1; i >= 0; i--){
        result += arr[digit] * 10**i;
        digit++;
    }
    
    return unchanged === result;
    
};