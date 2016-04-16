/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Service;
import entity.Usedservice;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import stub.ServiceStub;

/**
 *
 * @author Willi
 */
@ManagedBean
@RequestScoped
public class ServiceManagedBean {

    private Service service;
    private String message;
    private List<Service> listAllService;
    private int id;
    private Service selectService;

    /**
     * Creates a new instance of ServiceManagedBean
     */
    public ServiceManagedBean() {
        service = new Service();
        listAllService = new ArrayList<Service>();
    }

    public Integer getServiceId() {
        return service.getServiceId();
    }

    public void setServiceId(Integer serviceId) {
        service.setServiceId(serviceId);
    }

    public String getServiceName() {
        return service.getServiceName();
    }

    public void setServiceName(String serviceName) {
        service.setServiceName(serviceName);
    }

    public String getDescription() {
        return service.getDescription();
    }

    public void setDescription(String description) {
        service.setDescription(description);
    }

    public float getPrice() {
        return service.getPrice();
    }

    public void setPrice(float price) {
        service.setPrice(price);
    }

    

    public List<Usedservice> getUsedserviceList() {
        return service.getUsedserviceList();
    }

    public void setUsedserviceList(List<Usedservice> usedserviceList) {
        service.setUsedserviceList(usedserviceList);
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Service> getListAllService() {
        return listAllService;
    }

    public void setListAllService(List<Service> listAllService) {
        this.listAllService = listAllService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getSelectService() {
        return selectService;
    }

    public void setSelectService(Service selectService) {
        this.selectService = selectService;
    }

    public void addNewService() {
        try {
            ServiceStub serviceStub = new ServiceStub();
            serviceStub.create(service);
            service = new Service();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Service> findAllService() {
        try {
            ServiceStub serviceStub = new ServiceStub();
            return serviceStub.findAll();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Service editService(int id) {
        try {
            ServiceStub serviceStub = new ServiceStub();
            service = serviceStub.find(id);
            return service;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void edit() {
        try {
            ServiceStub serviceStub = new ServiceStub();
            serviceStub.edit(service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteService(int id) {
        try {
            ServiceStub serviceStub = new ServiceStub();
            service = serviceStub.find(id);
            serviceStub.remove(service);
            service = new Service();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
