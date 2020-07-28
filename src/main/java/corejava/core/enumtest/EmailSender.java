package corejava.core.enumtest;

import java.util.ArrayList;
import java.util.List;

public class EmailSender {

    public static void main(String[] args) {

        List<String> restaurant = new ArrayList<>();
        restaurant.add("Ido");
        restaurant.add("pandaExpress");
        restaurant.add("Opa!");
        if (restaurant.stream().anyMatch(res -> {
            return res.startsWith("Id");
        })) {
            System.out.println("bad restaurant detected");
        } else {
            System.out.println("all good");
        }


        MailReceiver dev = EmailUtil.Receiver.getMailReceiver("devf");
        if (dev != null) {
            dev.getReceiverList().stream().forEach(a -> System.out.println(a));
        } else {
            System.out.println(dev);
        }

    }
}
