package com.Springboot_restServices_PUT_DELETE_Request.binding;

public class Customer {
    private Integer cid;
    private String cname;
    private String cemail;

    public Customer(){

    }
    public Customer(Integer cid,String cname,String cemail){
        this.cid = cid;
        this.cname = cname;
        this.cemail = cemail;

    }

    public Integer getCid() {
        return cid;
    }

    public String getCemail() {
        return cemail;
    }

    public String getCname() {
        return cname;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cemail='" + cemail + '\'' +
                '}';
    }
}
