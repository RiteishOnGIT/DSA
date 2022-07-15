
public class MergeSort {

	static void merge(int arr[], int l, int m, int h) {

		int i = l;
		int j = m + 1;
		int k = 0;
		int tempArr[] = new int[h - l + 1];
		while (i <= m && j <= h) {
			if (arr[i] <= arr[j])
				tempArr[k++] = arr[i++];
			else if (arr[i] > arr[j])
				tempArr[k++] = arr[j++];
		}
		while (i <= m)
			tempArr[k++] = arr[i++];
		while (j <= h)
			tempArr[k++] = arr[j++];
		k = 0;
		for (i = l; i <= h; i++)
			arr[i] = tempArr[k++];

	}

	public static void mergeSort(int arr[], int l, int h) {
		System.out.println(l + " " + h);
		if (l >= h)
			return;
		int mid = (l + h) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, h);
		merge(arr, l, mid, h);
		
	}

	public static void main(String[] args) {
		int arr[] = { 4, 1, 3, 9, 7 };
		mergeSort(arr, 0, arr.length-1);
	}
}
