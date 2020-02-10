package tictactoe;

import java.util.Scanner;

public class Main {
    /*
    IMPLEMENT HUMAN MOVES

    Suppose the bottom left cell has the coordinates (1, 1) and the top right cell has the coordinates (3, 3) like in this table:

    (1, 3) (2, 3) (3, 3)
    (1, 2) (2, 2) (3, 2)
    (1, 1) (2, 1) (3, 1)

    The program should work in the following way:

    Get the 3x3 field from the input as in the previous stages,
    Output this 3x3 field with cells before the user's move,
    Then ask the user about his next move,
    Then the user should input 2 numbers that represent the cell on which user wants to make his X or O.
    (9 symbols representing the field would be on the first line and these 2 numbers would be on the second line of the user input),
    Then output the table including the user's most recent move.
    Do not delete code that checks for table state; it will be useful in the future.

    Note that in this stage user moves as X, not O. Keep in mind that the first coordinate goes from left to right
    and the second coordinate goes from bottom to top. Also, notice that coordinates start with 1 and can be 1, 2 or 3.

    But what if the user enters incorrect coordinates? The user could enter symbols instead of numbers or enter coordinates
    representing occupied cells. You need to prevent all of that by checking a user's input and catching possible exceptions.

    The program should also check user input. If the user input is unsuitable, the program should ask him to enter coordinates again.

    So, you need to output a field from the first line of the input and then ask the user to enter a move.
    Keep asking until the user enters coordinate that represents an empty cell on the field and after that output
    the field with that move. You should output the field only 2 times - before the move and after a legal move.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        char [] chArray = input.toCharArray();
        String [][] matrix = new String[3][3];
        int colSize = 3;

//        check whether the char array is correct
        for(int i=0 ; i < chArray.length; i++) {
            System.out.print(chArray[i]);
        }
        System.out.println();
        // check how many X and O are in array (the difference between X and O cannot be more than 1
        boolean result = howManyXandO(chArray);

            int counter = 0;
            System.out.println("---------");
            for (int i = 0; i < matrix.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < matrix[i].length; j++) {
//                assigning char value to String value
                    matrix[i][j] = Character.toString(chArray[counter]);
                    counter++;
                    System.out.print(matrix[i][j] + " ");
                }

                System.out.println("|");
            }
            System.out.println("---------");

            if(!result){
                System.out.println("Impossible");
            }else { // if true then check the all code

//            System.out.println("conuter is: " + counter);


//      x position lines: i=0 i=1 i=2
            int countX = 0;
            String mesX = "";
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0].equals(matrix[i][1]) && matrix[i][1].equals(matrix[i][2])) {
                    countX++;
//                  X or O
//                  it is suffice to check only 1 cell
                    if (matrix[i][0].equals("X")) {
//                        System.out.println("X wins");
                        mesX = "X wins";
//                        break;
                    } else if (matrix[i][0].equals("O")) {
//                        System.out.println("O wins");
                        mesX = "O wins";
//                        break;
                    }


//                  if count = 2 - > there are two rows with win -> it is  impossible
                    if (countX == 2) {
                        System.out.println("IMPOSSIBLE");
                        mesX = "Impossible";
                    }
                }
            }
            System.out.println(mesX);


//      y position lines: j=0 j=1 j=2
//            Y tylko raz ? -> edit: działa
            int countY = 0;
            String mesY = "";
            for (int j = 0; j < colSize; j++) {
                if (matrix[0][j].equals(matrix[1][j]) && matrix[1][j].equals(matrix[2][j])) {
                    countY++;
//                  X or O
//                  it is suffice to check only 1 cell
                    if (matrix[0][j].equals("X")) {
                        mesY = "X wins";
//                        System.out.println("X wins");
                    } else if (matrix[0][j].equals("O")) {
                        mesY = "O wins";
//                        System.out.println("O wins");
                    }

//                  if count = 2 - > there are two rows with win -> it is  impossible
                    if (countY == 2) {
//                        System.out.println("IMPOSSIBLE TWO WINNERS !!!!!!!!!!!!!!");

                        mesY = "Impossible"; // dwa razy drukuje dla inputu XO_XO_XOX
                    }
                }
            }
            if (mesY.equals(mesX)){
//                System.out.println(mesX);
            }else {
                System.out.println(mesY);
            }
//        diagonals
//           if X or O won (row or column) then do not execute the code below.
//           Otherwise check whether in diagonal X or O won

            //from left bottom corner to right top corner
            int countDiag1 = 0;
            int countDiag2 = 0;
            if ( countX < 1 && countY < 1 ){
                if (matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2])) {
                    countDiag1++;
                    //          it is suffice to check only 1 cell
                    if (matrix[0][0].equals("X")) {
                        System.out.println("X wins");
                    } else if (matrix[0][0].equals("O")) {
                        System.out.println("O wins");
                    }
                }
    //        from left top corner to right bottom corner
                if (matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0])) {
                    countDiag2++;
    //          it is suffice to check only 1 cell
                    if (matrix[0][2].equals("X")) {
                        System.out.println("X wins");
                    } else if (matrix[0][2].equals("O")) {
                        System.out.println("O wins");
                    }
                }
            }else{
                System.out.println(mesX);
            }

//            no one won -> check DRAW and check GAME NOT FINISHED
            if (countX == 0 && countY == 0 && countDiag1 == 0 && countDiag2 == 0){
//                System.out.println("Game not finished");
//                wins have been already checked so i do not have to check my 2d array - but only my 1d input array
                boolean isFull = isArrayFull(chArray);
                if (isFull){
                    System.out.println("Draw");
                }else{
                    System.out.println("Game not finished");
                }

            }

        }// end of statement concerning wheter is it possible to have an array with to many X or O

    }

    public static boolean howManyXandO (char [] chArray){
        int findX = 0;
        int findO = 0;
        for ( char ch : chArray){
            if ( ch == 'X'){
                findX++;
            }
            if ( ch == 'O'){
                findO++;
            }
        }

        if (findX > findO + 1){
            return false;
        }else if(findO > findX + 1){
            return false;
        }
        return true;
    }

    public static boolean isArrayFull( char []chArray){
        int counter = 0;
        for (char ch : chArray){
            if (ch == 'X' || ch == 'O'){
                counter++;
            }
        }

        if ( counter == 9){
            return true;
        }
        return false;
    }





}



















