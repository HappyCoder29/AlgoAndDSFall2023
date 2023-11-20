public class LC557ReverseWordsinaStringIII {
    /*
    Link : https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
    In this program, we have to reverse every characters of each words in the string while maintaining the order of words.
     */
    public String reverseWords(String s) {
        String strs[] = s.split(" "); // Split the string based on space character

        String result="";
        for(String str : strs){ // Iterate through each word from Array of strings

            for(int i=str.length() -1 ; i>=0 ;i--){
                result = result + str.charAt(i); //For each word it iterates through its characters in reverse order and appends each character to
                //the result string.
            }
            result = result + " "; // After reverse, append space at the end of each word.
        }
        return result.trim() ;  // Trim trailing spaces
    }
}
