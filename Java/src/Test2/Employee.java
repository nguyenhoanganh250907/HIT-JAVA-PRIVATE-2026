package Test2;

public class Employee {
    private String id;
    private String name;
    private long baseSalary;

    public Employee(String id, String name, long baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(long baseSalary) {
        this.baseSalary = baseSalary;
    }

    public long getMonthlyIncome(){
        return this.baseSalary;
    }
}
