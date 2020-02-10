import java.util.Scanner;

class Main {
    /*
    n = 3;
    m = 4;
    k = 2;

    0 1 0 1
    1 0 0 1
    1 1 1 1

    3
    4
    0 1 0 1 1 0 0 1 1 1 1 1
    2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // rows
        int m = scanner.nextInt(); // seats
        // initializing matrix
        int [][] matrix = new int [n][m];

        for (int i=0 ; i < n ; i++){
            for (int j=0 ; j < m ; j++){
                matrix[i][j] = scanner.nextInt();
//                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.nextLine();
        int k = scanner.nextInt(); // quantity of seats
        if ( k > m){
            System.out.println("impossible. You cannot select more than seats in a row.");
        }

        int counter = 1;
        int counterK = 0;
        for (int i=0 ; i < n ; i++){
            if(k == 1){
                for (int j=0 ; j < m; j++){
                    if (matrix[i][j] == 0){
                        counterK++;
                    }
                }
            }else{
                for (int j=0 ; j < m-1 ; j++){
//                    check to the moment matrix [i][k] because k can be much bigger than 1 or 2
                    while (j == k) {
                        if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j] == 0) {
                            counter++;
                            //                    System.out.println("counter = " + counter);
                        }
                    }
                }
            }


        }
        if( k==1){
            System.out.println(counterK);
        }else {
            System.out.println(counter);
        }

    }
}