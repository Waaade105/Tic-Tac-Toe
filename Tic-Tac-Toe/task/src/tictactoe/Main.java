package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

     /*
     full game to play with a friend. First one of you moves as X, and then the other one moves as O.
     The game starts with empty cells and ends when someone wins or there is a draw.
     */
    public static Scanner scanner = new Scanner(System.in);


    public static String[] reverse(String [] words) {
        String[] reverseOrder = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reverseOrder[i] = words[i];
        }
        return reverseOrder;

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

    public static String [][] fillArr (char [] charArray){

        String [][] matrix = new String [charArray.length/3][charArray.length/3];
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Character.toString(charArray[counter]);
                counter++;
            }
        }
        return matrix;
    }
    public static void printArr (String [][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkHorizontal (String [][] matrix) {

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
                } else if (matrix[i][0].equals("O")) {
//                        System.out.println("O wins");
                    mesX = "O wins";
                }
//                  if count = 2 - > there are two rows with win -> it is  impossible
                if (countX == 2) {
//                    mesX = "Impossible";
                }
            }
        }

        if (mesX == "X wins" || mesX == "O wins") {
            System.out.println(mesX);
            return true;
        } else if (mesX == "Impossible HOR") {
//            System.out.println(mesX);
            return true;
            // return true because the result is now known and it does not have to process any more
        }
        return false;
    }


    public static boolean checkVertical (String [][] matrix){
        int countY = 0;
        int colSize = 3;
        String mesY = "";
        for (int j = 0; j < colSize; j++) {
            if (matrix[0][j].equals(matrix[1][j]) && matrix[1][j].equals(matrix[2][j])) {
                countY++;
//                  X or O
//                  it is suffice to check only 1 cell
                if (matrix[0][j].equals("X")) {
                    mesY = "X wins";
                } else if (matrix[0][j].equals("O")) {
                    mesY = "O wins";
                }
//                  if count = 2 - > there are two columns with win -> it is  impossible
                if (countY == 2) {
//                    mesY = "Impossible";
                }
            }
        }
        if (mesY == "X wins" || mesY == "O wins") {
            System.out.println(mesY);
            return true;
        }else if(mesY == "Impossible VER") {
//            System.out.println(mesY);
            return true;
            // return true because the result is now known and it does not have to process any more
        }
        return false;
    }


    public static boolean checkDiagonals (String [][] matrix){
        int countDiag1 = 0;
        int countDiag2 = 0;

        //from left bottom corner to right top corner
        if (matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2])) {
            countDiag1++;
            //          it is suffice to check only 1 cell
            if (matrix[0][0].equals("X")) {
                System.out.println("X wins");
                return true;
            } else if (matrix[0][0].equals("O")) {
                System.out.println("O wins");
                return true;
            }
        }
//        from left top corner to right bottom corner
        if (matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0])) {
            countDiag2++;
//          it is suffice to check only 1 cell
            if (matrix[0][2].equals("X")) {
                System.out.println("X wins");
                return true;
            } else if (matrix[0][2].equals("O")) {
                System.out.println("O wins");
                return true;
            }
        }
        return false;
    }

    public static void enterXIntoMatrix (String [][] matrix){
        //two coordinates
        int coord1;
        int coord2;

        System.out.println("Enter the coordinates:");
        boolean quit = false;
        while(!quit) {
            try {
                coord1 = scanner.nextInt();
                coord2 = scanner.nextInt();
                // cast to Integer obj due to comparing whether the inputted value is int type
                Integer coord1Obj = coord1;
                Integer coord2Obj = coord2;
                Integer isInteger = 0;
                Class i1 = coord1Obj.getClass();
                Class i2 = coord2Obj.getClass();
                Class isIntegerClass = isInteger.getClass();
                String message = " ";
//        CONDITIONS: occupied, outOfBounds, not Int,
                // if Out of Bounds
                if ((coord1 < 1 || coord1 > 3) || (coord2 < 1 || coord2 > 3)) {
                    message = ("Coordinates should be from 1 to 3!");
                }
                // if not Int
                if (i1 != isIntegerClass || i2 != isIntegerClass) {
                    message = ("You should enter numbers!");
                }
                // make move
                // 1st row
                if (coord1 == 1 && coord2 == 1) {
                    if (matrix[2][0].equals(" ") || matrix[2][0].equals("_")) {
                        matrix[2][0] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 2 && coord2 == 1) {
                    if (matrix[2][1].equals(" ") || matrix[2][1].equals("_")) {
                        matrix[2][1] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 3 && coord2 == 1) {
                    if (matrix[2][2].equals(" ") || matrix[2][2].equals("_")) {
                        matrix[2][2] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                    // 2nd row
                } else if (coord1 == 1 && coord2 == 2) {
                    if (matrix[1][0].equals(" ") || matrix[1][0].equals("_")) {
                        matrix[1][0] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 2 && coord2 == 2) {
                    if (matrix[1][1].equals(" ") || matrix[1][1].equals("_")) {
                        matrix[1][1] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 3 && coord2 == 2) {
                    if (matrix[1][2].equals(" ") || matrix[1][2].equals("_")) {
                        matrix[1][2] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                    // 3rd row
                } else if (coord1 == 1 && coord2 == 3) {
                    if (matrix[0][0].equals(" ") || matrix[0][0].equals("_")) {
                        matrix[0][0] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 2 && coord2 == 3) {
                    if (matrix[0][1].equals(" ") || matrix[0][1].equals("_")) {
                        matrix[0][1] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 3 && coord2 == 3) {
                    if (matrix[0][2].equals(" ") || matrix[0][2].equals("_")) {
                        matrix[0][2] = "X";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                }
                System.out.println(message);

                if (message == "Coordinates should be from 1 to 3!" || message == "You should enter numbers!"
                        || message == "This cell is occupied! Choose another one!") {
                    System.out.println("Enter the coordinates:");
                } else {
                    printArr(matrix);
                    quit = true;
                }

            }catch (InputMismatchException e){
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }

    public static void enterOIntoMatrix (String [][] matrix){
        //two coordinates
        int coord1;
        int coord2;

        System.out.println("Enter the coordinates:");
        boolean quit = false;
        while(!quit) {
            try {
                coord1 = scanner.nextInt();
                coord2 = scanner.nextInt();
                // cast to Integer obj due to comparing whether the inputted value is int type
                Integer coord1Obj = coord1;
                Integer coord2Obj = coord2;
                Integer isInteger = 0;
                Class i1 = coord1Obj.getClass();
                Class i2 = coord2Obj.getClass();
                Class isIntegerClass = isInteger.getClass();
                String message = " ";
//        CONDITIONS: occupied, outOfBounds, not Int,
                // if Out of Bounds
                if ((coord1 < 1 || coord1 > 3) || (coord2 < 1 || coord2 > 3)) {
                    message = ("Coordinates should be from 1 to 3!");
                }
                // if not Int
                if (i1 != isIntegerClass || i2 != isIntegerClass) {
                    message = ("You should enter numbers!");
                }
                // make move
                // 1st row
                if (coord1 == 1 && coord2 == 1) {
                    if (matrix[2][0].equals(" ") || matrix[2][0].equals("_")) {
                        matrix[2][0] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 2 && coord2 == 1) {
                    if (matrix[2][1].equals(" ") || matrix[2][1].equals("_")) {
                        matrix[2][1] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 3 && coord2 == 1) {
                    if (matrix[2][2].equals(" ") || matrix[2][2].equals("_")) {
                        matrix[2][2] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                    // 2nd row
                } else if (coord1 == 1 && coord2 == 2) {
                    if (matrix[1][0].equals(" ") || matrix[1][0].equals("_")) {
                        matrix[1][0] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 2 && coord2 == 2) {
                    if (matrix[1][1].equals(" ") || matrix[1][1].equals("_")) {
                        matrix[1][1] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 3 && coord2 == 2) {
                    if (matrix[1][2].equals(" ") || matrix[1][2].equals("_")) {
                        matrix[1][2] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                    // 3rd row
                } else if (coord1 == 1 && coord2 == 3) {
                    if (matrix[0][0].equals(" ") || matrix[0][0].equals("_")) {
                        matrix[0][0] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 2 && coord2 == 3) {
                    if (matrix[0][1].equals(" ") || matrix[0][1].equals("_")) {
                        matrix[0][1] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                } else if (coord1 == 3 && coord2 == 3) {
                    if (matrix[0][2].equals(" ") || matrix[0][2].equals("_")) {
                        matrix[0][2] = "O";
                    } else {
                        message = ("This cell is occupied! Choose another one!");
                    }
                }
                System.out.println(message);

                if (message == "Coordinates should be from 1 to 3!" || message == "You should enter numbers!"
                        || message == "This cell is occupied! Choose another one!") {
                    System.out.println("Enter the coordinates:");
                } else {
                    printArr(matrix);
                    quit = true;
                }

            }catch (InputMismatchException e){
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }

    public static boolean checkIfWin(String [][] matrix){

        boolean horizontalWins; // default is false
        boolean verticalWins; // default is false
        boolean diagonalWins; // default is false

        horizontalWins = checkHorizontal(matrix);
        if (horizontalWins == true){
            return true;
        }else {
            verticalWins = checkVertical(matrix);
            if (verticalWins == true){
                return true;
            }else{
                diagonalWins = checkDiagonals(matrix);
                if (diagonalWins == true){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        //start with empty cells
        char [] chArray = {'_', '_', '_', '_', '_', '_', '_', '_', '_'};
        String [][] matrix = fillArr(chArray);
        printArr(matrix);

        boolean whoWon;
        boolean quit = false;
        int counter = 0;
        while (!quit){

            enterXIntoMatrix(matrix);
            counter++;
            whoWon = checkIfWin(matrix);
            if (whoWon){
                quit = true;
                break;
            }
            // Where is no win till the field is full up:
            // there are only 9 fields so when user inputs the last "X" sign (9-th sign) do not input Y -> output DRAW
            if (counter < 9) {
                enterOIntoMatrix(matrix);
                counter++;
            }
            whoWon = checkIfWin(matrix);
            if (whoWon){
                quit = true;
                break;
            }
//            System.out.println("counter is " + counter);
            if (counter == 9){
                System.out.println("Draw");
                quit = true;
                break;
            }
        }
    }
}

