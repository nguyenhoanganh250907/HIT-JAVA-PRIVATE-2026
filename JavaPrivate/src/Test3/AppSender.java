package Test3;

public class AppSender extends BaseMessageSender{
    public AppSender(String senderName) {
        super(senderName);
    }

    @Override
    public String send(String messenger) {
        return getSenderName() + " đã gửi thông báo App: " + messenger;
    }
}
