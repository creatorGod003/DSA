package Hash;
import java.io.*;
import java.util.*;

//1. You are given a number n1, representing the size of array a1.
//2. You are given n1 numbers, representing elements of array a1.
//3. You are given a number n2, representing the size of array a2.
//4. You are given n2 numbers, representing elements of array a2.
//5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).

public class Common_Elements{

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    
    int n1 = sc.nextInt();
    int[] arr1 = new int[n1];
    
    for(int i=0;i<n1;i++){
        arr1[i] = sc.nextInt();
    }
    
    int n2 = sc.nextInt();
    int[] arr2 = new int[n2];
    
    for(int i=0;i<n2;i++){
        arr2[i] = sc.nextInt();
    }
    
    Set<Integer> set = new HashSet<>();
    
    for(int i=0;i<n1;i++){
        set.add(arr1[i]);
    }
    
    Set<Integer> res = new LinkedHashSet<>();
    
    for(int i=0;i<n2;i++){
        if(set.contains(arr2[i])){
            res.add(arr2[i]);
        }
    }
    
    for(int i : res){
        System.out.println(i);
    }
    
 }

}

// Note: LinkedHashSet and HashSet both have same time complexity 