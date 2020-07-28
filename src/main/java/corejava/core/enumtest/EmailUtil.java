package corejava.core.enumtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EmailUtil {

    private static MailReceiver devReceiver;
    private static MailReceiver supportReceiver;

    static {
        List<String> devReceivers = new ArrayList<>();
        devReceivers.add("dev@foxmail.com");
        devReceiver = new MailReceiver(devReceivers);
        List<String> supportReceivers = new ArrayList<>();
        supportReceivers.add("support@foxmail.com");
        supportReceiver = new MailReceiver(supportReceivers);
    }

    public enum Receiver {
        DEV("dev", devReceiver),
        SUPPORT("value", supportReceiver);

        private String key;
        private MailReceiver value;

        Receiver(String key, MailReceiver value) {
            this.key = key;
            this.value = value;
        }

        public static MailReceiver getMailReceiver(String who) {
            Optional<Receiver> first = Arrays.stream(Receiver.values()).filter(receiver -> {
                int ordinal = receiver.ordinal();
                System.out.println(ordinal);
                return receiver.key.equals(who);
            })
                    .findFirst();
            return first.isPresent() ? first.get().value : null;
        }
    }
}
