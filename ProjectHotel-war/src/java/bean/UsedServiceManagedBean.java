/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Checkin;
import entity.Checkout;
import entity.Customer;
import entity.Room;
import entity.Service;
import entity.Usedservice;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.CheckinStub;
import stub.CustomerStub;
import stub.RoomStub;
import stub.ServiceStub;
import stub.UsedServiceStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class UsedServiceManagedBean {

    private Usedservice usedService;
    private List<Usedservice> listUsedService;
    private String roomName;
    private Room room;
    private int cusId, roomId, inId;
    private String serviceName, customerName;
    private Checkin checkin;
    private Service service;

    /**
     * Creates a new instance of UsedServiceManagedBean
     */
    public UsedServiceManagedBean() {
        usedService = new Usedservice();
        room = new Room();
        checkin = new Checkin();
        service = new Service();
    }

    public Integer getUsedServiceId() {
        return usedService.getUsedServiceId();
    }

    public void setUsedServiceId(Integer usedServiceId) {
        usedService.setUsedServiceId(usedServiceId);
    }

    public int getAmount() {
        return usedService.getAmount();
    }

    public void setAmount(int amount) {
        usedService.setAmount(amount);
    }

    public float getTotalPrice() {
        return usedService.getTotalPrice();
    }

    public void setTotalPrice(float totalPrice) {
        usedService.setTotalPrice(totalPrice);
    }

    public Date getDateUsed() {
        return usedService.getDateUsed();
    }

    public void setDateUsed(Date dateUsed) {
        usedService.setDateUsed(dateUsed);
    }

    public Checkin getCheckinId() {
        return usedService.getCheckinId();
    }

    public void setCheckinId(Checkin checkinId) {
        usedService.setCheckinId(checkinId);
    }

    public Service getServiceId() {
        return usedService.getServiceId();
    }

    public void setServiceId(Service serviceId) {
        usedService.setServiceId(serviceId);
    }

    public Usedservice getUsedService() {
        return usedService;
    }

    public void setUsedService(Usedservice usedService) {
        this.usedService = usedService;
    }

    public List<Usedservice> getListUsedService() {
        return listUsedService;
    }

    public void setListUsedService(List<Usedservice> listUsedService) {
        this.listUsedService = listUsedService;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Checkin getCheckin() {
        return checkin;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getInId() {
        return inId;
    }

    public void setInId(int inId) {
        this.inId = inId;
    }

    public void addUsedService() {
        try {
            UsedServiceStub usedStub = new UsedServiceStub();
            RoomStub roomStub = new RoomStub();
            room = roomStub.findByRoomName(getRoomName());
            roomId = room.getRoomId();
            System.out.println(roomId);

            CheckinStub checkinStub = new CheckinStub();
            for (Checkin c : checkinStub.findAll()) {
                if (c.getRoomId().getRoomId() == roomId) {
                    checkin = c;
                }
            }

            serviceName = getServiceName();
            System.out.println(serviceName);
            ServiceStub serviceStub = new ServiceStub();
            service = serviceStub.findByName(serviceName);

            float price = service.getPrice();
            int amount = usedService.getAmount();
            float totalPrice = price * amount;

            Usedservice used = new Usedservice();

            used.setAmount(amount);
            used.setTotalPrice(totalPrice);
            used.setServiceId(new Service(service.getServiceId()));
            used.setDateUsed(usedService.getDateUsed());
            used.setCheckinId(new Checkin(checkin.getCheckinId()));

            usedStub.create(used);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Usedservice> findAll() {
        try {
            UsedServiceStub usedStub = new UsedServiceStub();
            return usedStub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Usedservice findById(int id) {
        try {
            UsedServiceStub usedStub = new UsedServiceStub();
            usedService = usedStub.find(id);
            serviceName = usedService.getServiceId().getServiceName();
            customerName = usedService.getCheckinId().getCustomerId().getName();
            roomName = usedService.getCheckinId().getRoomId().getRoomName();
            inId = usedService.getCheckinId().getCheckinId();
            System.out.println("BBBBBBB"+inId);
            return usedService;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void edit() {
        try {
            UsedServiceStub usedStub = new UsedServiceStub();
            Usedservice used = new Usedservice();

            //get service id//
            serviceName = getServiceName();
            inId = getInId();
            System.out.println(serviceName);
            ServiceStub serviceStub = new ServiceStub();
            service = serviceStub.findByName(serviceName);

            used.setUsedServiceId(usedService.getUsedServiceId());
            
            used.setAmount(usedService.getAmount());
          
            used.setTotalPrice(usedService.getTotalPrice());
          
            used.setServiceId(new Service(service.getServiceId()));
        
            used.setDateUsed(usedService.getDateUsed());
          
            used.setCheckinId(new Checkin(inId));
            System.out.println("DDDDD"+inId);
            usedStub.edit(used);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUsed(int id) {
        try {
            UsedServiceStub usedStub = new UsedServiceStub();
            usedService = usedStub.find(id);
            usedStub.remove(usedService);
            usedService = new Usedservice();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
