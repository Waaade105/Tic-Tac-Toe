import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int [][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0 ; j < matrix[i].length; j++){
                matrix [i][j] = scanner.nextInt();
            }
        }

        System.out.println("**************");

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0 ; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

//        reverse_it(matrix);

        int [][] reversed = new int[cols][rows];
        reversed [0][0] = matrix [2][0];
        reversed [1][0] = matrix [2][1];
        reversed [2][0] = matrix [2][2];
        reversed [3][0] = matrix [2][3];

        reversed [0][1] = matrix [1][0];
        reversed [1][1] = matrix [1][1];
        reversed [2][1] = matrix [1][2];
        reversed [3][1] = matrix [1][3];

        reversed [0][2] = matrix [2][0];
        reversed [1][2] = matrix [2][1];
        reversed [2][2] = matrix [2][2];
        reversed [3][2] = matrix [2][3];


        for(int i = 0 ; i < reversed.length; i++){
            for (int j=0 ; j < reversed[i].length; j++){
                System.out.print(reversed[i][j] + " ");
            }
            System.out.println();
        }

    reverse_array(matrix);


//
//        for (int i = 0; i < returnedMatrix.length; i++){
//            for (int j = 0 ; j < returnedMatrix[i].length; j++){
//                returnedMatrix [j][matrix.length-1-i] =  matrix [i][j];
//            }
//        }
//
//        System.out.println("**************");


//        for (int i = 0; i < returnedMatrix.length; i++){
//            for (int j = 0 ; j < returnedMatrix[i].length; j++){
////                returnedMatrix [j][matrix.length-1-i] =  matrix [i][j];
//                System.out.println(returnedMatrix[i][j]);
//            }
//        }

    }



    public static void reverse_array(int[][] my_array){


        int my_rows = my_array.length;
        int my_cols = my_array[0].length;
        int array[][]=new int[my_cols][my_rows];
        for(int i = my_rows-1; i >= 0; i--) {   // i od najwiekszego do najmniejszego
            for(int j = my_cols-1; j >= 0; j--) {
                array[my_cols-1-i][my_rows-1-j] = my_array[i][j];
            }
//            for(int j = 0; j < my_cols -1-j; j--) {
//                array[my_rows-1-i][my_cols-1-j] = my_array[i][j];
//            }

        }
        for(int i = 0; i < my_rows; i++) {
            for(int j = 0; j < my_cols; j++) {
                System.out.print(array[i][j]+"  ");
            }
            System.out.println();
        }
//        System.out.println();
    }








}