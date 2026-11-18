import model.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {
    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<Product> cart = new ArrayList<>();
    static Product Product1 = new Product("P01", "Áo thun", 150000, 20);
    static Product Product2 = new Product("P02", "Bình nước", 50000, 10);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("============HIT SHOP============");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xoá mặt hàng");
            System.out.println("3. Xem giỏ");
            System.out.println("4. Xem tổng tiền");
            System.out.println("5. Kiểm tra sản phẩm có đắt không");
            System.out.println("0. Thoát");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addOrder();
                case 2 -> removeProduct();
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 5 -> checkItem();
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    static void printItems() {
        System.out.println("============Giỏ hàng============");
        if (cart.isEmpty()){
            System.out.println("Giỏ hàng đang trống.");
        }else {
            System.out.println(currentCustomer);
            for (int i = 0; i < cart.size(); i++) {
                System.out.printf("%d. %s | %s | SL = %d | Thành tiền: %.1f%n", i + 1, cart.get(i).getId(), cart.get(i).getName(), cart.get(i).getStock(), cart.get(i).getPrice() * cart.get(i).getStock());
            }
        }
    }

    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getPrice() *  cart.get(i).getStock();
        }
        return total;
    }

    static void addOrder() {
        System.out.println("=== Chọn loại sản phẩm ===");
        System.out.println("1. Product - Sản phẩm thông thường");
        System.out.println("2. Book - Sách");
        System.out.println("3. Cake - Bánh");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice > 3 || choice < 1) {
            System.out.println("Lựa chọn không hợp lệ!");
        }
        if (choice == 1) {
            System.out.println("Sản phẩm");
            System.out.println(Product1);
            System.out.println(Product2);
        }
        System.out.print("Nhập mã sản phẩm: ");
        String idItem = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String nameItem = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double priceItem = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        int stockItem = Integer.parseInt(sc.nextLine());

        if (stockItem <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }
        if (priceItem <= 0){
            System.out.printf("Giá phải lơn hơn 0");
            return;
        }
        Product product;

        switch (choice) {
            case 1:
                if (!idItem.equals("P01") && !idItem.equals("P02")) {
                    System.out.println("Không tìm thấy sản phẩm!");
                }else {
                    if (idItem.equals("P01")) {
                        cart.add(Product1);
                    } else {
                        cart.add(Product2);
                    }
                }
                break;
            case 2:
                System.out.print("Nhập tên tác giả: ");
                String authorItem = sc.nextLine();
                product = new Book(idItem,nameItem,priceItem,stockItem,authorItem);
                cart.add(product);
                break;
            case 3:
                System.out.print("Nhập thương hiệu: ");
                String brandItem = sc.nextLine();
                product = new Cake(idItem,nameItem,priceItem,stockItem,brandItem);
                cart.add(product);
                break;
        }
    }

    static void removeProduct(){
        printItems();
        System.out.print("Nhập thứ tự muốn xoá: ");
        int displayNumber = Integer.parseInt(sc.nextLine());
        if (displayNumber < 0 || displayNumber > cart.size() + 1){
            System.out.println("Không tìm thấy mặt hàng.");
        }else {
            cart.remove(displayNumber - 1);
        }
    }

    static void checkItem(){
        System.out.print("Nhập id sản phẩm: ");
        String idCheck = sc.nextLine();
        boolean found = false;
        for(Product i : cart){
            if(i.getId().equalsIgnoreCase(idCheck)){
                found = true;
                String status = i.isExpensive() ? "Đắt" : "Không đắt";
                System.out.printf("%s | %.2f | %s\n", i.getName(), i.getPrice(), status);
            }
        }
        if (!found){
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
}
