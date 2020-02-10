class Complex {

    double real;
    double image;

     // complex number = a +b

//        public Complex(double real, double image){
//            this.real = real;
//            this.image = image;
//        }


//        public  void add(double real, double imaginary){
//            this.real += real;
//            this.image += imaginary;
//
//        }
        public void add(Complex complexNumber){
            this.real += complexNumber.real;
            this.image += complexNumber.image;

        }
//        public  void subtract(double real, double imaginary){
//            this.real -= real;
//            this.image -= imaginary;
//
//        }
        public void subtract(Complex complexNumber){
            this.real -= complexNumber.real;
            this.image -= complexNumber.image;

        }

}