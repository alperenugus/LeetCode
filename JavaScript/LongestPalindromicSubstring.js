/*
    Given a string s, return the longest palindromic substring in s.
*/

/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {

    if (s.length === 1) return s;

    let result = "";

    for (let i = 0; i < s.length; i++) {

        for (let j = i + 1; j <= s.length; j++) {

            let substring = s.substring(i, j);
            if (isPalindrome(substring) && substring.length > result.length) {
                result = substring;
            }

        }

    }

    return result;
};

var isPalindrome = function (s) {
    n = s.length;
    if (n < 2) return true;
    for (let i = 0; i < (n / 2); ++i) {
        if (s[i] != s[n - i - 1]) {
            return false;
        }
    }

    return true;
}