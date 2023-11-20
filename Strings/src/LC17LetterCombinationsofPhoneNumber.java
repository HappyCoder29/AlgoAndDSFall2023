import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC17LetterCombinationsofPhoneNumber {
    // Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    //In this program we have to find all possible letter combinations that can be formed using a given string of digits, where each digit represents a group of //
    //letters on a phone keypad.
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> result =new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return result;
        //Map for mapping number with set of characters
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(digits, 0, map, new StringBuilder(), result );

        return result;
    }
    //We will be using recursive approach
    public void helper(String digits, int index, HashMap<Character, String> map,
                       StringBuilder combo, List<String> result){

        //Base
        if(index >= digits.length()){   //If the current index exceeds or equals the length of the input , it means a valid combination is formed, and it adds
            //the combination to the result list
            result.add(combo.toString());
            return;
        }

        //Logic
        Character c = digits.charAt(index);
        System.out.println(c);
        String stringAtIndex = map.get(c);
        for(int i=0; i<=stringAtIndex.length()-1;i++){
            //Action
            combo.append(stringAtIndex.charAt(i)); // appends the current letter to the combo StringBuilder
            //recursion
            helper(digits, index+1, map, combo, result); // and makes a recursive call to the helper method with the updated index.


            //Backtracking
            combo.deleteCharAt(combo.length() - 1); // After the recursion it delete the last character from the combo StringBuilder to backtrack and explore other
            //possibilities.


        }

    }
}
