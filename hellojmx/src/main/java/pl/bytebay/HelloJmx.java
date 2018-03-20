package pl.bytebay;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.ArrayBlockingQueue;

public class HelloJmx {

    public static void main(String ... args) throws Exception {
        System.out.println("Hello!");

        SimpleResource sr = new SimpleResource("PlainSimpleResource", 500);
        // ObjectName: domain:key=value,key=value
        ObjectName mbeanName = new ObjectName("pl.bytebay:type=SimpleResource");

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        mbs.registerMBean(sr, mbeanName);

        mbs.registerMBean(new SimpleResource("SimpleResource1", 100), new ObjectName("pl.bytebay:type=SimpleResourceGroup,name=Demo1"));
        mbs.registerMBean(new SimpleResource("SimpleResource2", 200), new ObjectName("pl.bytebay:type=SimpleResourceGroup,name=Demo2"));

        SimpleResourceMX srmx = new SimpleResourceMX("PlainSimpleResourceMX", 800);
        ObjectName mxBeanName = new ObjectName("pl.bytebay:type=SimpleResourceMX");
        mbs.registerMBean(srmx, mxBeanName);

        ObjectName notificationsBeanName = new ObjectName("pl.bytebay:type=Notifications");
        mbs.registerMBean(new Notifications(), notificationsBeanName);

        // we can listen to our own notifications
        BigChangeListener bigChangeListener = new BigChangeListener();
        mbs.addNotificationListener(new ObjectName("pl.bytebay:type=Notifications"), bigChangeListener, bigChangeListener.getNotificationFilter(), null);

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        queue.size();
        queue.remainingCapacity();

        QueueInfo qi = new QueueInfo(queue);
        mbs.registerMBean(qi, new ObjectName("pl.bytebay:type=QueueInfo"));

        Thread.sleep(Integer.MAX_VALUE);
    }
}
