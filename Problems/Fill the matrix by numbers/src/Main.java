import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNo = scanner.nextInt();
        if(inputNo > 100){
            System.out.println("too large number!");
        }else{

            int matrix [][] = new int[inputNo][inputNo];
            for ( int i=0 ; i < matrix.length; i++){
                for(int j=0 ; j < matrix[i].length; j++){


                    matrix [i][j] = Math.abs(i-j);
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println( );
            }



        }
    }
}