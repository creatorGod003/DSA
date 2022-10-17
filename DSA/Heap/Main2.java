package Heap;

import java.io.*;
import java.util.*;

public class Main2 {

	public static class PriorityQueue {
		ArrayList<Integer> pq;
		int size;

		public PriorityQueue() {
			pq = new ArrayList<>();
			size = 0;
		}

		public void add(int val) {
			pq.add(val);
			size++;

			int curr_index = size - 1;
			int update_index = (int) Math.ceil(curr_index / 2.0) - 1;

			while (update_index >= 0) {

				if (pq.get(update_index) > pq.get(curr_index)) {
					int temp = pq.get(update_index);
					pq.set(update_index, pq.get(curr_index));
					pq.set(curr_index, temp);
				} else
					break;

				curr_index = update_index;
				update_index = (int) Math.ceil(curr_index / 2.0) - 1;

			}

		}

		public int remove() {

			if (size == 0) {
				System.out.println("Underflow");
				return -1;
			}

			int removed_val = pq.get(0);

			int tem = pq.get(0);
			pq.set(0, pq.get(size - 1));
			pq.set(size - 1, tem);

			pq.remove(size - 1);
			size--;

			int parent_index = 0;

			while (parent_index >= 0) {

				int rchild_index = 2 * parent_index + 2;
				int lchild_index = 2 * parent_index + 1;

				if (rchild_index >= size) {

					if (lchild_index >= size) {
						break;
					} else {
						if (pq.get(lchild_index) < pq.get(parent_index)) {

							int temp = pq.get(parent_index);
							pq.set(parent_index, pq.get(lchild_index));
							pq.set(lchild_index, temp);

							parent_index = lchild_index;

						} else
							break;
					}
				} else {
					if (pq.get(rchild_index) > pq.get(lchild_index)) {
						if (pq.get(parent_index) > pq.get(lchild_index)) {
							int temp = pq.get(parent_index);
							pq.set(parent_index, pq.get(lchild_index));
							pq.set(lchild_index, temp);

							parent_index = lchild_index;
						} else
							break;
					} else {

						if (pq.get(parent_index) > pq.get(rchild_index)) {
							int temp = pq.get(parent_index);
							pq.set(parent_index, pq.get(rchild_index));
							pq.set(rchild_index, temp);

							parent_index = rchild_index;
						} else
							break;

					}
				}

			}

			return removed_val;

		}

		public int peek() {
			if (size == 0) {
				System.out.println("Underflow");
				return -1;
			} else {
				return pq.get(0);
			}
		}

		public int size() {
			return size;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue qu = new PriorityQueue();

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