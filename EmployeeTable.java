import java.util.HashMap;
public class EmployeeTable {
    HashMap<Integer, Employee> data = new HashMap<>();

    public void add(int ID, Employee employee) {
        data.put(ID, employee);
    }
    public Employee get(int ID) {
        return data.get(ID);
    }
    public void remove(int ID) {
        data.remove(ID);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("StudentData\n");
        for (int key : data.keySet()){
            s.append("Key: " + key + ", Value: " + data.get(key) + '\n');
        }
        return s.toString();
    }
}
class Employee{

    private String name;
    private String job;
    private double salary;

    public Employee(String name, String job, double salary){
        this.name = name;
        this.job = job;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getJob(){
        return job;
    }
    public void setJob(String job){
        this.job = job;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Работник " + getName() + ", " + getJob() + ", зарплата " + getSalary();
    }
}