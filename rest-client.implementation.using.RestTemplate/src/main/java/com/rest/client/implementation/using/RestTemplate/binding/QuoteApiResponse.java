package com.rest.client.implementation.using.RestTemplate.binding;

/* This class hold overall response
* {
     "type": "success",
     "value": {
       "id": ...,
       "quote": "@SpringBoot with @springframwork is pure productivity!..."
     }
}
*
* */
public class QuoteApiResponse {
    private String type;
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "QuoteApiResponse [type=" + type + ", value=" + value + "]";
    }
}
