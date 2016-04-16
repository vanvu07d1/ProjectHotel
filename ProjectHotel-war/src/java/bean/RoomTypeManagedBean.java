/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Room;
import entity.Roomtype;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.RoomtypeStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class RoomTypeManagedBean {

    private Roomtype roomType;
    private List<Roomtype> listRoomTypeByPeople;

    /**
     * Creates a new instance of RoomTypeManagedBean
     */
    public RoomTypeManagedBean() {
        roomType = new Roomtype();
        listRoomTypeByPeople = new ArrayList<Roomtype>();
    }

    public Integer getRoomtypeId() {
        return roomType.getRoomtypeId();
    }

    public void setRoomtypeId(Integer roomtypeId) {
        roomType.setRoomtypeId(roomtypeId);
    }

    public String getRoomtypeName() {
        return roomType.getRoomtypeName();
    }

    public void setRoomtypeName(String roomtypeName) {
        roomType.setRoomtypeName(roomtypeName);
    }

    public float getPrice() {
        return roomType.getPrice();
    }

    public void setPrice(float price) {
        roomType.setPrice(price);
    }

   

    public int getMaxPeople() {
        return roomType.getMaxPeople();
    }

    public void setMaxPeople(int maxPeople) {
        roomType.setMaxPeople(maxPeople);
    }

    public List<Room> getRoomList() {
        return roomType.getRoomList();
    }

    public void setRoomList(List<Room> roomList) {
        roomType.setRoomList(roomList);
    }

    public Roomtype getRoomType() {
        return roomType;
    }

    public void setRoomType(Roomtype roomType) {
        this.roomType = roomType;
    }

    public List<Roomtype> getListRoomTypeByPeople() {
        return listRoomTypeByPeople;
    }

    public void setListRoomTypeByPeople(List<Roomtype> listRoomTypeByPeople) {
        this.listRoomTypeByPeople = listRoomTypeByPeople;
    }

    public List<Roomtype> findRoomTypeByPeople() {
        try {
            RoomtypeStub roomtypeStub = new RoomtypeStub();
            listRoomTypeByPeople = roomtypeStub.findByPeople(getMaxPeople());
            return listRoomTypeByPeople;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Roomtype> findAllRoomtype() {
        RoomtypeStub roomtypeStub = new RoomtypeStub();
        return roomtypeStub.findAll();
    }

}
