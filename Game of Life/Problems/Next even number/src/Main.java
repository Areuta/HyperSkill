import java.util.function.LongUnaryOperator;

class Operator {

    public static LongUnaryOperator unaryOperator = (x) -> x % 2 == 0 ? x + 2 : x + 1;


    /*public static void main(String[] args) {
        System.out.println(unaryOperator.applyAsLong(2));
        System.out.println(unaryOperator.applyAsLong(317));
    }*/
}