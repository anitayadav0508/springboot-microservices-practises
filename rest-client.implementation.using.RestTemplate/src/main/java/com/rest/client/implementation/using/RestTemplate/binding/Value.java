package com.rest.client.implementation.using.RestTemplate.binding;

/*
* This class holds only
*        "id": ...,
       "quote": "@SpringBoot with @springframwork is pure productivity!..."
*
* */
public class Value {
    private Integer id;
    private String quote;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Value [id=" + id + ", quote=" + quote + ", author=" + author + "]";
    }
}
