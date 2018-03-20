package pl.bytebay;

import java.util.concurrent.ArrayBlockingQueue;

// note that in case of standard MBean, the implementation class name
// needs to match the MBean interface name.
// That's not enforced in case of MXBean.
public class QueueInfo implements QueueInfoMBean {

    private final ArrayBlockingQueue<String> queue;

    public QueueInfo(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public int getRemainingCapacity() {
        return queue.remainingCapacity();
    }
}
