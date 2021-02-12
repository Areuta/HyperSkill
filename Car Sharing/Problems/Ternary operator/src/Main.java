import java.util.function.*;

class Operator {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

//        T t = null;
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
        /*if (condition.test(t)) {
            return (Function<T, U>) ifTrue;
        } else {
            return (Function<T, U>) ifFalse;
        }*/

    }

    public static void main(String[] args) {
        /*Predicate<Integer> condition = n -> (n % 2) == 0;
        Function<Integer, String> ifTrue = n -> "Number is even";
        Function<Integer, String> ifFalse = n -> "Number is odd";

        Function<Integer, String> isEven = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(isEven.apply(4));*/


       /* Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = new Operator().ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply("sds"));*/
    }
}
