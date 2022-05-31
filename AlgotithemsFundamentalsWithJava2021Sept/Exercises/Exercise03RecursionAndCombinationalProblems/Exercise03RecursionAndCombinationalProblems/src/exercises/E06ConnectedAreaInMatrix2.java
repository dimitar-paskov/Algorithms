/**
 * @author dimitar
 *
 */
package exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class E06ConnectedAreaInMatrix2 {

	private static char[][] matrix;
	private static List<int[]> areas;

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		int rows = Integer.parseInt(scanner.nextLine());
		int cols = Integer.parseInt(scanner.nextLine());

		matrix = new char[rows][cols];

		for (int i = 0; i < rows; i++) {
			matrix[i] = scanner.nextLine().toCharArray();

		}

		areas = new ArrayList<>();

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				if (matrix[r][c] == '-') {
					areas.add(new int[] { r, c, 0 });
					findAreas(r, c);

				}
			}

		}

		System.out.println("Total areas found: " + areas.size());

		AtomicInteger counter = new AtomicInteger(1);

		areas.stream().sorted((f, s) -> Integer.compare(s[2], f[2])).forEach(a -> {
			System.out
					.println("Area #" + counter.getAndIncrement() + " at (" + a[0] + ", " + a[1] + "), size: " + a[2]);
		});

	}

	private static void findAreas(int row, int col) {

		if (isOutOfBounds(row, col) || isNotTraversable(row, col)) {
			return;
		}

		matrix[row][col] = 'V';

		areas.get(areas.size() - 1)[2]++;

		findAreas(row + 1, col);
		findAreas(row, col + 1);
		findAreas(row - 1, col);
		findAreas(row, col - 1);

	}

	private static boolean isNotTraversable(int row, int col) {

		return matrix[row][col] == 'V' || matrix[row][col] == '*';
	}

	private static boolean isOutOfBounds(int row, int col) {

		return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
	}

}
