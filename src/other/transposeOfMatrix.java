package other;

public class transposeOfMatrix {
	
	public void makeTranspose(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int count = 1;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= count; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
			count ++;
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(mat[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	public void rotateMatrix(int[][] mat) {
		makeTranspose(mat);
		int n = mat.length, m = mat[0].length;
		for(int i = 0; i < m / 2; i ++) {
			for(int j = 0; j < n; j ++) {
				int temp = mat[j][i];
				mat[j][i] = mat[j][m - i - 1];
				mat[j][m - i - 1] = temp;
			}
		}
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < m; j ++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		transposeOfMatrix tr = new transposeOfMatrix();
		int[][] mat = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		//tr.makeTranspose(mat);
		System.out.println("\n");
		tr.rotateMatrix(mat);
	}

}
