package pl.bytebay;

import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationFilterSupport;
import javax.management.NotificationListener;

public class BigChangeListener implements NotificationListener {

    private final String notificationType = Notifications.BIG_CHANGE;

    public void handleNotification(Notification notification, Object handback) {
        System.out.println(String.format("Listener %s: %s", notificationType, notification.getMessage()));
    }

    public NotificationFilter getNotificationFilter() {
        NotificationFilterSupport filter = new NotificationFilterSupport();
        filter.enableType(notificationType);
        return filter;
    }
}