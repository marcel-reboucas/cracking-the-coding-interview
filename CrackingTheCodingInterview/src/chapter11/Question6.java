package chapter11;

/***
 * 11.6 Given an M X N matrix in which each row and each column is sorted in
 * ascending order, write a method to find an element.
 * 
 * @author Marcel
 *
 */
public class Question6 {

//	public static int find(int[][] array, int element) {
//		
//		if (array.length == 0) { return -1; }
//		
//		int currentRow = 0;
//		int currentCol = array[0].length - 1;
//		
//		while(currentRow < array.length && currentCol > 0) {
//			
//			if (array[currentRow][currentCol] == element) {
//				return element;
//			} else if (array[currentRow][currentCol] > element) {
//				currentCol -= 1;
//			} else {
//				currentRow += 1;
//			}
//		}
//		
//		return -1;
//	}
//	
//	public static void main(String[] args) {
//		
//		int[][] matrix = new int[][]{{1,2,3,4}, {3,5,6,7}, {4, 6, 7, 9}, {5, 20, 21, 23}};
//		
//		System.out.println(find(matrix, 6));
//		System.out.println(find(matrix, 0));
//		System.out.println(find(matrix, 3));
//		System.out.println(find(matrix, 20));
//		System.out.println(find(matrix, 4));
//	}

}
