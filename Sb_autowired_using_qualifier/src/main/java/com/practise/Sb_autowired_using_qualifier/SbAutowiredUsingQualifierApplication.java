package com.practise.Sb_autowired_using_qualifier;

import com.practise.Sb_autowired_using_qualifier.service.ReportGenerateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbAutowiredUsingQualifierApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx  = SpringApplication.run(SbAutowiredUsingQualifierApplication.class, args);
    ReportGenerateService  reportGenerateService  =ctx.getBean(ReportGenerateService.class);
    reportGenerateService.generateReport();
	}

}
