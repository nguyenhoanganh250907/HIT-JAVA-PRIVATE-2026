import model.*;
import java.util.Scanner;

public class HitShop {
    static Scanner sc = new Scanner(System.in);
    static ProductService productService = new ProductServiceImpl();
    static OrderServiceImpl orderService = new OrderServiceImpl();
    static int ID = 1;
    static String addidOrder(){
        return String.format("OD%02d", ID++);
    }
    static String idOrder = addidOrder();
    static Customer customer;

    public static void main(String[] args) {
        System.out.print("Nhập ID khách hàng: ");
        String customerId = sc.nextLine();
        System.out.print("Nhập tên khách hàng: ");
        String customerName = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();
        customer = new Customer(customerId, customerName, phone);
        int choice;
        do {
            System.out.println("============HIT SHOP============");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Xem danh sách đơn hàng");
            System.out.println("3. Sửa đơn hàng theo ID");
            System.out.println("4. Xóa đơn hàng theo ID");
            System.out.println("5. Kiểm tra sản phẩm có đắt không");
            System.out.println("6. Thanh toán đơn hàng");
            System.out.println("0. Thoát");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addOrder();
                case 2 -> orderService.printOrders();
                case 3 -> {
                    if (orderService.getOrder().isEmpty()) {
                        System.out.println("Giỏ hàng đang trống.");
                        break;
                    }
                    orderService.printOrders();
                    System.out.print("Nhập id đơn hàng cần sửa: ");
                    String idFix = sc.nextLine();
                    boolean check = false;
                    for (Order i : orderService.getOrder()){
                        if (i.getId().equalsIgnoreCase(idFix)) {
                            check = true;
                            orderService.updateOrder(idFix);
                            break;
                        }
                    }
                    if (!check) System.out.println("Không tìm thấy id!");
                }
                case 4 -> {
                    if (orderService.getOrder().isEmpty()) {
                        System.out.println("Giỏ hàng đang trống");
                        break;
                    }
                    orderService.printOrders();

                    System.out.print("Nhập id đơn hàng cần xoá: ");
                    String idDele = sc.nextLine();
                    boolean check = false;
                    for (Order i : orderService.getOrder()){
                        if (i.getId().equalsIgnoreCase(idDele)) {
                            check = true;
                            orderService.deleteOrder(idDele);
                            break;
                        }
                    }
                    if (!check) System.out.println("Không tìm thấy id!");
                }
                    case 5 -> checkOrder();
                    case 6 -> {
                        System.out.print("Nhập Id đơn hàng cần thanh toán: ");
                        String payId = sc.nextLine();
                        boolean check = false;
                        for (Order i : orderService.getOrder()){
                            if (i.getId().equalsIgnoreCase(payId)) {
                                check = true;
                                orderPayment(payId);
                                break;
                            }
                        }
                        if (!check) System.out.println("Không tìm thấy id!");
                    }
                    case 0 -> System.out.println("Kết thúc.");
                    default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
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
            return;
        }
        System.out.print("Nhập mã sản phẩm: ");
        String idItem = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String nameItem = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double priceItem = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng tồn kho: ");
        int stockItem = Integer.parseInt(sc.nextLine());

        if (stockItem <= 0) {
            System.out.println("Số lượng phải lớn hơn 0.");
            return;
        }
        if (priceItem <= 0){
            System.out.println("Giá phải lơn hơn 0");
            return;
        }
        Product product;
        Order order;
        System.out.print("Nhập số lượng mua: ");
        int quantityItem = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                product = new GeneralProduct(idItem, nameItem, priceItem, stockItem);
                productService.addProduct(product);
                order = new Order(idOrder,customer,product,quantityItem);
                orderService.addOrder(order);
                idOrder = addidOrder();
                break;
            case 2:
                System.out.print("Nhập tên tác giả: ");
                String authorItem = sc.nextLine();
                product = new Book(idItem, nameItem, priceItem, stockItem,authorItem);
                productService.addProduct(product);
                order = new Order(idOrder,customer,product,quantityItem);
                orderService.addOrder(order);
                idOrder = addidOrder();
                break;
            case 3:
                System.out.print("Nhập thương hiệu: ");
                String brandItem = sc.nextLine();
                product = new Cake(idItem, nameItem, priceItem, stockItem,brandItem);
                productService.addProduct(product);
                order = new Order(idOrder,customer,product,quantityItem);
                orderService.addOrder(order);
                idOrder = addidOrder();
                break;
        }
    }

    static void checkOrder() {
        System.out.print("Nhập Id sản phẩm cần kiểm tra: ");
        String idCheck = sc.nextLine();
        Product product = productService.findById(idCheck);
        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm!");
            return;
        }
        String status = product.isExpensive() ? "Đắt" : "Không đắt";
        System.out.printf("ID sản phẩm: %s | %s | %.2f | %s%n",product.getId(),product.getName(),product.getPrice(),status);
    }

    static void orderPayment(String idPayment){
        System.out.println("Chọn hình thức thanh toán!");
        System.out.println("1. Thanh toán qua MoMo");
        System.out.println("2. Thanh toán qua Ngân Hàng");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice != 1 && choice != 2){
            System.out.println("Lựa chọn không hợp lệ!");
        }else if (choice == 1){
            PaymentService paymentService = new MoMoPaymentService();
            paymentService.pay(idPayment);
        }else {
            PaymentService paymentService = new BankPaymentService();
            paymentService.pay(idPayment);
        }
    }
}