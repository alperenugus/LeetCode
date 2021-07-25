/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

*/

class Solution {
    public boolean isValid(String s) {

        if (s.length() % 2 == 1)
            return false;

        Stack<Character> characterStack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                characterStack.push(c);
            else {

                if ((c == ')') && !characterStack.isEmpty() && characterStack.peek() == '(')
                    characterStack.pop();
                else if ((c == '}') && !characterStack.isEmpty() && characterStack.peek() == '{')
                    characterStack.pop();
                else if ((c == ']') && !characterStack.isEmpty() && characterStack.peek() == '[')
                    characterStack.pop();
                else
                    return false;
            }
        }

        return characterStack.isEmpty();
    }
}
