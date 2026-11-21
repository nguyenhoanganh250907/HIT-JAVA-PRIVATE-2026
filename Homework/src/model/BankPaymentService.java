package model;

public class BankPaymentService implements PaymentService{
    @Override
    public void pay(String orderId) {
        System.out.printf("Đơn hàng %s của bạn đã được thanh toán thành công qua HITBank\n",orderId);
    }
}
