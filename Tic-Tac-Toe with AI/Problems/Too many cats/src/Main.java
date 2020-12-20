class Cat {

    private static int numberOfCats = 0;
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfCats++;
        if (numberOfCats > 5) {
            System.out.println("You have too many cats");
        }
    }

    public Cat(int age, String name) {
        this.name = name;
        this.age = age;
        numberOfCats++;
        if (numberOfCats > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return numberOfCats;
    }
}