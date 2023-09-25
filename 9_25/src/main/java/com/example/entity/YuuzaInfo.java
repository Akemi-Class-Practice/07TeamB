package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "yuuza_info")
public class YuuzaInfo extends Account {


//    @Column(name = "price")
//    private Integer price;

    
    // TODO 继承了account但这里不写就注册后没法写email到数据库里
    @Column(name = "email")
    private String email;
    
    public String getEmail() {
    	return email;
 }

    public void setEmail(String email) {
    	this.email = email;
 }
    



//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }


}
