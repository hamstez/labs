package lab2;
public class Sorter{
    public static double[] computeRowSums(Matrix matrix){
        double[] sums = new double[matrix.getNumRows()];
        double[] values = matrix.getValues();
        int[] rowIndices = matrix.getRowIndices();
        for (int i=0; i<values.length; i++){
            sums[rowIndices[i]] += values[i];
        }
        return sums;
    }

    public static int[] sortRowsBySum(double[] sums){
        int n = sums.length;
        int[] indices = new int[n];
        for (int i=0; i<n; i++){
            indices[i] = i;
        }
        for (int i = 0; i < n - 1; i++){
            int minPos = i;
            for (int j = i + 1; j < n; j++){
                if (sums[indices[j]] < sums[indices[minPos]]){
                    minPos = j;
                }
            }
            if (minPos != i){
                int temp = indices[i];
                indices[i] = indices[minPos];
                indices[minPos] = temp;
            }
        }
        return indices;
    }
}