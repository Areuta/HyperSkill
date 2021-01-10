class Predicate {

    @FunctionalInterface
    public interface TernaryIntPredicate {
        public boolean test(Integer integer1, Integer integer2, Integer integer3);
    }
    public interface New1 extends TernaryIntPredicate {

    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = new TernaryIntPredicate() {
        @Override
        public boolean test(Integer i1, Integer i2, Integer i3) {
            return i1.intValue() != i2.intValue() && i1.intValue() != i3.intValue() && i2.intValue() != i3.intValue();
        }
    };

    Runnable initFrame = new Runnable() {
        @Override
        public void run() {
            System.out.println("dsf");
        }
    };

    public static void main(String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(1, 3, 3));
    }

}