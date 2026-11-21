package Test3;

public class SmsSender extends BaseMessageSender{
    public SmsSender(String senderName) {
        super(senderName);
    }

    @Override
    public String send(String messenger) {
        return getSenderName() + " đã gửi SMS: " + messenger;
    }

}
