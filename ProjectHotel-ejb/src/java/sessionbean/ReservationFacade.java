/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Reservation;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Willi
 */
@Stateless
public class ReservationFacade extends AbstractFacade<Reservation> implements ReservationFacadeLocal {
    @PersistenceContext(unitName = "ProjectHotel-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationFacade() {
        super(Reservation.class);
    }
    
    @Override
    public List<Reservation> findByRoomId(int roomid) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Reservation.findByRoomId");
            query.setParameter("roomId", roomid);
            return query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> findByDateIn(Date dateIn) {
        em = getEntityManager();
        try{
            Query query = em.createNamedQuery("Reservation.findByDateIn");
            query.setParameter("dateIn", dateIn);
            return query.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
   }
}
