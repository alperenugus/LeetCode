/*

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

*/

/**
 * @param {number} x
 * @return {number}
 */
 var reverse = function(x) {

    const MAX_INT = Math.pow(2, 31) - 1;

    var reversed = 0
    var isNegative = x < 0;

    if(isNegative) x = x * -1;

    const length = Math.ceil(Math.log10(x + 1));
    for(let i = length - 1; i >= 0; i--){

        var step = Math.pow(10, i);
        var mod = x % 10;

        if(reversed > MAX_INT - (mod * step)) return 0;

        reversed += mod * step;
        x = Math.floor(x / 10);
    }

    return isNegative ? -reversed : reversed
};