package Test3;

import static Test3.BaseMessageSender.notifyUser;

public class Main {
    public static void main(String[] args) {
        notifyUser(new EmailSender("Hoàng"), "Đơn hàng đã được tạo");
        notifyUser(new SmsSender("Việt"), "Đơn hàng đã được tạo");
        notifyUser(new AppSender("Anh"),"Đơn hàng đã được vận chuyển");
    }
}
