package additional;

public class RotateTheBox {

	public static void beforHash(char array[], int hash, int i, int j) {
		if(i > j) {
			for(int x= i; x>= j; x--) {
				if(hash != 0) {
					array[x] = '#';
					hash--;
				}
				else {
					array[x] = '.';
				}
			}
		}
		
		
	}
	
	
	
	public static char [][] gravity(char array[][]) {
		
		char newBox [][] = new char[array[0].length][array.length];
		for(int k =0; k<array.length; k++) {
			int hash = 0;
			int j = 0;
			int i=0;
			for(i=0; i<array[k].length; i++) {
				if(array[k][i] == '#')hash++;
				if(array[k][i] == '*') {
					
					beforHash(array[k], hash, i-1, j);
					hash = 0;
					j = i+1;
				}
			}
			beforHash(array[k], hash, i-1, j);
			
		}
		
		int k = array.length-1;
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				newBox[j][k] = array[i][j];
			}
			k--;
		}
		
		return newBox;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//'#','.','#','#', '.', '.', '.', '.', '.'
		//'#','.','#','#', '*', '#', '*', '#', '*'
		char [][] array = {{'#','.','#','#', '*', '#', '*', '#', '*'},
						   {'#','.','#','#', '.', '.', '.', '.', '.'},
						   {'#','.','#','#', '.', '.', '.', '.', '.'}
							};
		array = gravity(array);
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	
	}

}
