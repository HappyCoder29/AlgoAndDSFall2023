import java.util.HashSet;
import java.util.List;

public class LC648ReplaceWords {
    //Link : https://leetcode.com/problems/replace-words/description/
    //In this program, we have to replace each word in the sentence with its shortest prefix from the dictionary

    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>();
        for(String s: dictionary){ // We are adding every word from dictionary to set
            set.add(s); // The reason we are doing this, because we want search o(1)
        }
        String arr[] = sentence.split(" "); // Now spliting sentence and putting into array
        StringBuilder result = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            String str = arr[i];
            boolean found = false;
            String newstr = new String();;
            String replaced = new String();
            //For each word, it iterates through its characters and checks if the current substring is a prefix of any word in the dictionary.

            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                newstr = newstr + c ;
                if(set.contains(newstr)){ //If a match is found, it sets found to true, and the replaced variable stores the prefix.
                    replaced = newstr ;
                    found = true ;
                    break ;
                }
            }
            if(found == true){
                result.append(replaced);

            }
            else{
                result.append(str);
            }
            result.append(" ");

        }
        return result.toString().trim();  //it converts the result StringBuilder to a string,
    }
}
