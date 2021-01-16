import java.util.function.UnaryOperator;

class PrefixSuffixOperator {

    public static final String PREFIX = "__pref__";
    public static final String SUFFIX = "__suff__";

    public static UnaryOperator<String> operator = s -> PREFIX.concat(s.trim()).concat(SUFFIX);


    public static void main(String[] args) {
//        Long val; val.doubleValue();
    }
}