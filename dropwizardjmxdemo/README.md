# dropwizardjmxdemo

How to start the dropwizardjmxdemo application
---

1. Run `mvn clean package` to build your application
1. Start application with `java -jar target/dropwizardjmxdemo-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:9000/hello`
1. To check metric reporting offered by the Metrics library, enter url `http://localhost:9001/metrics?pretty=true`, also see what's under `http://localhost:9001/`

Using Prometheus JMX Exporter
---

Download agent jar from https://github.com/prometheus/jmx_exporter

Start application with `java -javaagent:./jmx_prometheus_javaagent-0.3.0.jar=9010:prometheus_config.yaml -jar target/dropwizardjmxdemo-1.0-SNAPSHOT.jar server config.yml`

Getting data into Prometheus
--- 

Add the following scrape config to your `prometheus.yml` file in the Prometheus install directory:
```
  - job_name: 'dropwizard'
    static_configs:
      - targets: ['localhost:9010']
```
