package com.springboot_springwebmvc_implementation_using_jsp.pojo;

public class Insurance {

    private Number planId;
    private String planName;
    private String planStatus;
    public Insurance(){

    }

    public Insurance(Number planId,String planName,String planStatus){

        this.planId = planId;
        this.planName = planName;
        this.planStatus = planStatus;
    }


    public void setPlanId(Number planId) {
        this.planId = planId;
    }

    public void setPlanName(String planName){
        this.planName = planName;
    }

    public  void setPlanStatus(String planStatus){
        this.planStatus = planStatus;
    }

    public Number getPlanId() {
        return planId;
    }

    public String getPlanName(){
        return planName;
    }

    public String getPlanStatus(){
        return planStatus;
    }
}
