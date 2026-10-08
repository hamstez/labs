package lab2;
public class Matrix {
    private double[] values;
    private int[] rowIndices;
    private int[] colPointers;
    private int numRows;
    private int numCols;

    public Matrix(double[] values, int[] rowIndices, int[] colPointers, int numRows, int numCols) {
        this.values = values;
        this.rowIndices = rowIndices;
        this.colPointers = colPointers;
        this.numRows = numRows;
        this.numCols = numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double[][] toDense() {
        double[][] dense = new double[numRows][numCols];
        for (int col = 0; col < numCols; col++) {
            for (int i = colPointers[col]; i < colPointers[col + 1]; i++) {
                dense[rowIndices[i]][col] = values[i];
            }
        }
        return dense;
    }

    public Matrix reorderRows(int[] newOrder) {
        int[] oldToNew = new int[numRows];
        for (int newRow = 0; newRow < numRows; newRow++) {
            oldToNew[newOrder[newRow]] = newRow;
        }

        int[] newRowIndices = new int[rowIndices.length];
        for (int i = 0; i < rowIndices.length; i++) {
            newRowIndices[i] = oldToNew[rowIndices[i]];
        }

        return new Matrix(values.clone(), newRowIndices, colPointers.clone(), numRows, numCols);
    }
}