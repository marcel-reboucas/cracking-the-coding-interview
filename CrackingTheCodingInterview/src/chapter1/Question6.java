package chapter1;

/**
 * 
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 *
 * Possible improvements after seeing the solution: - could have done it in
 * place.
 */
public class Question6 {

	public static int[][] rotateMatrix(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) {
			return matrix;
		}

		int columns = matrix[0].length;

		int[][] rotatedMatrix = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				rotatedMatrix[j][rows - 1 - i] = matrix[i][j];
			}
		}
		return rotatedMatrix;
	}

	public static void main(String[] args) {
		int[][] image = new int[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[][] rotatedImage = rotateMatrix(image);

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(rotatedImage[i][j] + " ");
			}
			System.out.println();
		}
	}
}
