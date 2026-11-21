package Test3;

public class EmailSender extends BaseMessageSender{
    public EmailSender(String senderName) {
        super(senderName);
    }

    @Override
    public String send(String messenger) {
        return getSenderName() +  " đã gửi Email: " + messenger;
    }

}
