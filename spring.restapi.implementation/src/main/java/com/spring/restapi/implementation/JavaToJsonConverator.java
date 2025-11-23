package com.spring.restapi.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.restapi.implementation.pojo.Book;

public class JavaToJsonConverator {
    public static void main(String[] args) throws JsonProcessingException {

        Book book = new Book();
        book.setBookId(101);
        book.setBookName("The Complete Java Book");
        book.setBookPrice(250.0);
        //convert book data to json
        ObjectMapper mapper = new ObjectMapper();
        String json =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
        System.out.println(json);
    }
}
