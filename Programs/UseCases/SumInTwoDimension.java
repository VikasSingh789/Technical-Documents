import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumInTwoDimension {

	static class Cell {
		int r;
		int c;

		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		int rows = 3, columns = 3;
		int[][] arr = new int[rows][columns];

		int value = 1;
		int removeArrayInc = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = value;
				value++;
			}
		}
		Cell removeArray[] = new Cell[rows * columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				removeArray[removeArrayInc] = new Cell(i, j);
				removeArrayInc++;
			}

		}
		minSumofArray(arr, removeArray, removeArrayInc);

	}

	private static void minSumofArray(int[][] arr, Cell[] removeArray, int removeArrayInc) throws InterruptedException {
		int sum = 0;
		List<Integer> sumList = new ArrayList<>();

		// Printing the array
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		for (int k = 0; k < removeArrayInc; k++) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (i == removeArray[k].r || j == removeArray[k].c) {
						continue;
					}
					sum = sum + arr[i][j];
				}
			}
			sumList.add(sum);
			sum = 0;

		}

		System.out.println("Output -->" + sumList);
		System.out.println("Output -->" + Collections.min(sumList));

	}

}

//input:-     1  2  3
//            4  5  6
//            7  8  9
//
//output:-    12    

// Co-ordinates
//--------------
// 0,0  0,1  0,2
// 1,0  1,1  1,2
// 2,0  2,1  2,2
