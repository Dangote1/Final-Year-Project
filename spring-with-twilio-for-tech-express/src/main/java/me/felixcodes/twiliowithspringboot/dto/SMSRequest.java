package me.felixcodes.twiliowithspringboot.dto;

import lombok.ToString;

@ToString
public class SMSRequest {

    private String phoneNumber;
    private String ticketId;
    private String price;
    private String name;

    public SMSRequest(String phoneNumber,String ticketId,String price,String name) {
        this.phoneNumber = phoneNumber;
        this.ticketId = ticketId;
        this.price = price;
        this.name = name;
    }

    public SMSRequest(){}

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
