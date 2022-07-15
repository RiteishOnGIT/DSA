package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountTripletGp {

	static Long binomialCoeff(Long n, Integer k) {
		Long[] C = new Long[k + 1];
		
		for(int i=0; i<C.length; i++)C[i] = 0l;
		
		C[0] = 1l; // nC0 is 1
		for (int i = 1; i <= n; i++) {

			for (int j = (int) Math.min(i, k); j > 0; j--)
				C[j] = C[j] + C[(int) (j - 1)];
		}
		return C[k];
	}

	public static Long countTriplets(List<Long> arr, Long r) {

		HashMap<Long, Long> frequencyHashMap = new HashMap<Long, Long>();

		Collections.sort(arr);
		arr.stream().forEach(element -> {
			if (frequencyHashMap.containsKey(element)) {
				frequencyHashMap.put(element, frequencyHashMap.get(element) + 1);
			} else {
				frequencyHashMap.put(element, 1l);
			}
		});

		Long triplets = 0l;
		 if(r == 1){
			 long ans = 0l;
			 for(Entry<Long, Long> i : frequencyHashMap.entrySet())
		        {
		             
		            ans += binomialCoeff(i.getValue(), 3);
		        }
		        return ans;
	       }
		for (int i = 0; i < arr.size() - 2; i++) {
			long a = arr.get(i) * r;
			long b = arr.get(i) * r * r;
			if (frequencyHashMap.containsKey(a) && frequencyHashMap.containsKey(b)) {
				triplets += frequencyHashMap.get(a) * frequencyHashMap.get(b);
			}
			frequencyHashMap.put(arr.get(i), frequencyHashMap.get(arr.get(i)) - 1);
			if (frequencyHashMap.get(arr.get(i)) == 0) {
				frequencyHashMap.remove(arr.get(i));
			}

		}
		return triplets;
	}

	public static void main(String[] args) {
		List<Long> list = new ArrayList<Long>(List.of(1l, 1l, 1l, 1l, 1l, 1l));
		System.out.println(countTriplets(list, 1l));
	}

}
