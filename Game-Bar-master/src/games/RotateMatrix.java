package games;

public class RotateMatrix {
	public int[][] coords;

	public RotateMatrix() {
	}

	int[][] initialRotation(Shape shape) {
		int[][] rotatedShape = null;
	
	    rotatedShape = shape.RotateMatrix.transposeMatrix(shape, coords);
	
	    rotatedShape = shape.RotateMatrix.reverseRows(rotatedShape);
		return rotatedShape;
	}

	int[][] transposeMatrix(Shape shape, int[][] matrix) {
	    int[][] temp = new int[matrix[0].length][matrix.length];
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[0].length; j++) {
	            temp[j][i] = matrix[i][j];
	        }
	    }
	    return temp;
	}

	int[][] reverseRows(int[][] matrix) {
	
	    int middle = matrix.length / 2;
	
	    for (int i = 0; i < middle; i++) {
	        int[] temp = matrix[i];
	
	        matrix[i] = matrix[matrix.length - i - 1];
	        matrix[matrix.length - i - 1] = temp;
	    }
	
	    return matrix;
	
	}
}