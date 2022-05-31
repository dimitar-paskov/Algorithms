/**
 * @author dimitar
 *
 */
package exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06ConnectedAreaInMatrix {

	private static class Area {
		private int startRow;
		private int startCol;
		private int size;

		Area(int row, int col) {
			this.startRow = row;
			this.startCol = col;
			this.size = 0;
		}

		public int getStartRow() {
			return startRow;
		}

		public void setStartRow(int startRow) {
			this.startRow = startRow;
		}

		public int getStartCol() {
			return startCol;
		}

		public void setStartCol(int startCol) {
			this.startCol = startCol;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		
		
		

	}
	
	private static List<Area> foundAreas = new ArrayList<>();

	

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
				

		int rows = Integer.parseInt(scanner.nextLine());
		int cols = Integer.parseInt(scanner.nextLine());
		
		int[] count = new int[1];
		count[0]=0;

		char[][] matrix = new char[rows][cols];
		char[][] traverseMatrix = new char[rows][cols];

		for (int i = 0; i < rows; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < line.length(); j++) {
				matrix[i][j] = line.charAt(j);
				traverseMatrix[i][j] = line.charAt(j);
			}
		}
		
		Area area = new Area(0,0);
		
		while(area.getStartRow() != -1 && area.getStartCol() != -1) {
			
			 traverseMatrix(traverseMatrix, area.getStartRow(), area.getStartCol(), count);
			
			if(count[0] > 0) {
				area.setSize(count[0]);
				foundAreas.add(area);
			}
			
			count[0]= 0;
			area = checkForNextStartPoint(traverseMatrix);
			
		}
		
		System.out.println("Total areas found: " + foundAreas.size());
		
		foundAreas = foundAreas.stream().sorted((e1,e2)-> {
			
//			if(e1.getSize() - e2.getSize() > 0) {
//				return -1;
//			}else if(e1.getSize() - e2.getSize() < 0){
//				return 1;
//			}else {
//				
//				if(e1.getStartRow() - e1.getStartRow() > 0) {
//					return 1;
//				}else if(e1.getStartRow() - e1.getStartRow() < 0) {
//					return -1;
//				}else {
//					return e1.getStartCol() - e2.getStartCol();
//				}
//				
//			}

			return e2.getSize() - e1.getSize(); 
			
		}).collect(Collectors.toList());
		
		
		for (int i = 0; i < foundAreas.size(); i++) {
			
			System.out.println(
					String.format("Area #%d at (%d, %d), size: %d"
							, i+1 ,foundAreas.get(i).getStartRow(),foundAreas.get(i).getStartCol(),foundAreas.get(i).getSize() ));
		}

	}



	private static void traverseMatrix(char[][] matrix, int row, int col , int[] count ) {
		

		if(isInBounds(row, col, matrix)) {
			
			
			if(matrix[row][col]=='-') {
				
			
			
			matrix[row][col] = 'V';
			count[0]++;
			traverseMatrix(matrix, row+1,col, count);
			traverseMatrix(matrix, row-1,col, count);
			traverseMatrix(matrix, row,col+1, count);
			traverseMatrix(matrix, row,col-1, count);
			return ;
			}
		}
	}



	private static boolean isInBounds(int row, int col, char[][] matrix) {
		
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
	}



	private static Area checkForNextStartPoint(char[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]=='-') {
					return new Area(i,j);
				}
			}
		}
		
		return new Area(-1,-1);
	}

}
