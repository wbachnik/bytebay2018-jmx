package pl.bytebay;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Notifications extends NotificationBroadcasterSupport implements NotificationsMBean {

    // notification type name
    public static final String BIG_CHANGE = "pl.bytebay.bigchange";

    private int value;
    private long notificationSequenceNumber;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        int previousValue = this.value;
        this.value = value;

        // built-in notification
        Notification n = new AttributeChangeNotification(
                this,
                ++notificationSequenceNumber,
                System.currentTimeMillis(),
                String.format("Value changed from %d to %d", previousValue, value),
                "Value",
                "int",
                previousValue,
                this.value);
        sendNotification(n);

        // custom notification
        int changeAmount = Math.abs(previousValue-value);
        if (changeAmount > 10) {
            Notification bn = new Notification(
                    BIG_CHANGE,
                    this,
                    ++notificationSequenceNumber,
                    System.currentTimeMillis(),
                    String.format("Big change detected! Difference: %d", changeAmount));
            sendNotification(bn);
        }
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        // provides meta information for clients, not strictly required
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE,
        };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo attributeChangeInfo =
                new MBeanNotificationInfo(types, name, description);

        String[] bigChangeTypes = new String[]{
                BIG_CHANGE,
        };
        MBeanNotificationInfo bigChangeInfo =
                new MBeanNotificationInfo(
                        bigChangeTypes,
                        Notification.class.getName(),
                        "Attribute value change was big");

        return new MBeanNotificationInfo[]{attributeChangeInfo, bigChangeInfo};
    }
}
