class Clock {

    int hours = 12;
    int minutes = 0;

    @Override
    public String toString() {
        return "Clock{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.hours = 12;
        clock.minutes = 0;
        System.out.println(clock.toString());
        clock.next();
        System.out.println(clock.toString());
        clock.next();
        System.out.println(clock.toString());
        System.out.println("^^^^");
        for (int i=0; i < 56; i++){
            clock.next();
        }
        System.out.println(clock.toString());
        clock.next();
        System.out.println("^^^^");
        System.out.println(clock.toString());
        System.out.println("^^^^");
        System.out.println(clock.toString());
        System.out.println("^^^^");
        System.out.println(clock.toString());
        System.out.println("^^^^");
        System.out.println(clock.toString());
        System.out.println("^^^^");


    }

    public void next (){
        if (minutes < 59){
            minutes++;
        }else{
            minutes = 0;
        }
        if (hours < 12){
            hours++;
        }else{
            hours = 1;
        }
    }
}