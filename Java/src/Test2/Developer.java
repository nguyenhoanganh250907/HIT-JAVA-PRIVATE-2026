package Test2;

public class Developer extends Employee{
    private double overtimeHours;

    public Developer(String id, String name, long baseSalary, double overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
}
