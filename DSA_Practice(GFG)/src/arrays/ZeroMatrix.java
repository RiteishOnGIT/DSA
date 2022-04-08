package arrays;

public class ZeroMatrix {

	public static void setZeroes(int [][]matrix) {
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = Math.abs(matrix[i][j]);
				if(matrix[i][j] == 0) {
					matrix[i][0] = -1;
					matrix[0][j] = -1;
				}
			}
		}
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[][] = {{0,1,2,0},{3,4,5,0},{1,3,0,5}};
		setZeroes(array);
	}

}
