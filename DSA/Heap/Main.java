package Heap;
import java.io.*;
import java.util.*;
// implementing median priority queue
public class Main {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
      left.addAll(right);
      right.clear();
      left.add(val);
    }

    public int remove() {
        
        if(right.size()==0 && left.size()==0){
            System.out.println("Underflow");
            return -1;
        }
        
        if(right.size()!=0){
            left.addAll(right);
            right.clear();
        }   
          
          int size_to_rem = left.size()/2;
      
          while(size_to_rem-->=0){
              right.add(left.remove());
          }
          
          return  right.remove();
            
    }
    
    public int peek() {
      
      if(right.size()==0 && left.size()==0){
            System.out.println("Underflow");
            return -1;
        }
      
          if(right.size()!=0){
              left.addAll(right);
              right.clear();
          }   
          int size_to_rem =left.size()/2;
      
          while(size_to_rem-->=0){
              right.add(left.remove());
          }
          
          return  right.peek();
            
    }
    

    public int size() {
      return left.size()+right.size();
    }
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }      
      str = br.readLine();
    }
  }
}
