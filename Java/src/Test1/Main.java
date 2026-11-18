package Test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static List<Student> sv = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student SV01 = new Student("SV01","Khánh",20,new Car("CAR01","Lamborghini","30A-123456"));
        Student SV02 = new Student("SV02","An",19,new Car("CAR02","Toyota","30B-67890"));
        sv.add(SV01);
        sv.add(SV02);

        int choice;
        do {
            System.out.println("=========Menu=========");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Sửa sinh viên");
            System.out.println("4. Giới thiệu sinh viên tên Khánh");
            System.out.println("5. Tìm sinh viên có ô tô hãng Lamborghini");
            System.out.println("6. Xem danh sách sinh viên");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1 -> addStudent(sc);
                case 2 -> deleteStudent(sc);
                case 3 -> changeStudent(sc);
                case 4 -> findKhanh();
                case 5 -> findLamborghini();
                case 6 -> printStudent();
                case 0 -> System.out.println("Kết thúc");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (choice != 0);
    }
    static void printStudent(){
        System.out.println("=========DanhSach=========");
        for (int i = 0;i < sv.size();i++){
            System.out.printf("%d.",i + 1);
            sv.get(i).introduce();
        }
    }

    static void addStudent(Scanner sc){
        System.out.print("Nhập mã SV: ");
        String studentId = sc.nextLine();
        System.out.print("Nhập tên SV: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập mã ô tô: ");
        String carId = sc.nextLine();
        System.out.print("Nhập hãng xe: ");
        String brand = sc.nextLine();
        System.out.print("Nhập biển số xe: ");
        String licensePlate = sc.nextLine();

        Student SV = new Student(studentId,name,age,new Car(carId,brand,licensePlate));
        sv.add(SV);

        printStudent();
    }

    static void deleteStudent(Scanner sc){
        printStudent();
        System.out.print("Nhập vị trí sinh viên cần xoá: ");
        int index = Integer.parseInt(sc.nextLine());
        sv.remove(index - 1);
        printStudent();
    }

    static void changeStudent(Scanner sc) {
        printStudent();
        System.out.print("Sửa vị trí sinh viên cần sửa: ");
        int index = Integer.parseInt(sc.nextLine());
        System.out.print("Sửa mã SV: ");
        String studentId = sc.nextLine();
        System.out.print("Sửa tên SV: ");
        String name = sc.nextLine();
        System.out.print("Sửa tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Sửa mã ô tô: ");
        String carId = sc.nextLine();
        System.out.print("Sửa hãng xe: ");
        String brand = sc.nextLine();
        System.out.print("Sửa biển số xe: ");
        String licensePlate = sc.nextLine();
        sv.get(index - 1).setStudentId(studentId);
        sv.get(index - 1).setName(name);
        sv.get(index - 1).setAge(age);
        sv.get(index - 1).getCar().setCarld(carId);
        sv.get(index - 1).getCar().setBrand(brand);
        sv.get(index - 1).getCar().setLicensePlate(licensePlate);
        printStudent();
    }

    static void findKhanh(){
        boolean check = false;
        for (Student i : sv){
            if (i.getName().equalsIgnoreCase("Khánh")){
                check = true;
                i.introduce();
            }
        }
        if (!check) System.out.println("Anh Khánh dz");
    }

    static void findLamborghini(){
        boolean check = false;
        for (Student i : sv){
            if (i.getCar().getBrand().equalsIgnoreCase("Lamborghini")){
                check = true;
                i.introduce();
            }
        }
        if (!check) System.out.println("Không có sinh viên nào có ô tô hãng Lamborghini");
    }
}