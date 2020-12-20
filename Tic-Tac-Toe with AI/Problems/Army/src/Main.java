class Army {

    public static void createArmy() {
 /*       Unit unit1 = new Unit("1");
        Unit unit2 = new Unit("2");
        Unit unit3 = new Unit("3");
        Unit unit4 = new Unit("4");
        Unit unit5 = new Unit("5");
        Knight knight1 = new Knight("1");
        Knight knight2 = new Knight("2");
        Knight knight3 = new Knight("3");
        General general = new General("1");
        Doctor doctor = new Doctor("1");*/

        Unit.countUnit = 5;
        Knight.countKnight = 3;
        General.countGeneral = 1;
        Doctor.countDoctor = 1;

    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}
