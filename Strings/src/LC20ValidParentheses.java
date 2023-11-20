import java.util.Stack;

public class LC20ValidParentheses {
    /*
    *  Link: https://leetcode.com/problems/valid-parentheses/description/
    * */
    public boolean isValid(String s) {

        // Stack to store the brackets as characters
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            //If the current character is an opening bracket ('(', '[', or '{'), it pushes the corresponding closing bracket
            //onto the stack.
            if(c=='(')
                st.push(')');
            else if (c=='[')
                st.push(']');
            else if(c == '{')
                st.push('}');

                //If the current character is any of the closing bracket, then we are checking if top element of the stack
                //is matched to correct opening bracket for current closing bracket.
            else if(st.isEmpty() || st.pop()!= c){
                return false;
            }

        }
        //After iterating through all characters, it checks if stack is empty. If it is then all opening brackets have been  /
        //matched with the correct closing brackets and the method returns true otherwise false.
        return st.isEmpty();
    }
}
