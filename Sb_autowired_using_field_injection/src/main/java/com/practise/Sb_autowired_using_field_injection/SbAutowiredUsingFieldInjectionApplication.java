package com.practise.Sb_autowired_using_field_injection;

import com.practise.Sb_autowired_using_field_injection.Service.ReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbAutowiredUsingFieldInjectionApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx =  SpringApplication.run(SbAutowiredUsingFieldInjectionApplication.class, args);
     ReportService reportService =  ctx.getBean(ReportService.class);

     reportService.generateReport();
	}

}
