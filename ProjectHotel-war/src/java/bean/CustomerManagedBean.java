/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Checkin;
import entity.Customer;
import entity.Reservation;
import entity.Usedservice;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.CustomerStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class CustomerManagedBean {

    private Customer customer;
    private Customer selectCustomer;
    private String message;
    private List<Customer> listCustomer;

    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
        customer = new Customer();
    }

    public Integer getCustomerId() {
        return customer.getCustomerId();
    }

    public void setCustomerId(Integer customerId) {
        customer.setCustomerId(customerId);
    }

    public String getName() {
        return customer.getName();
    }

    public void setName(String name) {
        customer.setName(name);
    }

    public String getTel() {
        return customer.getTel();
    }

    public void setTel(String tel) {
        customer.setTel(tel);
    }

    public String getEmail() {
        return customer.getEmail();
    }

    public void setEmail(String email) {
        customer.setEmail(email);
    }

    public String getGender() {
        return customer.getGender();
    }

    public void setGender(String gender) {
        customer.setGender(gender);
    }

    public String getAddress() {
        return customer.getAddress();
    }

    public void setAddress(String address) {
        customer.setAddress(address);
    }

    public String getIdCard() {
        return customer.getIdCard();
    }

    public void setIdCard(String idCard) {
        customer.setIdCard(idCard);
    }

    public Date getDob() {
        return customer.getDob();
    }

    public void setDob(Date dob) {
        customer.setDob(dob);
    }

    public List<Checkin> getCheckinList() {
        return customer.getCheckinList();
    }

    public void setCheckinList(List<Checkin> checkinList) {
        customer.setCheckinList(checkinList);
    }
    

    public List<Reservation> getReservationList() {
        return customer.getReservationList();
    }

    public void setReservationList(List<Reservation> reservationList) {
        customer.setReservationList(reservationList);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public Customer getSelectCustomer() {
        return selectCustomer;
    }

    public void setSelectCustomer(Customer selectCustomer) {
        this.selectCustomer = selectCustomer;
    }

    public void addCustomer() {
        try {
            CustomerStub customerStub = new CustomerStub();
            Customer newCustomer = new Customer();
            newCustomer.setName(customer.getName());
            newCustomer.setGender(customer.getGender());
            newCustomer.setDob(customer.getDob());
            newCustomer.setTel(customer.getTel());
            newCustomer.setAddress(customer.getAddress());
            newCustomer.setEmail(customer.getEmail());
            newCustomer.setIdCard(customer.getIdCard());
            customerStub.create(newCustomer);
            customer = new Customer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Customer editCustomer(int id) {
        try {
            CustomerStub customerStub = new CustomerStub();
            customer = customerStub.find(id);
            return customer;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void edit() {
        try {
            CustomerStub customerStub = new CustomerStub();
            customerStub.edit(customer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Customer> findAllCustomer() {
        try {
            CustomerStub customerStub = new CustomerStub();
            return customerStub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteCustomer(int id) {
        try {
            CustomerStub customerStub = new CustomerStub();
            customer = customerStub.find(id);
            customerStub.remove(customer);
            customer = new Customer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
