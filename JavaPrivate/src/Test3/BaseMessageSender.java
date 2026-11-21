package Test3;

public abstract class BaseMessageSender implements MessageSender{
    private String senderName;

    public BaseMessageSender(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public static void notifyUser(MessageSender sender, String message) {
        System.out.println(sender.send(message));
    }
}