import java.util.Stack;

public class LC394DecodeString {
    /*
    Link : https://leetcode.com/problems/decode-string/description/
   In tis problem, we have to decode the string which is inside the brackets, 'n' no of times.

   Approach:
   1)  We have to solve inside brackets first in order to solve.
   2)  We will be using 2 stacks, one for curr string and one for curr number.
   3)  We will be maintaining 2 variables, one for current string and another for current number.
       Initially current string would be blank " " and number 0.
   4)
       i)  Whenever any char is a number, we will update the curr string curr * 10 + c
       ii)  If its alphabet then simply append it into curr string.
       iii) If it is opening bracket [ then put both curr variables into stack, and reset current variables.
       iv) If it is closing bracket ]
           a)  pop from curr number stack, repeat the curr string that many times.
           b)  Once repetition done, then pop from string stack and append the string before the repeated result.
           c)  Once result string is done, assign it to curr string and curr int remain same, which is mostly 0
       v)  Repeat all steps till length becomes 0.

   Time Complexity : Length of the max(output of the String)
   Space Complexity :  Length of the max(output of the String)


    */
    public String decodeString(String s) {
        Stack<StringBuilder> strSt = new Stack<>();
        Stack<Integer> intSt = new Stack<>();
        int currInt = 0 ;
        StringBuilder currStr = new StringBuilder();
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currInt = currInt *10 + c - '0' ;
            }

            else if(c == '['){
                strSt.push(currStr);
                intSt.push(currInt);
                currStr = new StringBuilder();
                currInt = 0 ;

            }
            else if(c == ']'){
                int numPopped = intSt.pop();
                StringBuilder newStr =  new StringBuilder();
                for(int j=0;j<numPopped ;j++){
                    newStr.append(currStr);
                }

                StringBuilder parent = strSt.pop();
                parent.append(newStr);
                currStr = parent ;
            }
            else {
                currStr = currStr.append(c) ;
            }

        }

        return currStr.toString();
    }
}
