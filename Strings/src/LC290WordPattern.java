import java.util.HashMap;

public class LC290WordPattern {
    /*
    Link: https://leetcode.com/problems/word-pattern/
    In this problem we need to map the pattern in isomorphic way.
    For eg
    "abba" "dog cat cat dog"
    char a - > dog. && dog -> char a.
    char b -> cat  && cat -> char b

    Approach:
    Here we will be maintaining 2 maps one for char to string and another for string to char
    Before that we will be splitting string by space.
    Then we will iterate through every character if my char c is equal to split[i] and split[i] is equal to char c
    in that case we will be reaturning true else we will be returning false

    Complexity:
    Time complexity : O(N)
    Space will be: O(1)
    */

    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> sourceMap = new HashMap<>();
        HashMap<String, Character> targetMap = new HashMap<>();

        String[] splited = s.split(" ");
        if(pattern.length() != splited.length){
            return false ;
        }
        for(int i=0; i<=pattern.length() - 1 ; i++){
            char c = pattern.charAt(i) ;
            if(!(sourceMap.containsKey(c)) && !(targetMap.containsKey(splited[i]))){
                sourceMap.put(c,splited[i]);
                targetMap.put(splited[i], c);
            }
            String check = sourceMap.get(c) ;
            if(check!=null && !check.equalsIgnoreCase(splited[i])){ // Since we are checking with string, we will be
                return false ; // using equalsIgnoreCase and not != or ==
            }
            char checkChar = targetMap.get(splited[i]) ;
            if(checkChar!=c){
                return false ;
            }
        }
        return true ;
    }
}
