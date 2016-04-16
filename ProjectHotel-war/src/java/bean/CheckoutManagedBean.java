/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Checkin;
import entity.Checkout;
import entity.Service;
import entity.Usedservice;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.CheckinStub;
import stub.CheckoutStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class CheckoutManagedBean {
    private Checkout checkout;
    private String message;
    private List<Checkout> listCheckout;
    private Checkin checkin;
    private float amountRoom, amountService,amount;
    private float discount,tax;
    private Date current;
    /**
     * Creates a new instance of CheckoutManagedBean
     */
    public CheckoutManagedBean() {
        checkout = new Checkout();
        checkin = new Checkin();
        current = new Date();
    }
    
    public Integer getCheckOutId() {
        return checkout.getCheckOutId();
    }

    public void setCheckOutId(Integer checkOutId) {
        checkout.setCheckOutId(checkOutId);
    }

    public Date getDateChekout() {
        return checkout.getDateChekout();
    }

    public void setDateChekout(Date dateChekout) {
        checkout.setDateChekout(dateChekout);
    }

    public float getTotal() {
        return checkout.getTotal();
    }

    public void setTotal(float total) {
        checkout.setTotal(total);
    }

    public Checkin getCheckInId() {
        return checkout.getCheckInId();
    }

    public void setCheckInId(Checkin checkInId) {
        checkout.setCheckInId(checkInId);
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Checkout> getListCheckout() {
        return listCheckout;
    }

    public void setListCheckout(List<Checkout> listCheckout) {
        this.listCheckout = listCheckout;
    }

    public Checkin getCheckin() {
        return checkin;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    public float getAmountRoom() {
        return amountRoom;
    }

    public void setAmountRoom(int amountRoom) {
        this.amountRoom = amountRoom;
    }

    public float getAmountService() {
        return amountService;
    }

    public void setAmountService(float amountService) {
        this.amountService = amountService;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getCurrent() {
        return current;
    }

    public void setCurrent(Date current) {
        this.current = current;
    }

     
    public void newCheckout(int id){
        try{
            CheckoutStub checkoutStub = new CheckoutStub();
            CheckinStub checkinStub = new CheckinStub();
            checkin = checkinStub.find(id);
            amountRoom = checkin.getRoomId().getRoomTypeId().getPrice() * checkin.getOutOfTime();
            for(Usedservice used : checkin.getUsedserviceList()){
                amountService += used.getTotalPrice();
            }
            
            discount = checkin.getDiscount();
            tax = checkin.getTax();
            amount = amountRoom + amountService ;
            checkout.setTotal( (amountRoom + amountService) - (amountRoom + amountService)*discount/100 + 
                    (amountRoom + amountService)*tax/100 );
            
            checkout.setDateChekout(getCurrent());
            checkout.setCheckInId(new Checkin(id));
            
            checkoutStub.create(checkout);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
