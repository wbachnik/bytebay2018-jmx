package pl.bytebay;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jmx.JmxReporter;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import pl.bytebay.resources.HelloResource;

import java.util.Random;

public class JmxDemoApplication extends Application<JmxDemoConfiguration> {


    public static void main(final String[] args) throws Exception {
        // drop in some extra metric
        final MetricRegistry metrics = new MetricRegistry();
        metrics.register(MetricRegistry.name("pl.bytebay.dropwizard", "random", "value"),
                new Gauge<Integer>() {
                    private final Random random = new Random();
                    @Override
                    public Integer getValue() {
                        return random.nextInt(10);
                    }
                });
        // without that we won't see anything
        final JmxReporter reporter = JmxReporter.forRegistry(metrics).build();
        reporter.start();

        new JmxDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizardjmxdemo";
    }

    @Override
    public void initialize(final Bootstrap<JmxDemoConfiguration> bootstrap) {
    }

    @Override
    public void run(final JmxDemoConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloResource());
    }

}
