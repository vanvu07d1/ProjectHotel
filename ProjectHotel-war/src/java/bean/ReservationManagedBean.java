/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Checkin;
import entity.Customer;
import entity.Reservation;
import entity.Room;
import entity.Roomtype;
import entity.Usedservice;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.CustomerStub;
import stub.ReservationStub;
import stub.RoomStub;
import stub.RoomtypeStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class ReservationManagedBean {

    private Reservation reservation;
    private Reservation selectReservation;
    private List<Reservation> listReservation;
    private List<Room> listRoomByRoomTypeId, listAllRoom;
    private List<Room> listRoomWaiting, listRoomBusy, listRoomEmpty;
    private List<Roomtype> listRoomTypeByPeople;
    private int person;
    private Date start, end, current;
    private int id;
    private int roomsSuite, roomsStudio, roomsKing, roomExecutive,
            roomsDeluxeKing, roomsDouble;
    private Customer customer;
    private String message;
    private List<Reservation> listNewReservation;
    private Roomtype selectRoomType;
    private int cusId, roid;
    private List<String> images;
    private List<String> listReqRoom;
    private Room room;

    /**
     * Creates a new instance of ReservationManagedBean
     */
    public ReservationManagedBean() {
        reservation = new Reservation();
        listReservation = new ArrayList<Reservation>();
        listRoomByRoomTypeId = new ArrayList<Room>();
        listAllRoom = new ArrayList<Room>();
        listRoomTypeByPeople = new ArrayList<Roomtype>();
        listRoomEmpty = new ArrayList<Room>();
        listRoomWaiting = new ArrayList<Room>();
        listRoomBusy = new ArrayList<Room>();
        roomExecutive = 0;
        roomsKing = 0;
        roomsDeluxeKing = 0;
        roomsDouble = 0;
        roomsStudio = 0;
        roomsSuite = 0;
        customer = new Customer();
        listNewReservation = new ArrayList<Reservation>();
        current = new Date();
        images = new ArrayList<String>();
        listReqRoom = new ArrayList<String>();
        room = new Room();
    }

    public Integer getReservationId() {
        return reservation.getReservationId();
    }

    public void setReservationId(Integer reservationId) {
        reservation.setReservationId(reservationId);
    }

    public String getCustomerList() {
        return reservation.getCustomerList();
    }

    public void setCustomerList(String customerList) {
        reservation.setCustomerList(customerList);
    }

    public int getNumberOfPeople() {
        return reservation.getNumberOfPeople();
    }

    public void setNumberOfPeople(int numberOfPeople) {
        reservation.setNumberOfPeople(numberOfPeople);
    }

    public Date getDateIn() {
        return reservation.getDateIn();
    }

    public void setDateIn(Date dateIn) {
        reservation.setDateIn(dateIn);
    }

    public Date getDateOut() {
        return reservation.getDateOut();
    }

    public void setDateOut(Date dateOut) {
        reservation.setDateOut(dateOut);
    }

    public Date getBookingDate() {
        return reservation.getBookingDate();
    }

    public void setBookingDate(Date bookingDate) {
        reservation.setBookingDate(bookingDate);
    }

    public Customer getReCustomerId() {
        return reservation.getCustomerId();
    }

    public void setReCustomerId(Customer customerId) {
        reservation.setCustomerId(customerId);
    }

    public Room getRoomId() {
        return reservation.getRoomId();
    }

    public void setRoomId(Room roomId) {
        reservation.setRoomId(roomId);
    }

    public String getReqRoomtype() {
        return reservation.getReqRoomtype();
    }

    public void setReqRoomtype(String reqRoomtype) {
        reservation.setReqRoomtype(reqRoomtype);
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
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

    public List<Room> getListRoomWaiting() {
        return listRoomWaiting;
    }

    public void setListRoomWaiting(List<Room> listRoomWaiting) {
        this.listRoomWaiting = listRoomWaiting;
    }

    public List<Room> getListRoomBusy() {
        return listRoomBusy;
    }

    public void setListRoomBusy(List<Room> listRoomBusy) {
        this.listRoomBusy = listRoomBusy;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomsSuite() {
        return roomsSuite;
    }

    public void setRoomsSuite(int roomsSuite) {
        this.roomsSuite = roomsSuite;
    }

    public int getRoomsStudio() {
        return roomsStudio;
    }

    public void setRoomsStudio(int roomsStudio) {
        this.roomsStudio = roomsStudio;
    }

    public int getRoomsKing() {
        return roomsKing;
    }

    public void setRoomsKing(int roomsKing) {
        this.roomsKing = roomsKing;
    }

    public int getRoomExecutive() {
        return roomExecutive;
    }

    public void setRoomExecutive(int roomExecutive) {
        this.roomExecutive = roomExecutive;
    }

    public int getRoomsDeluxeKing() {
        return roomsDeluxeKing;
    }

    public void setRoomsDeluxeKing(int roomsDeluxeKing) {
        this.roomsDeluxeKing = roomsDeluxeKing;
    }

    public int getRoomsDouble() {
        return roomsDouble;
    }

    public void setRoomsDouble(int roomsDouble) {
        this.roomsDouble = roomsDouble;
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

    public List<Reservation> getListNewReservation() {
        return listNewReservation;
    }

    public void setListNewReservation(List<Reservation> listNewReservation) {
        this.listNewReservation = listNewReservation;
    }

    public Roomtype getSelectRoomType() {
        return selectRoomType;
    }

    public void setSelectRoomType(Roomtype selectRoomType) {
        this.selectRoomType = selectRoomType;
    }

    public Reservation getSelectReservation() {
        return selectReservation;
    }

    public void setSelectReservation(Reservation selectReservation) {
        this.selectReservation = selectReservation;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getRoid() {
        return roid;
    }

    public void setRoid(int roid) {
        this.roid = roid;
    }

    public Date getCurrent() {
        return current;
    }

    public void setCurrent(Date current) {
        this.current = current;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getListReqRoom() {
        return listReqRoom;
    }

    public void setListReqRoom(List<String> listReqRoom) {
        this.listReqRoom = listReqRoom;
    }

    public String findRoomForReservation(Date start, Date end) {
        try {
            RoomStub roomStub = new RoomStub();
            RoomtypeStub roomtypeStub = new RoomtypeStub();
            ReservationStub reservationStub = new ReservationStub();
            //get all room
            listAllRoom = roomStub.findAll();
            //get all reservation
            listReservation = reservationStub.findAll();
            //get roomtypeid by people
            listRoomTypeByPeople = roomtypeStub.findByPeople(getPerson());
            //get Room by roomtypeid
            for (Roomtype roomType : listRoomTypeByPeople) {
                for (Room room : listAllRoom) {
                    if (room.getRoomTypeId().getRoomtypeId() == roomType.getRoomtypeId()) {
                        listRoomByRoomTypeId.add(room);
                    }
                }
            }
            
            
            //check room status
            for (Room room : listRoomByRoomTypeId) {
                if (room.getStatus().equalsIgnoreCase("E")) {
                    listRoomEmpty.add(room);
                }
                if (room.getStatus().equalsIgnoreCase("W")) {
                    listRoomWaiting.add(room);
                }
                if (room.getStatus().equalsIgnoreCase("B")) {
                    listRoomBusy.add(room);
                }
            }
//            get Resvercation by RoomWaittingId
            for (Room room : listRoomWaiting) {
                System.out.println("Room Watting" + room.getRoomId());
                for (Reservation resvervation : listReservation) {
                    if(resvervation.getRoomId() == null){
                        continue;
                    }                    
                    if(resvervation.getRoomId().getRoomId() == room.getRoomId()) {
                        if (resvervation.getDateOut().before(start)) {
                            listRoomEmpty.add(room);
                            continue;
                        }
                        if (resvervation.getDateIn().after(end)) {
                            listRoomEmpty.add(room);
                            continue;
                        }
                    }
                }
            }

            for (Room room : listRoomEmpty) {
                if (room.getRoomTypeId().getRoomtypeId() == 1) {
                    roomsSuite++;
                }
                if (room.getRoomTypeId().getRoomtypeId() == 2) {
                    roomsStudio++;
                }
                if (room.getRoomTypeId().getRoomtypeId() == 3) {
                    roomsKing++;
                }
                if (room.getRoomTypeId().getRoomtypeId() == 4) {
                    roomExecutive++;
                }
                if (room.getRoomTypeId().getRoomtypeId() == 5) {
                    roomsDeluxeKing++;
                }
                if (room.getRoomTypeId().getRoomtypeId() == 6) {
                    roomsDouble++;
                }
            }
            if(roomsSuite != 0){
                listReqRoom.add("Suite");
            }
            if(roomsStudio != 0){
                listReqRoom.add("Studio");
            }
            if(roomsKing != 0){
                listReqRoom.add("King");
            }
            if(roomExecutive != 0){
                listReqRoom.add("Executive");
            }
            if(roomsDouble != 0){
                listReqRoom.add("Double");
            }
            if(roomsDeluxeKing != 0){
                listReqRoom.add("Deluxe King");
            }
            setStart(start);
            setEnd(end);
            
            return "room.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //booking by guest
    public String creatBooking() {
        message = "";
        try {
            CustomerStub customerStub = new CustomerStub();
            customer.setName(getName());
            customer.setDob(getDob());
            customer.setGender(getGender());
            customer.setIdCard(getIdCard());
            customer.setTel(getTel());
            customer.setEmail(getEmail());
            customer.setAddress(getAddress());
            customerStub.create(customer);
            Customer newCustomer = new Customer();
            newCustomer = customerStub.findByIdCard(customer.getIdCard());

            ReservationStub reservationStub = new ReservationStub();
            Reservation newReservation = new Reservation();
            newReservation.setDateIn(start);
            newReservation.setDateOut(end);
            newReservation.setBookingDate(getCurrent());
            newReservation.setNumberOfPeople(person);
            newReservation.setReqRoomtype(getReqRoomtype());
            newReservation.setCustomerId(new Customer(newCustomer.getCustomerId()));
            reservationStub.create(newReservation);
            return message = "bookinginformation";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Reservation> checkNewBooking() {
        try {
            ReservationStub reservationStub = new ReservationStub();
            listReservation = reservationStub.findAll();
            for (Reservation reservation : listReservation) {
                if (reservation.getRoomId() == null) {
                    listNewReservation.add(reservation);
                }
            }
            return listNewReservation;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String editNewBooking(int id) {
        try {
            ReservationStub reservationStub = new ReservationStub();
            reservation = reservationStub.find(id);
            cusId = reservation.getCustomerId().getCustomerId();

            System.out.println(cusId);
            System.out.println(roid);
            java.sql.Date sStart = new java.sql.Date(reservation.getDateIn().getTime());
            java.sql.Date sEnd = new java.sql.Date(reservation.getDateIn().getTime());
            start = sStart;
            end = sEnd;

            return "editBooking";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String editBooking(int id) {
        try {
            ReservationStub reservationStub = new ReservationStub();
            reservation = reservationStub.find(id);
            cusId = reservation.getCustomerId().getCustomerId();
            roid = reservation.getRoomId().getRoomId();
            System.out.println(cusId);
            System.out.println(roid);
            java.sql.Date sDate = new java.sql.Date(reservation.getDateIn().getTime());
            System.out.println(sDate);
            end = reservation.getDateOut();
            System.out.println("AAAAAAAAA" + start);
            return "modifyBooking.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    //method edit new booking
    public String edit() {
        message = "";
        try {
            ReservationStub reservationStub = new ReservationStub();
            Reservation newReservation = new Reservation();
            newReservation.setReservationId(reservation.getReservationId());
            newReservation.setDateIn(reservation.getDateIn());
            newReservation.setDateOut(reservation.getDateOut());
            newReservation.setBookingDate(reservation.getBookingDate());
            newReservation.setNumberOfPeople(reservation.getNumberOfPeople());
            newReservation.setRoomId(new Room(roid));
            RoomStub roomStub = new RoomStub();
            room = roomStub.find(roid);
            System.out.println("RRRRRR" + room.getRoomId());
            room.setStatus("W");
            roomStub.edit(room);
            newReservation.setCustomerId(new Customer(getCusId()));
            newReservation.setReqRoomtype(reservation.getReqRoomtype());
            reservationStub.edit(newReservation);
            return "booking.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    //method manage edit booking
    public String editBooking() {
        message = "";
        try {
            ReservationStub reservationStub = new ReservationStub();
            Reservation newReservation = new Reservation();
            newReservation.setReservationId(reservation.getReservationId());
            newReservation.setDateIn(reservation.getDateIn());
            newReservation.setDateOut(reservation.getDateOut());
            newReservation.setBookingDate(reservation.getBookingDate());
            newReservation.setNumberOfPeople(reservation.getNumberOfPeople());
            newReservation.setRoomId(new Room(roid));
            RoomStub roomStub = new RoomStub();
            room = roomStub.find(roid);
            System.out.println("RRRRRR" + room.getRoomId());
            room.setStatus("W");
            roomStub.edit(room);
            newReservation.setCustomerId(new Customer(getCusId()));
            newReservation.setReqRoomtype(reservation.getReqRoomtype());
            reservationStub.edit(newReservation);
            return "manageBooking.xhtml";
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

    public List<Reservation> findAllReservation() {
        try {
            ReservationStub reservationStub = new ReservationStub();
            for (Reservation r : reservationStub.findAll()) {
                if (r.getRoomId() != null) {
                    listReservation.add(r);
                }
            }
            return listReservation;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<Room> listRoomForReservation(Date start, Date end, int person) {
        try {
            RoomStub roomStub = new RoomStub();
            RoomtypeStub roomtypeStub = new RoomtypeStub();
            ReservationStub reservationStub = new ReservationStub();
            //get all room
            listAllRoom = roomStub.findAll();
            //get all reservation
            listReservation = reservationStub.findAll();
            //get roomtypeid by people            
            listRoomTypeByPeople = roomtypeStub.findByPeople(person);

            //get Room by roomtypeid
            for (Roomtype roomType : listRoomTypeByPeople) {
                for (Room room : listAllRoom) {
                    if (room.getRoomTypeId().getRoomtypeId() == roomType.getRoomtypeId()) {
                        listRoomByRoomTypeId.add(room);
                    }
                }
            }
            //check room status
            for (Room room : listRoomByRoomTypeId) {
                if (room.getStatus().equalsIgnoreCase("E")) {
                    listRoomEmpty.add(room);
                }
                if (room.getStatus().equalsIgnoreCase("W")) {
                    listRoomWaiting.add(room);
                }
                if (room.getStatus().equalsIgnoreCase("B")) {
                    listRoomBusy.add(room);
                }
            }
            //get Resvercation by RoomWaittingId
            for (Room room : listRoomWaiting) {
                for (Reservation resvervation : listReservation) {
                    if(resvervation.getRoomId() == null){
                        continue;
                    }    
                    if (resvervation.getRoomId().getRoomId() == room.getRoomId()) {
                        if (resvervation.getDateOut().before(start)) {
                            listRoomEmpty.add(room);
                            continue;
                        }
                        if (resvervation.getDateIn().after(end)) {
                            listRoomEmpty.add(room);
                            continue;
                        }
                    }
                }
            }
            return listRoomEmpty;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteReservation(int id) {
        try {
            ReservationStub reservationStub = new ReservationStub();
            reservation = reservationStub.find(id);
            reservationStub.remove(reservation);
            reservation = new Reservation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<String> allImages(){
        
        for (int i = 1; i <= 6; i++) {
            images.add("b" + i + ".jpg");
        }
        return images;
    }
}
