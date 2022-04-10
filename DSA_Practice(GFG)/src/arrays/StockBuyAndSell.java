package arrays;

public class StockBuyAndSell {
	
	public static int buyAndSell(int array[]) {
		
		int minStock = Integer.MAX_VALUE;
		int buyTheStock = 0;
		for(int i=0; i<array.length-1; i++) {
			
			if(array[i] < array[i+1]) {
				minStock = Math.min(minStock, array[i]);
				buyTheStock = Math.max(buyTheStock, array[i+1] - minStock);
			}
			
		}
		return buyTheStock;
	}
	
	public static void main(String[] args) {
		int array[] = {5, 4, 3, 2 ,5,1, 7};
		System.out.println(buyAndSell(array));
	}
	
}
