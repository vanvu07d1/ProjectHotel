/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Checkin;
import entity.Checkout;
import entity.Customer;
import entity.Reservation;
import entity.Room;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.CheckinStub;
import stub.CustomerStub;
import stub.ReservationStub;
import stub.RoomStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class CheckinManagedBean {

    private Checkin checkin;
    private String message;
    private List<Checkin> listCheckin;
    private List<Reservation> listForCheckin;
    private Date currentDate;
    private Reservation reservation;
    private int cusId, roId;
    private Customer customer;
    private Room room;

    /**
     * Creates a new instance of CheckinManagedBean
     */
    public CheckinManagedBean() {
        checkin = new Checkin();
        listForCheckin = new ArrayList<Reservation>();
        currentDate = new Date();
        customer = new Customer();
        room = new Room();
    }

    public Integer getCheckinId() {
        return checkin.getCheckinId();
    }

    public void setCheckinId(Integer checkinId) {
        checkin.setCheckinId(checkinId);
    }

    public Date getDateIn() {
        return checkin.getDateIn();
    }

    public void setDateIn(Date dateIn) {
        checkin.setDateIn(dateIn);
    }

    public Date getDateOut() {
        return checkin.getDateOut();
    }

    public void setDateOut(Date dateOut) {
        checkin.setDateOut(dateOut);
    }

    public Float getDiscount() {
        return checkin.getDiscount();
    }

    public void setDiscount(Float discount) {
        checkin.setDiscount(discount);
    }

    public Double getRoomCharge() {
        return checkin.getRoomCharge();
    }

    public void setRoomCharge(Double roomCharge) {
        checkin.setRoomCharge(roomCharge);
    }
    
    
    

    public Integer getTax() {
        return checkin.getTax();
    }

    public void setTax(Integer tax) {
        checkin.setTax(tax);
    }

    public int getOutOfTime() {
        return checkin.getOutOfTime();
    }

    public void setOutOfTime(int outOfTime) {
        checkin.setOutOfTime(outOfTime);
    }

   

    public String getRoomStatus() {
        return checkin.getRoomStatus();
    }

    public void setRoomStatus(String roomStatus) {
        checkin.setRoomStatus(roomStatus);
    }

    public String getComment() {
        return checkin.getComment();
    }

    public void setComment(String comment) {
        checkin.setComment(comment);
    }

    public Customer getCustomerId() {
        return checkin.getCustomerId();
    }

    public void setCustomerId(Customer customerId) {
        checkin.setCustomerId(customerId);
    }

    public Room getRoomId() {
        return checkin.getRoomId();
    }

    public void setRoomId(Room roomId) {
        checkin.setRoomId(roomId);
    }

    public List<Checkout> getCheckoutList() {
        return checkin.getCheckoutList();
    }

    public void setCheckoutList(List<Checkout> checkoutList) {
        checkin.setCheckoutList(checkoutList);
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getRoId() {
        return roId;
    }

    public void setRoId(int roId) {
        this.roId = roId;
    }

    public List<Reservation> getListForCheckin() {
        return listForCheckin;
    }

    public void setListForCheckin(List<Reservation> listForCheckin) {
        this.listForCheckin = listForCheckin;
    }

    public List<Reservation> findForCheckin() {
        try {
            java.sql.Date date = new java.sql.Date(currentDate.getTime());
            System.out.println(date);
            ReservationStub reservationStub = new ReservationStub();
            for (Reservation r : reservationStub.findByDateIn(date)) {                
                if (r.getRoomId().getStatus().equalsIgnoreCase("W")) {
                    listForCheckin.add(r);
                }
            }
            return listForCheckin;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String editCheckin(int id) {
        try {
            ReservationStub reservationStub = new ReservationStub();
            reservation = reservationStub.find(id);
            cusId = reservation.getCustomerId().getCustomerId();
            roId = reservation.getRoomId().getRoomId();
            CustomerStub customerStub = new CustomerStub();
            customer = customerStub.find(cusId);
            RoomStub roomStub = new RoomStub();
            room = roomStub.find(roId);
            java.sql.Date sStart = new java.sql.Date(reservation.getDateIn().getTime());
            java.sql.Date sEnd = new java.sql.Date(reservation.getDateIn().getTime());
            checkin.setDateIn(reservation.getDateIn());
            checkin.setDateOut(reservation.getDateOut());
            checkin.setCustomerId(new Customer(reservation.getCustomerId().getCustomerId()));
            checkin.setRoomId(new Room(reservation.getRoomId().getRoomId()));
            System.out.println(cusId);
            System.out.println(roId);
            return "newCheckin.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String addNewCheckin() {
        try {
            CheckinStub checkinStub = new CheckinStub();
            Checkin newCheckin = new Checkin();
            newCheckin.setDateIn(checkin.getDateIn());
            newCheckin.setDateOut(checkin.getDateOut());
            newCheckin.setDiscount(checkin.getDiscount());
            newCheckin.setTax(checkin.getTax());
            newCheckin.setRoomCharge(checkin.getRoomCharge());
            newCheckin.setRoomStatus("B");
            newCheckin.setComment(checkin.getComment());

            System.out.println(cusId + roId);
            newCheckin.setCustomerId(new Customer(cusId));
            newCheckin.setRoomId(new Room(roId));
            RoomStub roomStub = new RoomStub();
            room = roomStub.find(roId);
            room.setStatus("B");
            roomStub.edit(room);
            int stayDate = getStayDate(checkin.getDateIn(), checkin.getDateOut());
            newCheckin.setOutOfTime(stayDate);
            checkinStub.create(newCheckin);
            return "checkin.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int getStayDate(Date start, Date end) {
        long dateDiff = end.getTime() - start.getTime();
        int date = (int) TimeUnit.DAYS.convert(dateDiff, TimeUnit.MILLISECONDS);
        return date;
    }

    public List<Checkin> findAll() {
        try {
            CheckinStub checkinStub = new CheckinStub();
            return checkinStub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteCheckin(int id) {
        try {
            CheckinStub checkinStub = new CheckinStub();
            checkin = checkinStub.find(id);
            checkinStub.remove(checkin);
            checkin = new Checkin();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public Checkin findCheckinById(int id){
        try{
            CheckinStub checkinStub = new CheckinStub();
            checkin = checkinStub.find(id);
            cusId = checkin.getCustomerId().getCustomerId();
            roId = checkin.getRoomId().getRoomId();
            return checkin;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public void edit(){
        try{
            CheckinStub checkinStub = new CheckinStub();
            Checkin newCheckin = new Checkin();
            newCheckin.setCheckinId(checkin.getCheckinId());
            newCheckin.setComment(checkin.getComment());
            newCheckin.setDateIn(checkin.getDateIn());
            newCheckin.setDateOut(checkin.getDateOut());
            newCheckin.setDiscount(checkin.getDiscount());
            newCheckin.setOutOfTime(checkin.getOutOfTime());
            newCheckin.setRoomCharge(checkin.getRoomCharge());
            newCheckin.setTax(checkin.getTax());
            newCheckin.setRoomStatus(checkin.getRoomStatus());
            newCheckin.setCustomerId(new Customer(cusId));
            newCheckin.setRoomId(new Room(roId));
            checkinStub.edit(newCheckin);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
