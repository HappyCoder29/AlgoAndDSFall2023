import java.util.HashMap;

public class LC205IsomorphicStrings {

    /*
    Link : https://leetcode.com/problems/isomorphic-strings/
   The Isomorphic strings are the two strings where every character from one string is mapped to another & vice
   versa.
   For eg. "egg" and "add" e ->a a -> e  && g -> d d -> g and g -> d d -> g, so two strings are isomorphic
   Approach:
   We will be maintaining 2 maps one for source to target and another for target to source
   Map    Key. Value
   sMap = e.   a
   sMap = g.   d

   Complexity:
   Time Complexity : O(N)
   Space Complexity : O(1)  suppose we have a string with 1000 character but we will be storing only 26 chars which is constant
   In that case space will be O(1)
   */
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){ // Here if length of 2 strings are not matching that means its not isomorphic
            return false ;
        }
        HashMap<Character, Character> sourceMap = new HashMap<>(); // This map for source
        HashMap<Character, Character> targetMap = new HashMap<>(); // This map for target

        for(int i=0 ; i<=s.length()-1; i++){ // we will iterate through every character of any string s or t
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(!(sourceMap.containsKey(sChar)) && !(targetMap.containsKey(tChar))){ // If sourceChar and targetChar
                //doesn't exist, then we will add those as key value pair in both the maps
                sourceMap.put(sChar, tChar);
                targetMap.put(tChar, sChar);
            }
            //if key of sChar exist in source and its not equal to tchar then its not isomorphic
            if(sourceMap.get(sChar)!=null && sourceMap.get(sChar)!=tChar){
                return false ;
            }
            //if key of tChar exist in target and its not equal to sChar then its not isomorphic
            if(targetMap.get(tChar)!=null && targetMap.get(tChar)!=sChar){
                return false ;
            }
        }
        return true;
    }
}
