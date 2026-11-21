package model;

public class MoMoPaymentService implements PaymentService{
    @Override
    public void pay(String orderId) {
        System.out.printf("Đơn hàng %s của bạn đã được thanh toán thành công qua MoMo\n",orderId);
    }
}
