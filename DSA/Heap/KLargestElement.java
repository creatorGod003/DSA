package Heap;
import java.util.*;

/*
 * Problem : find the k number of largest element in the array.
 * T.C : O(nlogk)
 * */

public class KLargestElement {
	public static void main(String[] args) {
		int[] arr = {2,7, 6, 5, 3, 2, 1};
		int n = arr.length;
		int k = 3;
		
		kLargestNos(arr, n, k);
	}
	
	public static void kLargestNos(int[] arr, int n, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			if(i<k) {
				pq.add(arr[i]);
			}
			else {
				if(pq.peek()<arr[i]) {
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		
		while(pq.size()!=0) {
			System.out.print(pq.remove()+" ");
		}
		
	}
	
}
