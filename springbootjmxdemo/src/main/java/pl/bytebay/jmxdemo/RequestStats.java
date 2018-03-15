package pl.bytebay.jmxdemo;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@ManagedResource(objectName = "pl.bytebay:type=Requests")
public class RequestStats {
    AtomicLong requestsServed = new AtomicLong();

    @ManagedAttribute(description = "Cumulative number of requests served")
    public long getRequestsServed() {
        return requestsServed.get();
    }

    public void increaseRequestCount() {
        this.requestsServed.incrementAndGet();
    }

    @ManagedOperation(description = "Assigns new value to the request counter")
    public void setRequestsServed(long requestsServed) {
        this.requestsServed.set(requestsServed);
    }
}