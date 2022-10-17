package Heap;
import java.util.PriorityQueue;

public class PriorityQueueLearning {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(10);
		pq.add(9);
		pq.add(8);
		pq.add(28);
		
		System.out.println(pq.peek());
		
	}
	
}

// PriorityQueue is another data structure which poll the elements out based on their priority.
// priority Queue method: add(ele)    T.C : O(logn) 
//priority Queue method: remove(ele)    T.C : O(logn)
//priority Queue method: peek()    T.C : O(1)
// By default Priority Queue gives more priority to smallest element.
// We can use comparator Collections.reverseOrder() to revert the nature.