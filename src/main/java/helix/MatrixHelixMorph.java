package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
        if(inMatrix == null) {return  null;}
        if(inMatrix.length == 0){return inMatrix;}
        int[][] resultArr = convertMatrixToSpiral(inMatrix,inMatrix.length,inMatrix[0].length);
        return resultArr;
    }

    private static int[] convert2Dto1D(int y[][], int m, int n)
    {
        int index = 0;
        int x[] = new int[m * n];

        // Store value 2D Matrix To 1D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[index] = y[i][j];
                index++;
            }
        }
        return x;
    }
    static void ToSpiral(int m, int n,
                         int Arr1d[], int a[][])
    {
        // For Array pointer
        int index = 0;

        // k - starting row index
        // m - ending row index
        // l - starting column index
        // n - ending column index
        int k = 0, l = 0;

        while (k < m && l < n) {

            // Print the first row
            // from the remaining rows
            for (int i = l; i < n; ++i) {
                a[k][i] = Arr1d[index];
                index++;
            }

            k++;

            // Print the last column
            // from the remaining columns
            for (int i = k; i < m; ++i) {
                a[i][n - 1] = Arr1d[index];
                index++;
            }
            n--;

            // Print the last row
            // from the remaining rows
            if (k < m) {
                for (int i = n - 1; i >= l; --i) {
                    a[m - 1][i] = Arr1d[index];
                    index++;
                }
                m--;
            }

            // Print the first column
            // from the remaining columns
            if (l < n) {
                for (int i = m - 1; i >= k; --i) {
                    a[i][l] = Arr1d[index];
                    index++;
                }
                l++;
            }
        }
    }
    private static int[][] convertMatrixToSpiral(
            int y[][], int m, int n)
    {

        int a[][] = new int[m][n];
        int x[] = new int[m * n];
        PrintMatrix(y, m, n);
        x = convert2Dto1D(y, m, n);
        ToSpiral(m, n, x, a);
        PrintMatrix(a, m, n);
        return a;
    }

    private static void PrintMatrix(
            int a[][], int m, int n)
    {

        // Print Spiral Matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}