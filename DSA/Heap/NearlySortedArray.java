package Heap;

import java.util.PriorityQueue;

// print sorted array
public class NearlySortedArray {
	public static void main(String[] args) {
		
		int[] arr = {3, 1, 5, 2, 6, 4, 7};
		int n = arr.length;
		int k = 2;
		
		sort_array(arr, n, k);
		
	}
	
	public static void sort_array(int[] arr, int n, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		for(int i=0;i<=n;i++) {  //O(n-k)
			
			if(i<=k)pq.add(arr[i]);
			
			if(i==n){
				while(!pq.isEmpty()) {
					System.out.print(pq.remove()+" ");
				}
				break;
			}
			
			if(i>=k+1 && i<n) {
				System.out.print(pq.remove()+" ");
				pq.add(arr[i]);
			}
		
		}
		
	}
}
