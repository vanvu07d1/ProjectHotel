/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Checkin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Willi
 */
@Stateless
public class CheckinFacade extends AbstractFacade<Checkin> implements CheckinFacadeLocal {
    @PersistenceContext(unitName = "ProjectHotel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CheckinFacade() {
        super(Checkin.class);
    }

    @Override
    public Checkin findByRoomId(int id) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Checkin.findByRoomId");
            query.setParameter("roomId", id);
            return (Checkin) query.getSingleResult();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        }
    
}
