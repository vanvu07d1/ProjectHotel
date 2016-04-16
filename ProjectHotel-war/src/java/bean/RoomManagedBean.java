/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Checkin;
import entity.Reservation;
import entity.Room;
import entity.Roomtype;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.RoomStub;
import stub.RoomtypeStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class RoomManagedBean {

    private Room room;
    private int typeId;
    private List<Room> listRoomByRoomTypeId, listAllRoom, listRoomEmpty;
    private List<Roomtype> listRoomTypeByPeople;
    private int person;
    private Room selectRoom;
    private String selectRoomtype;
    private String message;

    /**
     * Creates a new instance of RoomManagedBean
     */
    public RoomManagedBean() {
        room = new Room();
        listRoomByRoomTypeId = new ArrayList<Room>();
        listAllRoom = new ArrayList<Room>();
        listRoomTypeByPeople = new ArrayList<Roomtype>();
        listRoomEmpty = new ArrayList<Room>();
    }

    public Integer getRoomId() {
        return room.getRoomId();
    }

    public void setRoomId(Integer roomId) {
        room.setRoomId(roomId);
    }

    public String getRoomName() {
        return room.getRoomName();
    }

    public void setRoomName(String roomName) {
        room.setRoomName(roomName);
    }

    public int getNumberOfBed() {
        return room.getNumberOfBed();
    }

    public void setNumberOfBed(int numberOfBed) {
        room.setNumberOfBed(numberOfBed);
    }

    public String getRoomPhone() {
        return room.getRoomPhone();
    }

    public void setRoomPhone(String roomPhone) {
        room.setRoomPhone(roomPhone);
    }

    public String getDescription() {
        return room.getDescription();
    }

    public void setDescription(String description) {
        room.setDescription(description);
    }

    public String getStatus() {
        return room.getStatus();
    }

    public void setStatus(String status) {
        room.setStatus(status);
    }

    public List<Checkin> getCheckinList() {
        return room.getCheckinList();
    }

    public void setCheckinList(List<Checkin> checkinList) {
        room.setCheckinList(checkinList);
    }

    public List<Reservation> getReservationList() {
        return room.getReservationList();
    }

    public void setReservationList(List<Reservation> reservationList) {
        room.setReservationList(reservationList);
    }

    public Roomtype getRoomTypeId() {
        return room.getRoomTypeId();
    }

    public void setRoomTypeId(Roomtype roomTypeId) {
        room.setRoomTypeId(roomTypeId);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public List<Room> getListRoomByRoomTypeId() {
        return listRoomByRoomTypeId;
    }

    public void setListRoomByRoomTypeId(List<Room> listRoomByRoomTypeId) {
        this.listRoomByRoomTypeId = listRoomByRoomTypeId;
    }

    public List<Room> getListAllRoom() {
        return listAllRoom;
    }

    public void setListAllRoom(List<Room> listAllRoom) {
        this.listAllRoom = listAllRoom;
    }

    public List<Room> getListRoomEmpty() {
        return listRoomEmpty;
    }

    public void setListRoomEmpty(List<Room> listRoomEmpty) {
        this.listRoomEmpty = listRoomEmpty;
    }

    public List<Roomtype> getListRoomTypeByPeople() {
        return listRoomTypeByPeople;
    }

    public void setListRoomTypeByPeople(List<Roomtype> listRoomTypeByPeople) {
        this.listRoomTypeByPeople = listRoomTypeByPeople;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public Room getSelectRoom() {
        return selectRoom;
    }

    public void setSelectRoom(Room selectRoom) {
        this.selectRoom = selectRoom;
    }

    public String getSelectRoomtype() {
        return selectRoomtype;
    }

    public void setSelectRoomtype(String selectRoomtype) {
        this.selectRoomtype = selectRoomtype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Room> findRoomByRoomTypeId() {
        try {
            RoomStub roomStub = new RoomStub();
            RoomtypeStub roomtypeStub = new RoomtypeStub();
            listAllRoom = roomStub.findAll();
            listRoomTypeByPeople = roomtypeStub.findByPeople(getPerson());
            for (Roomtype roomType : listRoomTypeByPeople) {
                for (Room room : listAllRoom) {
                    if (room.getRoomTypeId().getRoomtypeId() == roomType.getRoomtypeId()) {
                        listRoomByRoomTypeId.add(room);
                    }
                }
            }
            return listRoomByRoomTypeId;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void addNewRoom() {
        try {
            RoomStub roomStub = new RoomStub();
            Room newRoom = new Room();
            newRoom.setRoomName(room.getRoomName());
            newRoom.setRoomPhone(room.getRoomPhone());
            newRoom.setDescription(room.getDescription());
            newRoom.setStatus(room.getStatus());
            typeId = Integer.parseInt(getSelectRoomtype());
            newRoom.setRoomTypeId(new Roomtype(typeId));
            roomStub.create(newRoom);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Room> findAllRoom() {
        RoomStub roomStub = new RoomStub();
        return roomStub.findAll();
    }
    
    public Room edit(int id){
        try{
            RoomStub roomStub = new RoomStub();
            room = roomStub.find(id);
            return room;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public String editRoom() {
        message = "";
        try {
            RoomStub roomStub = new RoomStub();
            Room newRoom = new Room();
            newRoom.setRoomId(room.getRoomId());
            newRoom.setRoomName(room.getRoomName());
            newRoom.setRoomPhone(room.getRoomPhone());
            
            newRoom.setStatus(room.getStatus());
            typeId = Integer.parseInt(getSelectRoomtype());
            newRoom.setRoomTypeId(new Roomtype(typeId));
            roomStub.edit(newRoom);
            return message = "Service has been edited";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteRoom(int id) {
        try {
            RoomStub roomStub = new RoomStub();
            room  = roomStub.find(id);
            roomStub.remove(room);
            room = new Room();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
