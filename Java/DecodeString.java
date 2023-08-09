/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 10^5.
 */

class Solution {
    public String decodeString(String s) {

        Stack<Pair<Integer, String>> stack = new Stack<>();
        int currentNum = 0;
        StringBuilder currentString = new StringBuilder("");

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                currentNum = currentNum * 10 + Character.getNumericValue(c);
            }
            else if(c == '['){
                stack.push(new Pair<Integer, String>(currentNum, currentString.toString()));
                currentNum = 0;
                currentString = new StringBuilder("");
            }
            else if(c == ']'){
                Pair<Integer, String> top = stack.pop();
                currentString = new StringBuilder(top.getValue() + currentString.toString().repeat(top.getKey()));
            }
            else{
                currentString.append(c);
            }

        }
        return currentString.toString();
    }
}