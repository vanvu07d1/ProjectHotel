/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Willi
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "ProjectHotel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    @Override
    public Customer findByIdCard(String idCard) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Customer.findByIdCard");
            query.setParameter("idCard", idCard);
            return (Customer) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Customer findByName(String name) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Customer.findByName");
            query.setParameter("name", name);
            return (Customer) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
