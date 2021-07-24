/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
    (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R

    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows.
*/

/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    
    if(s.length < numRows || numRows === 1) return s;

    let rows = [];
    let index = 0;


    for(let i = 0; i < s.length; i += numRows + Math.floor(numRows / 2)){
        for(let j = 0; j < numRows; j++){
            if(i + j === s.length) return rows.toString().replace(new RegExp(',', 'g'), '');
            if(!rows[j]) rows[j] = []
            rows[j] = [...rows[j], s[index]];
            index++;
        }
        for(let j = 1; j <= Math.floor(numRows / 2); j++){
            rows[numRows - j - 1] = [...rows[numRows - j - 1], s[index]];
            index++;
        }
    }
        
    return rows.toString().replace(new RegExp(',', 'g'), '');
};