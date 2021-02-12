import java.util.*;
import java.util.stream.Collectors;


class EmployeesCounter {

    /**
     * Calculates the number of employees with salary >= threshold (only for 111- departments)
     *
     * @param departments are list of departments
     * @param threshold   is lower edge of salary
     * @return the number of employees
     */
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments.stream()
                .filter(department -> department.code.startsWith("111-"))
                .map(department -> department.employees) //Department::getEmployees
                .flatMap(employees -> employees.stream())//Collection::stream
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }

    // Don't change the code below
    static class Employee {
        private final String name;
        private final Long salary;

        Employee(String name, Long salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public Long getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class Department {
        private final String name;
        private final String code;
        private final List<Employee> employees;

        Department(String name, String code, List<Employee> employees) {
            this.name = name;
            this.code = code;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    ", employees=" + employees +
                    '}';
        }
    }

/*    public static void main(String[] args) {
        Employee employee1 = new Employee("William", 20000L);
        Employee employee2 = new Employee("Sophia", 10000L);
        Employee employee3 = new Employee("John", 50000L);

        List<Employee> employees1 = new ArrayList<>(Arrays.asList(new Employee[]{employee1, employee2}));
        List<Employee> employees2 = new ArrayList<>(Arrays.asList(new Employee[]{employee3}));

        Department department1 = new Department("dep1", "111-1", employees1);
        Department department2 = new Department("dep2", "222-1", employees2);

        List<Department> departments = new ArrayList<>();
        departments.add(department1);
        departments.add(department2);
        System.out.println(calcNumberOfEmployees(departments, 20000L));
    }*/
}