public class Main2 {
    public static void main(String[] args) {
        EmployeeTable data = new EmployeeTable();
        data.add(1, new Employee("Антон", "уборщик", 500000));
        data.add(14, new Employee("Владимир", "программист", 54000));
        data.add(15, new Employee("Игорь", "Водитель", 5005000));
        data.add(25, new Employee("Иван", "Тракторист", 25000));
        data.add(27, new Employee("Павел", "Врач", 5046.5));
        System.out.println(data);
        System.out.println(data.get(14));
        data.remove(15);
        System.out.println(data);


    }
}
