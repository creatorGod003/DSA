package Hash;
import java.util.HashMap;
import java.util.Set;

public class Intro {
	public static void main(String[] args) {
		
		//food->cost
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("buiscuit",10 );
		map.put("Dal",120 );
		map.put("mixture", 180 );
		map.put("Dal", 144);
		
		System.out.println(map.get("Dal"));
		System.out.println(map.get("rice"));
		
//		System.out.println(map.size());
		
		System.out.println(map.containsKey("Dal"));
		System.out.println(map.containsKey("Rice"));
		
		Set<String> keys = map.keySet();
		
		for(String s: keys) {
			System.out.println(s+"->"+map.get(s));
		}

		System.out.println(map.remove("Dal"));
		System.out.println(map.remove("biryani"));

	}
}

// order is not fixed in hashmap
// all methods work in O(1) time complexity
// put has two work : either it will add key-value pair or it will modify value corresponding to existing key
// get has two work : it will return value corresponsding to existing key or else return null.
// containsKey method tell whether that key is present in map or not.
// keyset method return set of keys in map
// remove method return null when key is not there else return removed pair.value