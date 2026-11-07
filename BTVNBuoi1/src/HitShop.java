import model.CartItem;
import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HitShop {
    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();
    static Product Product1 = new Product("P01", "Áo thun", 150000, 20);
    static Product Product2 = new Product("P02", "Bình nước", 50000, 10);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("============HIT SHOP============");
            System.out.println("1. Thêm mặt hàng");
            System.out.println("2. Xoá mặt hàng");
            System.out.println("3. Xem giỏ");
            System.out.println("4. Xem tổng tiền");
            System.out.println("0. Thoát");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addProduct(sc);
                case 2 -> removeProduct(sc);
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    static void addItem(Product product, int quantity) {
        CartItem cartItem = new CartItem(product, quantity);
        cart.add(cartItem);
    }

    static void removeItem(int index) {
        cart.remove(index);
    }


    static void printItems() {
        System.out.println("============Giỏ hàng============");
        if (cart.isEmpty()){
            System.out.println("Giỏ hàng đang trống.");
        }else {
            System.out.println(currentCustomer);
            for (int i = 0; i < cart.size(); i++) {
                System.out.printf("%d. %s | %s | SL = %d | Thành tiền: %.1f%n", i + 1, cart.get(i).getProduct().getId(), cart.get(i).getProduct().getName(), cart.get(i).getQuantity(), cart.get(i).getTotal());
            }
        }
    }

    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getTotal();
        }
        return total;
    }

    static void addProduct(Scanner sc) {
        System.out.println("Sản phẩm");
        System.out.println(Product1);
        System.out.println(Product2);

        System.out.print("Nhập mã sản phẩm: ");
        String idItem = sc.nextLine();
        System.out.print("Nhập số lượng: ");
        int quantityItem = Integer.parseInt(sc.nextLine());

        if (!idItem.equals("P01") && !idItem.equals("P02")) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else if (quantityItem <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
        } else {
            if (idItem.equals("P01")) {
                addItem(Product1, quantityItem);
            } else {
                addItem(Product2, quantityItem);
            }
        }
    }

    static void removeProduct(Scanner sc){
        printItems();
        System.out.print("Nhập thứ tự muốn xoá: ");
        int displayNumber = Integer.parseInt(sc.nextLine());
        if (displayNumber < 0 || displayNumber > cart.size() + 1){
            System.out.println("Không tìm thấy mặt hàng.");
        }else {
            removeItem(displayNumber - 1);
        }
    }
}
