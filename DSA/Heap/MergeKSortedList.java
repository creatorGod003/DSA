package Heap;

import java.io.*;
import java.util.*;

class Pair {

	int val;
	int buck_index;
	int data_index;

	public Pair(int val, int bi, int di) {
		this.val = val;
		buck_index = bi;
		data_index = di;
	}

}

class PairComparator implements Comparator<Pair> {
	public int compare(Pair p1, Pair p2) {
		return Integer.compare(p1.val, p2.val);
	}
}

public class MergeKSortedList {
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> list){
      ArrayList<Integer> rv = new ArrayList<>();

		PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
		ArrayList<Integer> index = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).size() != 0)
				index.add(0);
			else
				index.add(-1); // initializing with -1 with empty list
		}

		for (int i = 0; i < list.size(); i++) {

			if (index.get(i) != -1) {
				pq.add(new Pair(list.get(i).get(index.get(i)), i, index.get(i)));
			}

		}

		while (pq.size() != 0) {

			Pair p = pq.remove();
			rv.add(p.val);
			index.set(p.buck_index, (p.data_index + 1 != list.get(p.buck_index).size()) ? p.data_index + 1 : -1);

			if (index.get(p.buck_index) != -1) {
				pq.add(new Pair(list.get(p.buck_index).get(index.get(p.buck_index)), p.buck_index,
						index.get(p.buck_index)));
			}

		}

		return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}