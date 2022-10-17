package Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HM_Implementation {

	static class MyHashMap<K, V> {

		LinkedList<HMNode>[] buckets;
		int size; // calculate the number of pair in map
		double thresold;

		private class HMNode {
			K key;
			V value;

			HMNode(K key, V value) {
				this.key = key;
				this.value = value;
			}

		}

		public MyHashMap() {
			init_bucket(4); // default size of bucket is 4
			size = 0; // no pair in map
			thresold = 2.0;
		}

		private void init_bucket(int N) {

			buckets = new LinkedList[N];
			// System.out.println(Arrays.toString(buckets));

			for (int i = 0; i < N; i++) {
				buckets[i] = new LinkedList<HMNode>();
			}

		}

		public void put(K key, V value) {

			int buck_index = hash_func(key);
			int node_index = index_node(key);

			if (node_index == -1) {
				HMNode node = new HMNode(key, value);
				buckets[buck_index].add(node);
				size++;
			} else {
				buckets[buck_index].get(node_index).value = value;
			}

//			check the value of load factor lambda whether it crossed the thresold value?

			double lambda = size / (double) buckets.length;
			if (lambda > thresold) {
				rehash();
			}

		}

		@SuppressWarnings("unchecked")
		private void rehash() {

			List<HMNode> nodes = new ArrayList<>();

			for (int i = 0; i < buckets.length; i++) {

				for (HMNode x : buckets[i]) {
					nodes.add(x);
				}

			}

			init_bucket(buckets.length * 2);
			thresold = buckets.length;

			for (HMNode x : nodes) {
				int buck_index = hash_func(x.key);
				HMNode node = new HMNode(x.key, x.value); 
				buckets[buck_index].add(node);

				// or simply
				// buckets[buck_index].add(x);

			}

		}

		private int hash_func(K key) {
			return Math.abs(key.hashCode()) % buckets.length;
		}

		private int index_node(K key) {

			int buck_index = hash_func(key);
			int ind = 0;
			for (HMNode x : buckets[buck_index]) {
				if (x.key.equals(key)) {
					return ind;
				}
				ind++;
			}

			return -1;
		}

		public boolean containsKey(K key) {

			int node_index = index_node(key);

			if (node_index == -1) {
				return false;
			} else {
				return true;
			}

		}

		public V get(K key) {

			int buck_index = hash_func(key);
			int node_index = index_node(key);

			if (node_index == -1) {
				return null;
			} else {
				return buckets[buck_index].get(node_index).value;
			}

		}

		public V remove(K key) {

			int buck_index = hash_func(key);
			int node_index = index_node(key);

			if (node_index == -1) {
				return null;
			} else {
				HMNode rem_node = buckets[buck_index].remove(node_index);
				size--;
				return rem_node.value;
			}

		}

		public List<K> keySet() {

			List<K> keys = new ArrayList<>();

			for (int i = 0; i < buckets.length; i++) {

				for (HMNode x : buckets[i]) {
					keys.add(x.key);
				}

			}

			return keys;
		}

		public int size() {
			return size;
		}

		public void display() {
			System.out.println("Display Begins");
			for (int bi = 0; bi < buckets.length; bi++) {
				System.out.print("Bucket" + bi + " ");
				for (HMNode node : buckets[bi]) {
					System.out.print(node.key + "@" + node.value + " ");
				}
				System.out.println(".");
			}
			System.out.println("Display Ends");
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MyHashMap<String, Integer> map = new MyHashMap<>();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("put")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				Integer val = Integer.parseInt(parts[2]);
				map.put(key, val);
			} else if (str.startsWith("get")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				System.out.println(map.get(key));
			} else if (str.startsWith("containsKey")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				System.out.println(map.containsKey(key));
			} else if (str.startsWith("remove")) {
				String[] parts = str.split(" ");
				String key = parts[1];
				System.out.println(map.remove(key));
			} else if (str.startsWith("size")) {
				System.out.println(map.size());
			} else if (str.startsWith("keyset")) {
				System.out.println(map.keySet());
			} else if (str.startsWith("display")) {
				map.display();
			}
			str = br.readLine();
		}
	}

}
