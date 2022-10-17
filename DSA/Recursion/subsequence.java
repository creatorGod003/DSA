import java.util.*;

public class subsequence{

    List<String> subsequence = new ArrayList<>();

    public static void main(String[] args){
        String str = "aced";
        subsequence obj = new subsequence();
        System.out.println(obj.mAllPossibleStrings(str));
    }
     public List<String> AllPossibleStrings(String s)
    {
        
        helper(s, new String(""), 0);
        Collections.sort(subsequence);
        return subsequence;
    }
    
    public void helper(String str, String s, int i){
        
        if(i==str.length()){
            if(s.length()!=0){
                subsequence.add(s);
            }
            return;
        }
        
        helper(str, s+(str.charAt(i)), i+1);
        helper(str, s, i+1);
        
    }
}

// if here string is mutable we won't get same result instead it will get override by each call. 