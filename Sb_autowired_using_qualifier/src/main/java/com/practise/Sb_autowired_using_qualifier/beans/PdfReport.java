package com.practise.Sb_autowired_using_qualifier.beans;

import org.springframework.stereotype.Component;

@Component("pdf")
public class PdfReport implements IReport{
    PdfReport(){
        System.out.println("-----------Pdf Report constructor   " + "Represent PdfReport as spring bean using annotation @component");
    }

    @Override
    public void generate() {
        System.out.println("-------Pdf Report Generating------");

    }
}
