package pl.bytebay.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class HelloResource {

    @GET
    @Timed
    public String sayHello() {
        return "Hello there!";
    }
}
