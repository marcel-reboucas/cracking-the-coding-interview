package chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Write an algorithm such that if an element in an MxN matrix is 0,
 *  its entire row and column are set to 0.
 *
 * Possible improvements after seeing the solution:
 * - could have done it with a boolean array instead of two sets.
 */

public class Question7 {

	static void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0) { return; }

		int rows = matrix.length;
		int columns = matrix[0].length;

		Set<Integer> rowsSet = new HashSet<Integer>();
		Set<Integer> columnsSet = new HashSet<Integer>();

		for (int i = 0; i< rows; i++) {
			for (int j = 0; j <columns; j++) {
				if (matrix[i][j] == 0) {
					rowsSet.add(i);
					columnsSet.add(j);
				}
			}
		}

		for (Integer r : rowsSet) {
			for (int j = 0; j < columns; j++) {
				matrix[r][j] = 0;
			}
		}

		for (Integer c : columnsSet) {
			for (int i = 0; i < rows; i++) {
				matrix[i][c] = 0;
			}
		}

	}

	public static void main(String[] args) {	

		int[][] matrix = new int[][]{{0,0,3},{1,2,3},{1,2,1}}; 

		setZeroes(matrix);

		for (int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
