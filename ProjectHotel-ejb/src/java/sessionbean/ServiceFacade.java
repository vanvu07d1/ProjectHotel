/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Service;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Willi
 */
@Stateless
public class ServiceFacade extends AbstractFacade<Service> implements ServiceFacadeLocal {
    @PersistenceContext(unitName = "ProjectHotel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceFacade() {
        super(Service.class);
    }

    @Override
    public Service findByName(String name) {
       em = getEntityManager();
       try{
           Query quey = em.createNamedQuery("Service.findByServiceName");
           quey.setParameter("serviceName", name);
           return (Service) quey.getSingleResult();
       }catch(Exception ex){
           ex.printStackTrace();
           return null;
       }
    }
    
}
