package lab2;
/*Задача 14.
Дана разреженная матрицы (CCS).
Переставить строки в матрице по возрастанию сумм элементов в этих строках. */
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] values = {2, 1, 3, 5, 7};
        int[] rowIndices = {1, 3, 0, 2, 3};
        int[] colPointers = {0, 1, 2, 3, 5};
        int numRows = 4;
        int numCols = 4;

        Matrix matrix = new Matrix(values, rowIndices, colPointers, numRows, numCols);

        System.out.println("Исходная матрица:");
        printMatrix(matrix.toDense());

        double[] sums = Sorter.computeRowSums(matrix);
        System.out.println("Суммы строк: " + Arrays.toString(sums));

        int[] order = Sorter.sortRowsBySum(sums);
        System.out.println("Порядок строк по возрастанию суммы: " + Arrays.toString(order));

        Matrix sortedMatrix = matrix.reorderRows(order);

        System.out.println("Матрица после перестановки строк:");
        printMatrix(sortedMatrix.toDense());
    }

    private static void printMatrix(double[][] dense) {
        for (double[] row : dense) {
            System.out.println(Arrays.toString(row));
        }
    }
}