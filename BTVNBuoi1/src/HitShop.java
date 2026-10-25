import java.util.Scanner;

public class HitShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final double VAT_RATE = 0.1;
        final double SHIPPING_FEE = 2000;

        System.out.print("Nhap ten mat hang: ");
        String name = sc.nextLine();
        System.out.print("Nhap don gia: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(sc.nextLine());

        double Tong = price * quantity;
        double tongThanhToan = Tong + Tong * VAT_RATE + SHIPPING_FEE;

        System.out.println("Tên mặt hàng: " + name);
        System.out.println("Đơn giá: " + price);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Thành tiền: " + Tong);
        System.out.println("Tổng thanh toán: " + tongThanhToan);
    }
}
