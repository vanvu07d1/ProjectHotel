/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stub;

import entity.Reservation;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.ReservationFacadeLocal;

/**
 *
 * @author Willi
 */
public class ReservationStub {
    ReservationFacadeLocal reservationFacade = lookupReservationFacadeLocal();

    private ReservationFacadeLocal lookupReservationFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (ReservationFacadeLocal) c.lookup("java:global/ProjectHotel/ProjectHotel-ejb/ReservationFacade!sessionbean.ReservationFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void create(Reservation reservation) {
        reservationFacade.create(reservation);
    }

    public void edit(Reservation reservation) {
        reservationFacade.edit(reservation);
    }

    public void remove(Reservation reservation) {
        reservationFacade.remove(reservation);
    }

    public Reservation find(Object id) {
        return reservationFacade.find(id);
    }

    public List<Reservation> findAll() {
        return reservationFacade.findAll();
    }

    public List<Reservation> findRange(int[] range) {
        return reservationFacade.findRange(range);
    }

    public int count() {
        return reservationFacade.count();
    }

    public List<Reservation> findByRoomId(int roomid) {
        return reservationFacade.findByRoomId(roomid);
    }

    public List<Reservation> findByDateIn(Date dateIn) {
        return reservationFacade.findByDateIn(dateIn);
    }
    
    
}
