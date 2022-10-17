// program to compute character with highest frequency in a string.

package Hash;
import java.io.*;
import java.util.*;

public class Highest_Freq_Char {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        
        char freq_char = ' ';
        int max = 0;
        
        for(Character ch: map.keySet()){
            
            if(max<map.get(ch)){
                max = map.get(ch);
                freq_char = ch;
            }
            
        }
        
        System.out.println(freq_char);
        
    }

}