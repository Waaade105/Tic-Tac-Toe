package tictactoe;

import java.util.Scanner;

public class Main {
    /*
    After printing the field, you need to find the state in which the game is at the moment. Possible states:
    ' _ ' represents empty cell
    "Game not finished" - when no side has a three in a row but the field has empty cells;
    "Draw" - when no side has a three in a row and the field has no empty cells;
    "X wins" - when the field has three X in a row;
    "O wins" - when the field has three O in a row;
    "Impossible" - when the field has three X in a row as well as three O in a row. Or the field has
    a lot more X's that O's or vice versa (if the difference is 2 or more, should be 1 or 0).
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



















