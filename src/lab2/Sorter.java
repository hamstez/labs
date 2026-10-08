package lab2;
import java.util.Arrays;

public class Sorter {
    public static double[] computeRowSums(Matrix matrix) {
        double[][] dense = matrix.toDense();
        double[] sums = new double[matrix.getNumRows()];
        for (int row = 0; row < matrix.getNumRows(); row++) {
            double sum = 0;
            for (int col = 0; col < matrix.getNumCols(); col++) {
                sum += dense[row][col];
            }
            sums[row] = sum;
        }
        return sums;
    }

    public static int[] sortRowsBySum(double[] sums) {
        Integer[] indices = new Integer[sums.length];
        for (int i = 0; i < sums.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Double.compare(sums[a], sums[b]));

        int[] result = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[i] = indices[i];
        }
        return result;
    }
}