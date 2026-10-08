package lab2;
/*Задача 14.
Дана разреженная матрицы (CCS).
Переставить строки в матрице по возрастанию сумм элементов в этих строках. */
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] values = {1, 5, 2, 3, 7};
        int[] rowIndices = {1, 3, 0, 2, 3};
        int[] colPointers = {0, 2, 3, 4, 5};
        int numRows = 4;
        int numCols = 4;
        Matrix matrix = new Matrix(values, rowIndices, colPointers, numRows, numCols);
        System.out.println("Исходная матрица:");
        matrix.print();
        double[] sums = Sorter.computeRowSums(matrix);
        System.out.println("Суммы строк: " + Arrays.toString(sums));
        int[] order = Sorter.sortRowsBySum(sums);
        System.out.println("Порядок строк по возрастанию суммы: " + Arrays.toString(order));
        Matrix sortedMatrix = matrix.reorderRows(order);
        System.out.println("Матрица после перестановки:");
        sortedMatrix.print();
    }
}