package Test1;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private Car car;

    public Student(String studentId, String name, int age, Car car) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void introduce(){
        System.out.println( "Tên: " +  name + ", " + age + " tuổi, đi xe " + car.getBrand() + ", biển số xe " + car.getLicensePlate());
    }
}
