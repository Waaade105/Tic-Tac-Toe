public class Main {

    public static void main(String[] args) {

        int counter = 0;
        for (Secret s: Secret.values()) {
//            String checker = "STAR";
//            String castedSecretVal = (String)s;
//            castedSecretVal = castedSecretVal.startsWith("STAR");

            String c = s.toString();



            if (c.startsWith("STAR")){
                counter++;
            }
        }
        System.out.println(counter);

    }
}

// At least two constants start with STAR
//enum Secret {
//    STAR, CRASH, START, // ...
//}
