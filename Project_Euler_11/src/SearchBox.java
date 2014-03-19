import java.util.Scanner;

/**
 * DESCRIPTION:
 *  The class SearchBox takes in a string of numeric values, 
 *  converts these values to a 2D array called "box," and 
 *  provides methods for taking linear subarrays of "box."
 * 
 * FIELDS:
 * 	public int[][] box;
 * 	public int   rowDim;
 * 	public int   colDim;
 *  public String searchStr;
 * 
 * CONSTRUCTORS:
 * public SearchBox(String inputStr, int inputRowDim, int inputColDim)
 *  -Constructor takes in a string of values and the dimensions of the box to create
 * 
 * METHODS:
 * public int[][] boxify(String inputStr, int rDim, int cDim)
 *  -Take a string and turn it into a box of numbers
 * 
 * public boolean isInBounds(int row, int col)
 *  -Tests if indices are within the bounds of "box"
 *  
 * public int[] subArr(String dir, int startRow, int startCol, int length)
 *  -Gives a subarray directly to the right, down, up-right, or down-right
 *  
 * public int[] increment(String dir, int row, int col)
 *  -move from location on box one step in direction "dir"
 *  -variable "dir" can only take values "r" "d" "ur" and "dr"
 *  
 * @author mathcadd
 *
 */

public class SearchBox {
	
	public int[][] box;
	public int   rowDim;
	public int   colDim;
	public String searchStr;
	
	// Constructor takes in a string of values and the dimensions of the box to create
	// Must run .boxify() to turn array to box
	public SearchBox(String inputStr, int inputRowDim, int inputColDim){
		rowDim = inputRowDim;
		colDim = inputColDim;
		searchStr = inputStr;
		box = new int[rowDim][colDim];
	}
	
	// Take a string and turn it into a box of numbers
	public void boxify(){
		
		int[][] arr = new int[rowDim][colDim]; // the 2d array to be output
		
		// scan in the input string
		Scanner s = new Scanner(this.searchStr);
		
		// turn string into a tokenized int array
		int[] tokenized = new int[rowDim*colDim];
		int i=0;
		while(s.hasNext()){
			tokenized[i] = s.nextInt();
			i++;
		}
			
		// put tokens into a box
		for (i=0;i<rowDim;i++){
			for (int j=0;j<colDim;j++)
				arr[i][j] = tokenized[i*colDim+j];
		}
		
		// close scanner and return the box (2d array) of numbers
		s.close();
		this.box = arr;
		
	}
	
	// Tests if indices are within the bounds of "box"
	public boolean isInBounds(int row, int col){
		return( (0<=row) && (row<rowDim) && (0<=col) && (col<colDim) );
	}
	
	// Gives a subarray directly to the right, down, up-right, or down-right
	public int[] subArr(String dir, int startRow, int startCol, int length){
		
		int[] subArr = new int[length];
		int[] incrementedPair = {startRow, startCol};
		
		for (int i=0; i<length;i++){
			
			if(isInBounds(incrementedPair[0],incrementedPair[1]))
				subArr[i] = this.box[incrementedPair[0]][incrementedPair[1]];
			else
				return null; // return a null array if out of bounds
			
			incrementedPair = increment(dir, incrementedPair[0], incrementedPair[1]);
			
		}
		
		return subArr; // return subarray of length "length"
	}
	
	// move from location on box one step in direction "dir"
	// variable "dir" can only take values "r" "d" "ur" and "dr"
	public int[] increment(String dir, int row, int col){
		
		// incremented row and column to return
		int[] pair = {row, col}; 
		
		if (dir.equals("r")) // move right
			pair[1]++; // col increases by one
		else if (dir.equals("d")) // move down
			pair[0]++; // row increases by one
		else if (dir.equals("ur")){ // move diagonally up and right
			pair[0]--; pair[1]++;}
		else if (dir.equals("dr")){ // move diagonally down and right
			pair[0]++; pair[1]++;}
		
		// return incremented pair
		return pair;
	}

}
