package com.practise.Sb_autowired_using_qualifier.beans;

import org.springframework.stereotype.Component;

@Component("excel")
public class ExcelReport implements  IReport{

    ExcelReport(){
        System.out.println("---------------- ExcelReport Constructor  " +
                "Represent ExcelReport as spring bean due to @component annotation--------------");
    }


    public void generate(){
        System.out.println("------------Excel Report Generating-------------");
    }
}
