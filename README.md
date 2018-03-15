# JMX Workshop @ ByteBay 2018 #
## Resources ##
### JMX Tutorials and Docs ###
[Simple JMX tutorial from Oracle](https://docs.oracle.com/javase/tutorial/jmx/TOC.html)  
[Easy to follow JMX tutorial series, start from the bottom](http://actimem.com/category/java/jmx/)  

[Oracle: Monitoring and Management Using JXM Technology](https://docs.oracle.com/javase/8/docs/technotes/guides/management/agent.html)  
[Oracle: JMX Technology Overview](https://docs.oracle.com/javase/8/docs/technotes/guides/jmx/overview/JMXoverviewTOC.html)  
[Oracle: JMX Technology Tutorial](https://docs.oracle.com/javase/8/docs/technotes/guides/jmx/tutorial/tutorialTOC.html)  
[Oracle: Java SE Monitoring and Management Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/management/toc.html) see **Chapter 2** for remote monitoring security settings!  
[Best practices, a bit outdated (2005?)](http://www.oracle.com/us/technologies/java/best-practices-jsp-136021.html)

### Insecurity ###
[JMX RMI exploit POC](https://www.optiv.com/blog/exploiting-jmx-rmi)

## Frameworks/Libraries ##
[Spring Framework and JMX](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/integration.html#jmx)  
[Dropwizard Metrics](http://metrics.dropwizard.io/4.0.0/getting-started.html)

### Connection Pools ###
[C3P0 JMX](http://www.mchange.com/projects/c3p0/#jmx_configuration_and_management)  
[HikariCP](https://github.com/brettwooldridge/HikariCP/wiki/MBean-\(JMX\)-Monitoring-and-Management)  
[Tomcat JDBC Connection Pool](https://tomcat.apache.org/tomcat-7.0-doc/jdbc-pool.html#JMX)

### Servers ###
[Jetty](https://www.eclipse.org/jetty/documentation/9.4.x/jmx-chapter.html), [Managing Jetty with JConsole and JMC](https://www.eclipse.org/jetty/documentation/9.4.x/jetty-jconsole.html)  
[Tomcat](https://tomcat.apache.org/tomcat-7.0-doc/monitoring.html)  [Cassandra](https://docs.datastax.com/en/cassandra/3.0/cassandra/operations/opsMonitoring.html#opsMonitoringJconsole)  
[Kafka](https://kafka.apache.org/documentation/#monitoring) uses Metrics, actually

## APM (kindof) ##
[Jolokia](https://jolokia.org/) exposes MBeans via HTTP  
[jmxtrans](http://www.jmxtrans.org/) collects attributes and report or push further  
[Prometheus](https://prometheus.io/), [JMX Exporter](https://github.com/prometheus/jmx_exporter)  
[Grafana](https://grafana.com/) dashboarding over Prometheus data
