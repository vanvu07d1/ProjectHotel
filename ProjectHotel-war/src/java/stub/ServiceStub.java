/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.ServiceFacadeLocal;

/**
 *
 * @author Willi
 */
public class ServiceStub {
    ServiceFacadeLocal serviceFacade = lookupServiceFacadeLocal();

    private ServiceFacadeLocal lookupServiceFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ServiceFacadeLocal) c.lookup("java:global/ProjectHotel/ProjectHotel-ejb/ServiceFacade!sessionbean.ServiceFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Service service) {
        serviceFacade.create(service);
    }

    public void edit(Service service) {
        serviceFacade.edit(service);
    }

    public void remove(Service service) {
        serviceFacade.remove(service);
    }

    public Service find(Object id) {
        return serviceFacade.find(id);
    }

    public List<Service> findAll() {
        return serviceFacade.findAll();
    }

    public List<Service> findRange(int[] range) {
        return serviceFacade.findRange(range);
    }

    public int count() {
        return serviceFacade.count();
    }

    public Service findByName(String name) {
        return serviceFacade.findByName(name);
    }
    
}
