package com.spring.restapi.implementation.pojo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlElement
    private Integer bookId;

    @XmlElement
    private String bookName;

    @XmlElement
    private Double bookPrice;

    public Book() {

    }

    public Book(Integer bookId, String bookName, Double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }

}
