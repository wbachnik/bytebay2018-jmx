package pl.bytebay.jmxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@EnableMBeanExport
public class JmxdemoApplication {

    private final RequestStats requestsBean = new RequestStats();

	@RequestMapping("/")
	String home() {
        requestsBean.increaseRequestCount();
		return "Hello World!";
	}

    @Bean
    public RequestStats requests() {
        return requestsBean;
    }

	public static void main(String[] args) {
	    SpringApplication.run(JmxdemoApplication.class, args);
	}
}
