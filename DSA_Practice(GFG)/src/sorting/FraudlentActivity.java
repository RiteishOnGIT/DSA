package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FraudlentActivity {
	
	public static int binarySearch(LinkedList<Integer> ll, int low ,int high, int element) {
		if(low > high)return -1;
		int mid = (low+high)/2;
		
		if(element == ll.get(mid))return mid;
		if(mid == 0 && element < ll.get(mid))return -1;
		if(element > ll.get(mid-1) && element <= ll.get(mid)) {
			return mid;
		}
		else if(element < ll.get(mid)) {
			return binarySearch(ll, low, mid-1, element);
		}
		else {
			return binarySearch(ll, mid+1, high, element);
		}
		
	}
	
	
	public static int fraudlentActivity(List<Integer> expenditure, int d) {
		
		int notifications = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<d; i++) {
			list.add(expenditure.get(i));
		}
		Collections.sort(list);
		
		for(int i=d; i<expenditure.size()-1; i++) {
			int median = 0;
			if(d %2 == 0) {
				median = list.get(d/2) + list.get((d/2)-1);
			}
			else {
				median = list.get(d/2);
			}
			int revenue = expenditure.get(i);
			if(revenue >= 2*median)notifications++;
			
			if(expenditure.get(i) < list.get(0)) {
				list.add(0, expenditure.get(i));
			}
			else if(expenditure.get(i) > list.get(list.size()-1)) {
				list.add(list.size(), expenditure.get(i));
			}
			else {
				list.add(binarySearch(list, 0, d-1, expenditure.get(i)), expenditure.get(i));
			}
			list.remove(0);
		}
		
		return notifications;
	}
	
	
	
	public static void main(String[] args) {
		
		List<Integer>list = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5));
		fraudlentActivity(list, 5);
	}
	
}
