import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        int[][] matrix = new int[in][in];
        int m = in;
        int n = in;

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println("");
//        }

        int value = 1;
        int k = 0;
        int l=0;
        while (k < m && l < n) {
            for (int i = l ; i < n ; ++i) {
                matrix[k][i] = value++;
            }
            k++;

            for (int i = k; i < m; ++i) {
                matrix[i][n - 1] = value++;
            }
            n--;

            if (k < m) {
                for (int i = n - 1; i >= l; --i) {
                    matrix[m - 1][i] = value++;
                }
                m--;
            }
            if (l < n) {
                for (int i = m - 1; i >= k; --i) {
                    matrix[i][l] = value++;
                }
                l++;
            }
        }
        for (int i = 0; i < in; i++) {
            for (int j = 0; j < in; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }




    }




}