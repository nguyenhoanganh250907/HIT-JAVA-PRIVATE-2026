import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {
    static final List<String> names = new ArrayList<>();
    static final List<Double> prices = new ArrayList<>();
    static final List<Integer> quantities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            printMenu();
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> readAndAddItem(sc);
                case 2 -> readAndRemoveItem(sc);
                case 3 -> printItems();
                case 4 -> printPayment();
                case 5 -> searchItem(sc);
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }while(choice != 0);

    }
    static void printMenu() {
        System.out.println("============HIT SHOP============");
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xoá mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("5. Tìm mặt hàng theo tên");
        System.out.println("0. Thoát");
    }

    static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }

    static void removeItem(int index){
        names.remove(index);
        prices.remove(index);
        quantities.remove(index);
    }

    static void readAndAddItem(Scanner sc){
        System.out.print("Nhap ten hang: ");
        String name = sc.nextLine();
        do {
            if (name.isEmpty()){
                System.out.println("Khong duoc de trong ten hang");
                System.out.println("Nhap lai ten hang");
                name = sc.nextLine();
            }
        }while (name.isEmpty());
        System.out.print("Nhap gia: ");
        double price = Double.parseDouble(sc.nextLine());
        do {
            if (price <= 0){
                System.out.println("Gia phai lon hon 0");
                System.out.println("Nhap lai gia: ");
                price = Double.parseDouble(sc.nextLine());
            }
        }while (price <= 0);
        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());
        do {
            if (quantity <= 0){
                System.out.println("So luong phai lon hon 0 va la so nguyen");
                System.out.println("Nhap lai so luong: ");
                quantity = Integer.parseInt(sc.nextLine());
            }
        }while (quantity <= 0 || quantity % 1 != 0);

        addItem(name,price,quantity);
    }

    static void readAndRemoveItem(Scanner sc){
        System.out.print("Nhap vi tri don hang can xoa: ");
        int displayNumber  = Integer.parseInt(sc.nextLine());
        if (displayNumber > names.size() || displayNumber < 1){
            System.out.println("Khong tim thay mat hang");
        }else{
            removeItem(displayNumber - 1);
        }

        printItems();
    }

    static void printItems(){
        System.out.println("============Giỏ hàng============");
        for (int i = 0;i < names.size();i++){
            System.out.printf("%d %s | %.1f | SL = %d%n",i + 1,names.get(i),prices.get(i),quantities.get(i));
        }
    }

    static double calculateLineTotal(double price, int quantity) {
        return price * quantity;
    }

    static double calculateTotal(){
        double total = 0;
        for (int i = 0;i < names.size();i++){
            total += calculateLineTotal(prices.get(i),quantities.get(i));
        }
        return total;
    }

    static void searchItem(Scanner sc){
        System.out.println("Nhap ten mat hang can tim");
        String itemName = sc.nextLine();
        boolean check = false;
        for (int i = 0;i < names.size();i++){
            if (names.get(i).equalsIgnoreCase(itemName)){
                check = true;
                System.out.printf("%d %s | %.1f | SL = %d%n",i + 1,names.get(i),prices.get(i),quantities.get(i));
            }
        }
        if (!check){
            System.out.println("Khong tim thay mat hang");
        }
    }

    static void printPayment(){
        double VAT = calculateTotal() * 0.1;
        double shipping = 20000;
        if (names.isEmpty()) shipping = 0;
        System.out.println("Tong tien: " + calculateTotal());
        System.out.println("VAT: " + VAT);
        System.out.println("Phi van chuyen: " + shipping);
        System.out.println("Tong thanh toan; " + (calculateTotal() + VAT + shipping));
    }
}
