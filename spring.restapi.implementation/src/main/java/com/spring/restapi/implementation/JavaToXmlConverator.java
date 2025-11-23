package com.spring.restapi.implementation;

import com.spring.restapi.implementation.pojo.Book;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class JavaToXmlConverator {
    public static void main(String[] args) throws JAXBException {
        Book b = new Book();
        b.setBookId(201);
        b.setBookPrice(350.00);
        b.setBookName("Hibernate");
   JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(b,System.out);

    }
}
