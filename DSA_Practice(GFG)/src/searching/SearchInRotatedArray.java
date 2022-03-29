package searching;

public class SearchInRotatedArray {

	public static int searchInRotated(int array[], int low, int high, int element) {

		int mid = (low + high) / 2;
		int left = array[low];
		int right = array[high];

		while (low < high) {
			if (element == left)
				return low;
			if (element == right)
				return high;
			mid = (low + high) / 2;
			if (array[mid] == element) {
				return mid;
			} else {
				if (left < array[mid]) {
					if (element < array[mid] && element >= left) {
						high = mid - 1;
						right = array[high];
					} else {
						low = mid + 1;
						left = array[low];
					}
				} else if (array[mid] < right) {
					if (element > array[mid] && element <= right) {
						low = mid + 1;
						left = array[low];
					} else {
						high = mid - 1;
						right = array[high];
					}
				}
				else {
					return -1;
				}

			}

		}
		return -1;

	}

	public static void main(String[] args) {
		int array[] = { 100, 200, 300, 400, 500, 600, 700, 800, -12, -10, -2, -1, 0};
		System.out.println(searchInRotated(array, 0, array.length - 1, -10));
	}

}
