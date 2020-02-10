import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long val1 = scanner.nextLong();
        char operation = scanner.next().charAt(0);
        long val2 = scanner.nextLong();


//        String firstValue = scanner.nextLine();
//        long val1 = Long.parseLong(firstValue);
//        String secondValue = scanner.nextLine();
//        long val2 = Long.parseLong(secondValue);


//        long val1 = scanner.nextLong();
        //        double val1 = scanner.nextDouble();
//        scanner.nextLine();
        //        double val2 = scanner.nextDouble();
//        long val2 = scanner.nextLong();
//        scanner.nextLine();
//        char operation = scanner.next().charAt(0);
        long result = 0;  //  double result;    variable not initialized

        switch (operation){
            case '+':
                result = val1 + val2;
                System.out.println(result);
                break;
            case '-':
                result = val1 - val2;
                System.out.println(result);
                break;
            case '*':
                result = val1 * val2;
                System.out.println(result);
                break;
            case '/':
                if (val2 == 0){
                    System.out.println("Division by 0!");
                    break;
                }else {
                    result = val1 / val2;
                    System.out.println(result);
                    break;
                }

            default:
                System.out.println("Unknown operator");
                break;
        }
//        System.out.println(result);

    }
}