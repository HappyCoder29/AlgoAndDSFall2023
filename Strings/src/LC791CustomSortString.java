import java.util.HashMap;

public class LC791CustomSortString {
    // Link : https://leetcode.com/problems/custom-sort-string/description/
    //In this program we have to sort the characters in string s based on the order mentioned in string order

    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map = new HashMap<>(); // Map for keeping record of each character and its count
        char[] result = new char[s.length()];
        int n = 0 ;

        //Iterating through each character and store its count
        for(int i=0;i<=s.length() -1 ;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c , map.get(c) + 1);
            }
            else{
                map.put(c,1);
            }
        }

        //Now we are iterating through each charcter from order string which is in the order
        //For each charcter if it exist in the Map then
        //  1) it take its count
        //  2) remove from map
        //  3) Append the characters to result string based on its count
        for(int i=0; i<= order.length()-1 ; i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.remove(c);
                for(int j = 1 ; j<=count;j++){
                    result[n] = c ;
                    n = n+1 ;
                }
            }

        }
        //After processing all characters from order string, there will be remaining characters from input string which aren't present in the order string
        //For remaining characters, we are iterating through HashMap and appending each character to result string.
        for(char c : map.keySet()){
            int count = map.get(c);
            for(int j = 1 ; j<=count;j++){
                result[n] = c ;
                n = n+1 ;
            }


        }
        return String.valueOf(result);
    }
}
