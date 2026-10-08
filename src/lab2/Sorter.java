package lab2;
import java.util.Arrays;

public class Sorter {
    public static double[] computeRowSums(Matrix matrix) {
        double[] sums = new double[matrix.getNumRows()];
        double[] values = matrix.getValues();
        int[] rowIndices = matrix.getRowIndices();
        for (int i = 0; i < values.length; i++) {
            sums[rowIndices[i]] += values[i];
        }
        return sums;
    }

    public static int[] sortRowsBySum(double[] sums) {
        Integer[] indices = new Integer[sums.length];
        for (int i = 0; i < sums.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Double.compare(sums[a], sums[b]));
        int[] res = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            res[i] = indices[i];
        }
        return res;
    }
}