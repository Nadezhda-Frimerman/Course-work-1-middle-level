public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Карманова", "Ольга", "Валерьевна", 3, 51200);
        employees[1] = new Employee("Аронова", "Наталья", "Павловна", 1, 32800);
        employees[2] = new Employee("Пиков", "Антон", "Дмитриевич", 5, 37200);
        employees[3] = new Employee("Омутов", "Илья", "Олегович", 2, 43600);
        employees[4] = new Employee("Туманова", "Марина", "Олеговна", 1, 21100);
        employees[5] = new Employee("Петров", "Алексей", "Александрович", 4, 72300);
        employees[6] = new Employee("Сватов", "Александр", "Анатольевич", 3, 54200);
        employees[7] = new Employee("Тунец", "Оксана", "Владимировна", 1, 41200);
        employees[8] = new Employee("Капустин", "Роман", "Иванович", 5, 47300);
        employees[9] = new Employee("Малых", "Вадим", "Петрович", 2, 49100);

        printAllEmployees(employees);
        System.out.printf("Сумма затрат на ЗП в месяц: %.2f.%n", sumSalary(employees));
        System.out.printf("Сотрудник с минимальной зарплатой: %s%n", findMinSalaryEmployee(employees));
        System.out.printf("Сотрудник с максимальной зарплатой: %s%n", findMaxSalaryEmployee(employees));
        System.out.printf("Среднее значение ЗП в месяц: %.2f.%n", findAverageSalary(employees));
        printPersonsList(employees);
        System.out.println("Индексирование зарплаты.");
        indexingSalary(10);
        printAllEmployees(employees);
        int numberOfDepartment=4;
        System.out.println("Информация по отделу "+numberOfDepartment);
        System.out.printf("Сотрудник с минимальной зарплатой в отделе %s:%n%s%n",numberOfDepartment, findMinSalaryDepartment(employees,numberOfDepartment));
        System.out.printf("Сотрудник с максимальной зарплатой в отделе %s:%n%s%n",numberOfDepartment, findMaxSalaryDepartment(employees,numberOfDepartment));
        System.out.printf("Сумма затрат на ЗП в месяц в отделе %s: %.2f рублей.%n", numberOfDepartment, sumSalaryDepartment(employees,numberOfDepartment));
        System.out.printf("Среднее значение ЗП в месяц в отделе %s: %.2f рублей.%n", numberOfDepartment, findAverageSalaryDepartment(employees,numberOfDepartment));
        indexingSalaryDepartment(5,numberOfDepartment);
        printPersonsListDepartment(employees,numberOfDepartment);
        int fixSalary=50000;
        System.out.printf("Сотрудники, зарплата которых меньше %s %n",fixSalary);
        printEmployeesSalaryLess(employees,fixSalary);
        System.out.printf("Сотрудники, зарплата которых больше %s %n",fixSalary);
        printEmployeesSalaryMore(employees,fixSalary);

    }

    public static void printAllEmployees(Employee[] employees) {
        for (int a = 0; a <= employees.length - 1; a++) {
            System.out.println(employees[a]);
        }
    }

    public static double sumSalary(Employee[] employees) {
        double sumSalary = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            sumSalary += employees[i].getSalary();
        }
        return sumSalary;
    }

    public static Employee findMinSalaryEmployee(Employee[] employees) {
        double minSalary = employees[0].getSalary();
        int numberMinSalary = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() != 0 && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                numberMinSalary = i;
            }
        }
        return employees[numberMinSalary];
    }

    public static Employee findMaxSalaryEmployee(Employee[] employees) {
        double maxSalary = employees[0].getSalary();
        int numberMaxSalary = 0;
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                numberMaxSalary = i;
            }
        }
        return employees[numberMaxSalary];
    }

    public static double findAverageSalary(Employee[] employees) {
        return sumSalary(employees) / employees.length;
        }

    public static void printPersonsList(Employee[] employees) {
        System.out.println("Список сотрудников:");
        for (int i = 0; i <= employees.length - 1; i++) {
            System.out.println(employees[i].getFirstName() + " " + employees[i].getMiddleName() + " " + employees[i].getLastname());
        }
    }

    public static void indexingSalary(int index){
        if (index<=0) {
            throw new IllegalArgumentException("Некорректный ввод индекса.");}
        else {
            for (int i = 0; i <= employees.length - 1; i++) {
                double newSalary = (1 + (double) index / 100) * employees[i].getSalary();
                employees[i].setSalary(newSalary);
            }
        }
    }
    public static Employee[] sortDepartment(Employee[] employees,int departmentNumber){
        if (departmentNumber<=0||departmentNumber>5) {
            throw new IllegalArgumentException("Некорректный ввод номера отдела.");}
        else {
            int departmentAmount = 0;
            for (int i = 0; i <= employees.length - 1; i++) {
                if (employees[i].getDepartment() == departmentNumber) {
                    departmentAmount++;
                }
            }
            Employee[] departmentEmployees = new Employee[departmentAmount];
            int d = 0;
            for (int i = 0; i <= employees.length - 1; i++) {
                if (employees[i].getDepartment() == departmentNumber) {
                    departmentEmployees[d] = employees[i];
                    d++;
                }
            }
            return departmentEmployees;
        }
    }
    public static Employee findMinSalaryDepartment(Employee[] employees,int departmentNumber) {
        Employee[] departmentEmployees=sortDepartment(employees,departmentNumber);
        double minSalary = departmentEmployees[0].getSalary();
        int numberMinSalary = 0;
        for (int i = 0; i <= departmentEmployees.length - 1; i++) {
            if (departmentEmployees[i].getSalary() != 0 && departmentEmployees[i].getSalary() < minSalary) {
                minSalary = departmentEmployees[i].getSalary();
                numberMinSalary = i;
            }
        }
        return departmentEmployees[numberMinSalary];
    }
    public static Employee findMaxSalaryDepartment(Employee[] employees,int departmentNumber) {
        Employee[] departmentEmployees=sortDepartment(employees,departmentNumber);
        double maxSalary = departmentEmployees[0].getSalary();
        int numberMaxSalary = 0;
        for (int i = 0; i <= departmentEmployees.length - 1; i++) {
            if (departmentEmployees[i].getSalary() > maxSalary) {
                maxSalary = departmentEmployees[i].getSalary();
                numberMaxSalary = i;
            }
        }
        return departmentEmployees[numberMaxSalary];
    }
    public static double sumSalaryDepartment(Employee[] employees,int departmentNumber) {
        Employee[] departmentEmployees=sortDepartment(employees,departmentNumber);
        double sumSalary = 0;
        for (int i = 0; i <= departmentEmployees.length - 1; i++) {
            sumSalary += departmentEmployees[i].getSalary();
        }
        return sumSalary;
    }
    public static double findAverageSalaryDepartment(Employee[] employees,int departmentNumber) {
        Employee[] departmentEmployees = sortDepartment(employees,departmentNumber);
        return sumSalary(departmentEmployees) / departmentEmployees.length;
        }
    public static void indexingSalaryDepartment(int index,int departmentNumber){
        Employee[] departmentEmployees=sortDepartment(employees,departmentNumber);
        for (int i = 0; i <= departmentEmployees.length - 1; i++){
            double newSalary = (1+ (double) index /100)*departmentEmployees[i].getSalary();
            departmentEmployees[i].setSalary(newSalary);
        }
    }
    public static void printPersonsListDepartment(Employee[] employees,int departmentNumber) {
        System.out.printf("Список сотрудников отдела %s:%n",departmentNumber);
        Employee[] departmentEmployees=sortDepartment(employees,departmentNumber);
        for (int i = 0; i <= departmentEmployees.length - 1; i++) {
            System.out.println(departmentEmployees[i].printPersonWithOutDepartment());
        }
    }
    public static void printEmployeesSalaryLess(Employee[] employees,double salary) {
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() < salary) {
            System.out.println(employees[i].printPersonWithOutDepartment());
            }
        }
    }
    public static void printEmployeesSalaryMore(Employee[] employees,double salary) {
        for (int i = 0; i <= employees.length - 1; i++) {
            if (employees[i].getSalary() > salary) {
                System.out.println(employees[i].printPersonWithOutDepartment());
            }
        }
    }

}



