package com.practise.Sb_autowired_using_qualifier.service;

import com.practise.Sb_autowired_using_qualifier.beans.IReport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ReportGenerateService {

    private IReport iReport;
    ReportGenerateService(@Qualifier("excel") IReport iReport){
        System.out.println("------------Autowiring DI represent using 1-params constructor-------------");
        this.iReport = iReport;
    }


    public void generateReport(){
        this.iReport.generate();
        System.out.println("---------------Report generation completed-------------");
    }
}
