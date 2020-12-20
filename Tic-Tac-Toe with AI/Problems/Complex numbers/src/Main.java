class Complex {

    double real;
    double image;

    public void add(Complex complex) {
        this.real += complex.real;
        this.image += complex.image;
    }

    public void subtract(Complex complex) {
        this.real -= complex.real;
        this.image -= complex.image;
    }
}