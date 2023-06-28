import java.util.*;

public class StringUtils {
    public static int countVowels(String str){
        if(str == null)
            return 0;

        str = str.toLowerCase();
        int count = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a','e','i','o','u'));
        for(char ch: str.toCharArray()){
            if(vowels.contains(ch))
                count++;
        }
        return count;
    }

    public static String reverseString(String str){
        if(str == null)
            return "";

        char[] reverse = str.toCharArray();
        for(int i = 0, j = reverse.length - 1; i < reverse.length / 2; i++,j--){
            char temp = reverse[i];
            reverse[i] = reverse[j];
            reverse[j] = temp;
        }
        return new String(reverse);
    }

    public static String reverseOrderOfWords(String str){
        if(str == null)
            return "";
        
        String[] words = str.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }

    public static String removeDuplicates(String str){
        if(str == null)
            return "";

        Set<Character> visited = new HashSet<>();
        char[] unique = new char[str.length()];
        int ind = 0;
        for(char ch: str.toCharArray()){
            if(!visited.contains(ch))
                unique[ind++] = ch;
            visited.add(ch);
        }
        return new String(unique).substring(0,ind);
    }

    public static char mostRepeatedChar(String str){
        if(str == null || str.equals(""))
            return '\0';

        Map<Character,Integer> map = new HashMap<>();

        char max = str.charAt(0);
        for(char ch: str.toCharArray()){
            if(map.containsKey(ch)){
                map.replace(ch, map.get(ch) + 1);
                if(map.get(max) < map.get(ch))
                    max = ch;
            }
            else
                map.put(ch,0);
        }

        return max;
    }

    public static String capitalizeFirstLetter(String str){
        if(str == null)
            return "";

        String[] words = str.trim().replaceAll(" +"," ").split(" ");

        for(int i = 0; i < words.length; i++){
            if(!words[i].isEmpty())
                words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ",words);
    }

    public static boolean areAnagramsSort(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }

    public static boolean isPalindrome(String str){
        if(str == null)
            return false;

        char[] chars = str.toCharArray();

        for(int i = 0, j = chars.length - 1; i < chars.length / 2; i++,j--){
            if(chars[i] != chars[j])
                return false;
        }
        return true;
    }

    public static boolean areRotations(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        return (str1 + str1).contains(str2);
    }
}
