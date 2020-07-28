package corejava.core.enumtest;

import java.util.List;

public class MailReceiver {
    private List<String> receiverList;

    public List<String> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<String> receiverList) {
        this.receiverList = receiverList;
    }

    public MailReceiver(List<String> receiverList) {
        this.receiverList = receiverList;
    }
}
